package gr.aueb.cf.oop.ch18.accountmanagement.dto;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Holder;

public class AccountDTO {
    private Long accountID;
    private String iban;
    private double balance;
    private HolderDTO holderDTO;

    public AccountDTO() {}

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public HolderDTO getHolderDTO() {
        return holderDTO;
    }

    public void setHolderDTO(HolderDTO holderDTO) {
        this.holderDTO = holderDTO;
    }
}
