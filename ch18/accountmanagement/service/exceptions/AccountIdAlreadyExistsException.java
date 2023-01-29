package gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;

public class AccountIdAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountIdAlreadyExistsException(Account account) {
        super("Account with id " + account.getId() + " already exists");
    }
}
