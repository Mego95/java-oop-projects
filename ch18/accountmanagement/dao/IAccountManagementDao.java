package gr.aueb.cf.oop.ch18.accountmanagement.dao;

import gr.aueb.cf.oop.ch18.accountmanagement.model.Account;
import gr.aueb.cf.oop.ch18.accountmanagement.model.Holder;

import java.util.List;

public interface IAccountManagementDao {

    /**
     * Inserts an instance of {@link Account} into the data source
     *
     * @param account
     *          the model object that contains the account data
     * @return
     *          the {@link Account} added
     */
    Account insert(Account account);

    /**
     * Updates a {@link Account} instance in the data source
     *
     * @param account
     *          the model object that contains the account data
     * @return
     *          the instance {@link Account} before the update
     */
    Account update(Account account);

    /**
     * Removes a {@link Account} instance from the data source
     *
     * @param iban
     *          the {@link Account#iban} of the instance to be removed
     */
    void delete(String iban);

    /**
     * Returns a {@link Account} instance from the data source
     * based on iban
     *
     * @param iban
     *          the {@link Account#iban} of the instance to be returned
     * @return
     *          the resulting {@link Account} instance
     */
    Account get(String iban);

    /**
     * Returns a {@link Account} instance from the data source
     * based on id
     *
     * @param id
     *          the {@link Account#id} of the instance to be returned
     * @return
     *          the resulting {@link Account} instance
     */
    Account get(Long id);

    /**
     * Returns all the {@link Account} instances currently in the data source
     *
     * @return
     *          the resulting {@link List<Account>}
     */
    List<Account> getAll();

    /**
     * Checks if a {@link Account} instance already exists in the data source
     * based on input iban
     *
     * @param iban
     *          the <code>iban</code> to be checked
     * @return
     *          returns true if found else false
     */
    boolean accountIbanExists(String iban);

    /**
     * Checks if a {@link Account} instance already exists in the data source
     * based on input id
     *
     * @param id
     *          the <code>id</code> to be checked
     * @return
     *          returns true if found else false
     */
    boolean accountIdExists(Long id);

    /**
     * Checks if the {@link Holder} trying to make a transaction owns the
     * {@link Account} by checking their ssn against the account's by getting
     * the account from input iban
     * @param ssn
     *          the <code>ssn</code> of Holder trying to make a transaction
     * @param iban
     *          the <code>iban</code> of the Account the transaction is made
     * @return
     *          returns true if Holder matches the Holder of the Account
     *          else false
     */
    boolean isUserValid(String ssn, String iban);
}
