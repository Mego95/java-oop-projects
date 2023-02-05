package gr.aueb.cf.oop.ch19;

import gr.aueb.cf.oop.ch18.accountmanagement.dao.IAccountManagementDao;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManagementDaoMapImpl implements IAccountManagementDao {
    private static final Map<String, Account> accounts = new HashMap<>();


    @Override
    public Account insert(Account account) {
        accounts.put(account.getIban(), account);
        return account;
    }

    @Override
    public Account update(Account account) {
        return accounts.put(account.getIban(), account);
    }

    @Override
    public void delete(String iban) {
        accounts.remove(iban);
    }

    @Override
    public Account get(String iban) {
        return accounts.get(iban);
    }

    @Override
    public Account get(Long id) {
        return accounts.get(getIbanById(id));
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public boolean accountIbanExists(String iban) {
        return accounts.containsKey(iban);
    }

    @Override
    public boolean accountIdExists(Long id) {
        return accounts.containsKey(getIbanById(id));
    }

    @Override
    public boolean isUserValid(String ssn, String iban) {
        return accounts.get(iban).getHolder().getSsn().equals(ssn);
    }

    private String getIbanById(Long id) {
        String key = null;

        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                key = entry.getKey();
            }
        }

        return key;
    }
}
