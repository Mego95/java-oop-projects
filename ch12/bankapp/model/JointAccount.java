package gr.aueb.cf.oop.ch12.bankapp.model;

/**
 * Defines a {@link JointAccount} class.
 * It is a bank account with 2 {@link Holder}
 * {@link #holder1} and {@link #holder2}, {@link #iban}
 * and {@link #balance}. Provides mutator method for balance:
 * {@link #setBalance(double)}.
 *
 * @since 0.1
 * @version 1.0
 * @author hmego
 */
public final class JointAccount {
    private final Holder holder1;
    private final Holder holder2;
    private final String iban;
    private double balance;

    /**
     * Default Constructor
     */
    public JointAccount() {
        holder1 = new Holder();
        holder2 = new Holder();
        iban = "";
    }

    /**
     * Overloaded Constructor
     * @param holder1 JointAcount's first holder
     * @param holder2 JointAcount's second holder
     * @param iban    JointAcount's iban
     * @param balance JointAcount's balance
     */
    public JointAccount(Holder holder1, Holder holder2, String iban, double balance) {
        this.holder1 = holder1;
        this.holder2 = holder2;
        this.iban = iban;
        this.balance = balance;
    }

    /**
     * Gets JointAcount's holder1
     * @return JointAcount's holder1
     */
    public Holder getHolder1() {
        return holder1;
    }

    /**
     * Gets JointAcount's holder2
     * @return JointAcount's holder2
     */
    public Holder getHolder2() {
        return holder2;
    }

    /**
     * Gets JointAcount's iban
     * @return JointAcount's iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * Gets JointAcount's balance
     * @return JointAcount's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets JointAcount's balance
     * @param balance JointAcount's new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Withdraws an amount from JointAccount's balance
     * based on the ssns provided.
     *
     * @param amount        the amount to be withdrawn
     * @param ssnHolder1    holder1's ssn
     * @param ssnHolder2    holder2's ssn
     * @throws Exception    if the amount is greater than the balance
     *                      or if the ssns of holders are not valid
     */
    public void withdraw(double amount, String ssnHolder1, String ssnHolder2) throws Exception {
        try {
            if (!isSsnValid(ssnHolder1, ssnHolder2)) throw new Exception("Ssns provided not valid");

            if (amount <= balance) {
                balance -= amount;
            } else {
                throw new Exception("Insufficient funds");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    /**
     * Returns the state of this JointAccount
     * @return the state of holder1, the state of holder2, iban and balance
     */
    public String convertToString() {
        return "(" + holder1.convertToString() + ", " + holder2.convertToString() + ", "
                + iban + ", " + balance + ")";
    }

    private boolean isSsnValid(String ssnHolder1, String ssnHolder2) {
        return holder1.getSsn().equals(ssnHolder1) && holder2.getSsn().equals(ssnHolder2);
    }
}
