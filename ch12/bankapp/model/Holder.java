package gr.aueb.cf.oop.ch12.bankapp.model;

/**
 * Defines a {@link Holder} class.
 * It includes a {@link #id}, {@link #firstname},
 * {@link #lastname} and {@link #ssn}
 *
 * @since 0.1
 * @version 1.0
 * @author hmego
 */
public final class Holder {
    private final long id;
    private final String firstname;
    private final String lastname;
    private final String ssn;

    /**
     * Default Constructor
     */
    public Holder() {
        id = 0L;
        firstname = "";
        lastname = "";
        ssn = "";
    }

    /**
     * Overloaded Constructor
     * @param firstname holder's firstname
     * @param lastname  holder's lastname
     * @param ssn       holder's ssn
     */
    public Holder(long id, String firstname, String lastname, String ssn) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    /**
     * Gets holder's id
     * @return holder's id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets holder's firstname
     * @return holder's firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Gets holder's lastname
     * @return  holder's lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Gets holder's ssn
     * @return  holder's ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Returns the state of this Holder
     * @return  the id, firstname, lastname and ssn of this Holder
     */
    public String convertToString() {
        return "(" + id + ", " + firstname + ", " + lastname + ", "
                + ssn + ")";
    }
}
