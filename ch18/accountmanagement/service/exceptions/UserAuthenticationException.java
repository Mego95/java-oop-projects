package gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Holder;

public class UserAuthenticationException extends Exception {
    private final static long serialVersionUID = 1L;

    public UserAuthenticationException(Holder user, Account account) {
        super("User with ssn " + user.getSsn() + " does not have access to account with iban " + account.getIban());
    }
}
