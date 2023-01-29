package gr.aueb.cf.oop.ch18.accountmanagement.service;

import gr.aueb.cf.oop.ch18.accountmanagement.dto.AccountDTO;
import gr.aueb.cf.oop.ch18.accountmanagement.dto.HolderDTO;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Holder;
import gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions.*;

public interface IAccountManagementService {

    /**
     * Creates a {@link Account} based on the data carried by the {@link AccountDTO}
     *
     * @param accountDTO
     *          the DTO object that contains the Account data
     * @return
     *          the resulting {@link Account}
     * @throws IbanAlreadyExistsException
     *          if the {@link Account#iban} already exists in the data source
     * @throws AccountIdAlreadyExistsException
     *          if the {@link Account#id} already exists in the data source
     */
    Account insertAccount(AccountDTO accountDTO) throws IbanAlreadyExistsException, AccountIdAlreadyExistsException;

    /**
     * Updates a {@link Account} based on the data carried by the {@link AccountDTO}
     *
     * @param accountDTO
     *          the DTO object that contains the Account data
     * @return
     *          the {@link Account} before the update
     * @throws AccountNotFoundException
     *          if the {@link AccountDTO#iban} does not map
     *          to a {@link Account} in the data source
     * @throws IbanAlreadyExistsException
     *          if the {@link Account#iban} already exists in the data source
     */
    Account updateAccount(AccountDTO accountDTO) throws AccountNotFoundException, IbanAlreadyExistsException;

    /**
     * Deletes a {@link Account}
     *
     * @param iban
     *          the {@link Account#iban} of the account needed to be removed
     * @throws AccountNotFoundException
     *          if the {@link Account#iban} already exists in the data source
     */
    void deleteAccount(String iban) throws AccountNotFoundException;

    /**
     * Returns a {@link Account} from the data source based on iban
     *
     * @param iban
     *          the {@link Account#iban} of the account instance to be returned
     * @return
     *          the {@link Account} resulting instance
     * @throws AccountNotFoundException
     *          if the {@link Account#iban} already exists in the data source
     */
    Account getAccount(String iban) throws AccountNotFoundException;

    /**
     * Returns a {@link Account} from the data source based on id
     *
     * @param id
     *          the {@link Account#id} of the account instance to be returned
     * @return
     *          the {@link Account} resulting instance
     * @throws AccountNotFoundException
     *          if the {@link Account#id} already exists in the data source
     */
    Account getAccount(Long id) throws AccountNotFoundException;

    /**
     * Withdraws an amount of money from {@link Account}
     *
     * @param holderDTO
     *          the DTO object that contains the data of the user trying to withdraw
     * @param accountDTO
     *          the DTO object that contains the account data
     * @param amount
     *          the amount to be withdrawn
     * @return
     *          the {@link Account} before the transaction
     * @throws AccountNotFoundException
     *          if the {@link Account#iban} already exists in the data source
     * @throws UserAuthenticationException
     *          if the {@link Holder#ssn} does not match the accounts
     * @throws InvalidAmountException
     *          if the amount trying to be withdrawn is a negative number
     * @throws InsufficientBalanceException
     *          if the amount trying to be withdrawn is greater than {@link Account#balance}
     */
    Account withdraw(HolderDTO holderDTO, AccountDTO accountDTO, double amount) throws AccountNotFoundException,
            UserAuthenticationException, InvalidAmountException, InsufficientBalanceException;

    /**
     * Deposits an amount of money to {@link Account}
     *
     * @param holderDTO
     *          the DTO object that contains the data of the user trying to deposit
     * @param accountDTO
     *          the DTO object that contains the account data
     * @param amount
     *          the amount to be deposited
     * @return
     *          the {@link Account} before the transaction
     * @throws AccountNotFoundException
     *          if the {@link Account#iban} already exists in the data source
     * @throws UserAuthenticationException
     *          if the {@link Holder#ssn} does not match the accounts
     * @throws InvalidAmountException
     *          if the amount trying to be deposited is a negative number
     */
    Account deposit(HolderDTO holderDTO, AccountDTO accountDTO, double amount) throws AccountNotFoundException,
            UserAuthenticationException, InvalidAmountException;
}
