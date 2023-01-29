package gr.aueb.cf.oop.ch18.accountmanagement.model;

public class Account extends AbstractEntity {
    private Holder holder;
    private double balance;
    private String iban;

    public Account() {}

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder=" + holder +
                ", balance=" + balance +
                ", iban='" + iban + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

//        if (Double.compare(account.getBalance(), getBalance()) != 0) return false;
//        if (getHolder() != null ? !getHolder().equals(account.getHolder()) : account.getHolder() != null) return false;
//        return getIban() != null ? getIban().equals(account.getIban()) : account.getIban() == null;
        return getIban().equals(account.getIban());
    }

    @Override
    public int hashCode() {
//        int result;
//        long temp;
//        result = getHolder() != null ? getHolder().hashCode() : 0;
//        temp = Double.doubleToLongBits(getBalance());
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (getIban() != null ? getIban().hashCode() : 0);
//        return result;

        return getIban().hashCode();
    }
}
