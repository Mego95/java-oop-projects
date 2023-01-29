package gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;

public class InsufficientBalanceException extends Exception {
    private final static long serialVersionUID = 1L;

    public InsufficientBalanceException(Account account, double amount) {
        super("Account with iban " + account.getIban() + " does not have enough balance to withdraw " +
                amount);
    }
}
