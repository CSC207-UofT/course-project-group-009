package UseCases;


import users.*;
import Presenter.IUserManagerPresenter;


import java.util.ArrayList;

public abstract class UserManaging implements IUserManaging{
    public static ArrayList<User> userlist;
    private final IUserManagerPresenter presenter;

    public UserManaging(ArrayList<User> userList, IUserManagerPresenter presenter){
        this.presenter = presenter;
        this.userlist = userList;
    } //denpendcy injection

    public String getUser(String username){
        for(User u : userlist){
            if(u.getUsername().equals(username))
                return u.toString();
        }
        return "no such user";
    }

    public void verifyUser(String id, String password){
        for(User u : userlist){
            if(u.getUsername().equals(id) && u.getPassword().equals(password)) {
                presenter.showLoginResponse(true);
                return;
            }
        }
        presenter.showLoginResponse(false);
    }

    public void createRegularUser(String username, String password){
        User user = new User(username, password);
        userlist.add(user);

        presenter.showRegisterResponse(true);
    }

}