package uses;

import prompts.PromptIterator;
import users.Administrator;
import users.Customer;
import users.User;
import Presenter.UserManagerPresenter;
import Presenter.IUserManagerPresenter;

import java.util.ArrayList;

public class UserManager {

    private PromptIterator uf = new PromptIterator();
    private IUserManagerPresenter ump;

    private final ArrayList<User> accounts;

    public UserManager() {
        this.accounts = new ArrayList<>();
        ump = new UserManagerPresenter();

    }

    public ArrayList<User> getAccounts() {
        return accounts;
    }

    /**
     * Creates a customer.
     *
     * @param username Users.Customer's username
     * @param password Users.Customer's password
     * @return Users.Customer
     */

    public Customer createCustomer (String username, String password){
        Customer c = new Customer(username, password);
        accounts.add(c);
        return c;
    }


    /** Creates an administrator.
     * @param username Users.Administrator's username
     * @param password Users.Administrator's password
     * @return Users.Administrator
     */

    public Administrator createAdministrator (String username, String password){
        Administrator a = new Administrator(username, password);
        accounts.add(a);
        return a;
    }

    public void register(String username, String password){
        Customer c;register(username,password);

    }

    public void exit() {
        uf.saveUserToFile();

    }


}
