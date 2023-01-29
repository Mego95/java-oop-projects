package gr.aueb.cf.oop.ch18.accountmanagement.dto;

public class HolderDTO {
    private Long holderID;
    private String firstname;
    private String lastname;
    private String ssn;

    public HolderDTO() {}

    public Long getHolderID() {
        return holderID;
    }

    public void setHolderID(Long holderID) {
        this.holderID = holderID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
