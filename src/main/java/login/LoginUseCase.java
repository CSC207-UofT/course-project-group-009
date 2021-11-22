package login;

import java.io.IOException;


public abstract class LoginUseCase implements LoginInputBoundary {

    private final UserList users;


    UserReadWriter areadWriter = new UserReadWriter();


    public enum AttemptResult {
        SUCCESS, FAILURE
    }

    public LoginUseCase(UserList users){
        this.users = users;
        try {
            areadWriter.saveToFile("user.ser", users);
        } catch (IOException ae) {
            System.out.println("not saved.");
        }
    }

    public LoginResult logIn(String username, String passwprd) {
        User user = users.getUser(username);
        if (user.passwordMatches(password)){
            return LoginResult.SUCCESS;
        }else{
            return LoginResult.FAILURE;
        }
    }
}
