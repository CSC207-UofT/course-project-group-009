package View;

import controller.UserManagerController;
import uses.UserManager;
import UseCases.IUserManaging;
import UseCases.UserManaging;
import java.util.Scanner;


public class textUI {
    public static void main(String[] args) {
        UserManager manage = new UserManager();

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println(" Please enter: 1 for register, 2 for login or 0 for exist");
            int option = in.nextInt();

            if (option == 1) {
                System.out.println("Please enter your username:");
                in.nextLine();
                String username = in.nextLine();
                System.out.println("Please enter your password:");
                String password = in.nextLine();
                manage.createCustomer(username, password);
            }
            else if (option == 2) {
                System.out.println("Please enter your username:");
                in.nextLine();
                String username = in.nextLine();
                System.out.println("Please enter your password:");
                String password = in.nextLine();
                manage.register(username, password);
            }
            else if (option == 0) {
                manage.exit();
                break;
            }
        }
    }
}
