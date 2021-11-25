package UseCases;

public interface IUserManaging {
    String getUsername(String username);
    void verifyUser(String id, String password);
    void createRegularUser(String username, String pw);

}