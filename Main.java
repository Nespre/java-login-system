import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        AuthService authenticator = new AuthService(repository);
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> friends = new ArrayList<>(Arrays.asList("Mihai", "Amor", "Tomy boy"));
        friends.get(1);
        boolean loop = true;
        while (loop) {
            System.out.println("\nWhat you what to do?");
            System.out.println("1 - Login\n2 - Registrar");
            String option = scanner.nextLine().trim().toLowerCase();

            if (option.equals("1") || option.equals("login")) option = "1";
            else if (option.equals("2") || option.equals("register")) option = "2";

            String name = "";
            String username = "";
            String password = "";

            if (option.equals("1") || option.equals("2")){
                String[] userinfo = getUserInfo(scanner, option);
                name = userinfo[0];
                username = userinfo[1];
                password = userinfo[2];
            }

            switch(option) {
                case "1" -> {
                    //Login
                    if (authenticator.login(username, password)) {
                        System.out.println("✅ Successful login");
                    } else {
                        System.out.println("❌ Invalid credentials");
                    }
                }
                case "2" -> {
                    //Register
                    if (authenticator.register(name, username, password)) {
                        System.out.println("✅ User successfully registered");
                    } else {
                        System.out.println("❌ User already exists");
                    }
                }
                default -> System.out.println("❗Invalid Option");
            }
            System.out.println("\nRestart? (Y/N)");
            String restart = scanner.nextLine();

            if (!restart.equalsIgnoreCase("Y")) {
                loop = false;
                scanner.close();}
        }
    }

    public static String[] getUserInfo(Scanner scanner, String choice) {
        if (choice.equals("1")) System.out.println("\n---------LOGIN SECTION---------");
        else if (choice.equals("2")) System.out.println("\n---------REGISTER SECTION---------");

        String name = "";
        if (choice.equals("2")) {System.out.print("What is your Name?\n\t|");
            name = scanner.nextLine();}

        if (choice.equals("2")) System.out.print("Define a unique Username\n\t|");
        else if (choice.equals("1")) System.out.print("Username\n\t|");
        String username = scanner.nextLine();

        if (choice.equals("2")) System.out.print("Define a Password\n\t|");
        else if (choice.equals("1")) System.out.print("Password\n\t|");
        String password = scanner.nextLine();

        return new String [] {name, username, password};
    }
}
