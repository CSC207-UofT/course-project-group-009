package uses;

import controller.UserManagerController;
import Gateway.UserReadWriter;
import Gateway.UserReadWriter;
import Presenter.UserManagerPresenter;
import Presenter.IUserManagerPresenter;
import UseCases.UserManaging;

import java.util.ArrayList;

public class UserManager {

    private UserManagerController umc;
    private UserManaging uming;
    private UserReadWriter ufrw = new UserReadWriter();
    private IUserManagerPresenter iump;

    private final ArrayList<User> accounts;

    public UserManager() {
        this.accounts = new ArrayList<>();

        ArrayList userList = ufrw.readUserFromFile()
        iump = new UserManagerPresenter();
        uming = new UserManager(userList, iump);
        umc = new UserManagerController(uming);

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
        umc.register(username,password);

    }

    public void login(String username, String password){
        umc.login(username, password);
    }

    public void exit() {
        ufrw.saveUserToFile(UserManaging.userlist);

    }


}
