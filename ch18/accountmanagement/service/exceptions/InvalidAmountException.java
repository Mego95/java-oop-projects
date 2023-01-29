package gr.aueb.cf.oop.ch18.accountmanagement.service.exceptions;

public class InvalidAmountException extends Exception {
    private final static long serialVersionUID = 1L;

    public InvalidAmountException(double amount) {
        super("Amount " + amount + " can not be negative");
    }
}
