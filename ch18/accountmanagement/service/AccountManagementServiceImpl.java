package gr.aueb.cf.oop.ch18.accountmanagement.service;

import gr.aueb.cf.oop.ch18.accountmanagement.dao.IAccountManagementDao;
import gr.aueb.cf.oop.ch18.accountmanagement.dto.AccountDTO;
import gr.aueb.cf.oop.ch18.accountmanagement.dto.HolderDTO;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Holder;
import gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions.*;

public class AccountManagementServiceImpl implements IAccountManagementService {

    private final IAccountManagementDao dao;

    public AccountManagementServiceImpl(IAccountManagementDao dao) {
        this.dao = dao;
    }

    @Override
    public Account insertAccount(AccountDTO accountDTO)
            throws IbanAlreadyExistsException, AccountIdAlreadyExistsException {
        try {
            Account accountToInsert = new Account();

            mapAccount(accountToInsert, accountDTO);

            if (dao.accountIbanExists(accountToInsert.getIban())) {
                throw new IbanAlreadyExistsException(accountToInsert);
            }

            if (dao.accountIdExists(accountToInsert.getId())) {
                throw new AccountIdAlreadyExistsException(accountToInsert);
            }

            return dao.insert(accountToInsert);
        } catch (IbanAlreadyExistsException | AccountIdAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account updateAccount(AccountDTO accountDTO) throws AccountNotFoundException, IbanAlreadyExistsException {
        try {
            Account accountToUpdate = new Account();

            mapAccount(accountToUpdate, accountDTO);

            if (!dao.accountIdExists(accountToUpdate.getId())) {
                throw new AccountNotFoundException(accountToUpdate.getId());
            }

            if (dao.accountIbanExists(accountToUpdate.getIban())) {
                throw new IbanAlreadyExistsException(accountToUpdate);
            }

            return dao.update(accountToUpdate);
        } catch (AccountNotFoundException | IbanAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAccount(String iban) throws AccountNotFoundException {
        try {
            if (!dao.accountIbanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            dao.delete(iban);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccount(String iban) throws AccountNotFoundException {
        try {
            if (!dao.accountIbanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            return dao.get(iban);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccount(Long id) throws AccountNotFoundException {
        try {
            if (!dao.accountIdExists(id)) {
                throw new AccountNotFoundException(id);
            }

            return dao.get(id);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account withdraw(HolderDTO holderDTO, AccountDTO accountDTO, double amount)
            throws AccountNotFoundException, UserAuthenticationException,
            InvalidAmountException, InsufficientBalanceException {
        try {
            Account accountToWithdraw = new Account();
            mapAccount(accountToWithdraw, accountDTO);

            Holder user = new Holder();
            mapHolder(user, holderDTO);

            if (!dao.accountIbanExists(accountToWithdraw.getIban())) {
                throw new AccountNotFoundException(accountToWithdraw);
            }

            if (!dao.isUserValid(user.getSsn(), accountToWithdraw.getIban())) {
                throw new UserAuthenticationException(user, accountToWithdraw);
            }

            if (amount < 0) {
                throw new InvalidAmountException(amount);
            }

            if (amount > accountToWithdraw.getBalance()) {
                throw new InsufficientBalanceException(accountToWithdraw, amount);
            }

            accountToWithdraw.setBalance(accountToWithdraw.getBalance() - amount);
            return dao.update(accountToWithdraw);
        } catch (AccountNotFoundException | UserAuthenticationException
        | InvalidAmountException | InsufficientBalanceException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account deposit(HolderDTO holderDTO, AccountDTO accountDTO, double amount)
            throws AccountNotFoundException, UserAuthenticationException, InvalidAmountException {
        try {
            Account accountToDeposit = new Account();
            mapAccount(accountToDeposit, accountDTO);

            Holder user = new Holder();
            mapHolder(user, holderDTO);

            if (!dao.accountIbanExists(accountToDeposit.getIban())) {
                throw new AccountNotFoundException(accountToDeposit);
            }

            if (!dao.isUserValid(user.getSsn(), accountToDeposit.getIban())) {
                throw new UserAuthenticationException(user, accountToDeposit);
            }

            if (amount < 0) {
                throw new InvalidAmountException(amount);
            }

            accountToDeposit.setBalance(accountToDeposit.getBalance() + amount);
            return dao.update(accountToDeposit);
        } catch (AccountNotFoundException | UserAuthenticationException | InvalidAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Maps a {@link AccountDTO} to a {@link Account}
     *
     * @param account
     *          the {@link Account} under creation
     * @param accountDTO
     *          the account transfer object
     */
    private void mapAccount(Account account, AccountDTO accountDTO) {
        account.setId(accountDTO.getAccountID());

        Holder holder = new Holder();
        mapHolder(holder, accountDTO.getHolderDTO());

        account.setHolder(holder);
        account.setIban(accountDTO.getIban());
        account.setBalance(accountDTO.getBalance());

    }

    /**
     * Mpas a {@link HolderDTO} to a {@link  Holder}
     *
     * @param holder
     *          the {@link Holder} under creation
     * @param holderDTO
     *          the holder transfer object
     */
    private void mapHolder(Holder holder, HolderDTO holderDTO) {
        holder.setId(holderDTO.getHolderID());
        holder.setFirstname(holderDTO.getFirstname());
        holder.setLastname(holderDTO.getLastname());
        holder.setSsn(holderDTO.getSsn());
    }
}
