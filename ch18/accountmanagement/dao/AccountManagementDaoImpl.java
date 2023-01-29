package gr.aueb.cf.oop.ch18.accountmanagement.dao;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManagementDaoImpl implements IAccountManagementDao {
    private final static List<Account> accounts = new ArrayList<>();

    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        return accounts.set(getIndexById(account.getId()), account);
    }

    @Override
    public void delete(String iban) {
        accounts.removeIf(account -> account.getIban().equals(iban));
    }

    @Override
    public Account get(String iban) {
        return accounts.get(getIndexByIban(iban));
    }

    @Override
    public Account get(Long id) {
        return accounts.get(getIndexById(id));
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public boolean accountIbanExists(String iban) {
        return getIndexByIban(iban) != -1;
    }

    @Override
    public boolean accountIdExists(Long id) {
        return getIndexById(id) != -1;
    }

    @Override
    public boolean isUserValid(String ssn, String iban) {
        Account account = accounts.get(getIndexByIban(iban));

        return  account.getHolder().getSsn().equals(ssn);
    }

    /**
     * Returns the position in the ArrayList data source
     * of the {@link Account} containing the input <code>iban</code>
     *
     * @param iban
     *          the {@link Account#iban} to be searched
     * @return
     *          the resulting position or -1
     *          if iban is not found
     */
    private int getIndexByIban(String iban) {
        int position = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getIban().equals(iban)) {
                position = i;
            }
        }

        return position;
    }

    /**
     * Returns the position in the ArrayList data source
     * of the {@link Account} containing the input <code>id</code>
     *
     * @param id
     *          the {@link Account#id} to be searched
     * @return
     *          the resulting position or -1
     *          if id is not found
     */
    private int getIndexById(Long id) {
        int position = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                position = i;
            }
        }

        return position;
    }
}
