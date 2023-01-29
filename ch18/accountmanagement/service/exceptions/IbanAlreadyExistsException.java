package gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;

public class IbanAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public IbanAlreadyExistsException(Account account) {
        super("Account with iban " + account.getIban() + " already exists");
    }
}
