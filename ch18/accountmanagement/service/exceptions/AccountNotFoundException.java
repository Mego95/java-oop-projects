package gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;

public class AccountNotFoundException extends Exception {
    private final static long serialVersionUID = 1L;

    public AccountNotFoundException(String iban) {
        super("The account with iban " + iban + " was not found");
    }

    public AccountNotFoundException(Long id) {
        super("The account with id " + id + " was not found");
    }

    public AccountNotFoundException(Account account) {
        super("The account with iban " + account.getIban() + " and id "
        + account.getId() + " was not found");
    }
}
