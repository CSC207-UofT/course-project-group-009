package controller;

import Gateway.UserReadWriter;
import UseCases.IUserManaging;
import UseCases.UserManaging;

import java.util.ArrayList;

public class UserManagerController{
    private IUserManaging um;
    public UserManagerController(UserManaging um){
        this.um = um;
    }
    public void register(String username, String password){
        um.createRegularUser(username,password);
    }

    public void login(String username, String password){
        um.verifyUser(username, password);
    }

}