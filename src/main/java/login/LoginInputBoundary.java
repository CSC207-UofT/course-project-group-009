package login;

public interface LoginInputBoundary {
    LoginUseCase.LoginResult logIn(String username, String password);

    LoginUseCase.LoginResult logIn(String administratorcode);
}
