package gr.aueb.cf.oop.ch12.bankapp.model;

/**
 * Defines a {@link OverdraftAccount} class.
 * It has a {@link Holder} field {@link #holder}, an {@link #iban}
 * and allows the {@link #holder}
 * to withdraw an amount of money greater than their {@link #balance}
 * loaning them the missing amount {@link #loanAmount}.
 */
public class OverdraftAccount {
    private final Holder holder;
    private final String iban;
    private double balance;
    private double loanAmount;

    /**
     * Default Constructor
     */
    public OverdraftAccount() {
        holder = new Holder();
        iban = "";
    }

    /**
     * Overloaded Constructor
     * @param holder        OverdraftAccount's holder
     * @param iban          OverdraftAccount's iban
     * @param balance       OverdraftAccount's balance
     */
    public OverdraftAccount(Holder holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    /**
     * Gets OverdraftAccount's holder
     * @return OverdraftAccount's holder
     */
    public Holder getHolder() {
        return holder;
    }

    /**
     * Gets OverdraftAccount's iban
     * @return OverdraftAccount's iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * Gets OverdraftAccount's balance
     * @return OverdraftAccount's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets OverdraftAccount's balance
     * @param balance OverdraftAccount's new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Gets OverdraftAccount's loanAmount
     * @return OverdraftAccount's loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets OverdraftAccount's loanAmount
     * @param loanAmount    OverdraftAccount's new loanAmount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Withdraws an amount from JointAccount's balance
     * based on the ssn provided. If the amount to
     * be withdrawn is greater than balance then a loan
     * is credited to the holder
     *
     * @param amount        amount to be withdrawn
     * @param ssn           social security number
     * @throws Exception    if the ssn of holder is not valid
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSsnValid(ssn)) throw new Exception("Ssn not valid");

            if (amount <= balance) {
                balance -= amount;
            } else {
                loanAmount = -(balance - amount);
                balance = 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Returns the state of this OverdraftAccount
     * @return the state of the holder, iban, balance and loanAmount
     */
    public String convertToString() {
        return "(" + holder.convertToString() + ", " + iban + ", " + balance + ", "
                + loanAmount + ")";
    }

    private boolean isSsnValid(String ssn) {
        return holder.getSsn().equals(ssn);
    }
}
