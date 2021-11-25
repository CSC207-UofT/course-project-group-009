package users;
import java.io.Serializable;
public class User implements Serializable{

    public String username;
    public String password;


    /** An initializer for Uses.User
     * @param username Uses.User's username
     * @param password Uses.User's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Getter method for user's username.
     * @return Users.Customer's username
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String userid){
        this.username = userid;
    }

    /** Getter method for user's password
     * @return Users.Customer's password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "username" + this.username;
    }
}
