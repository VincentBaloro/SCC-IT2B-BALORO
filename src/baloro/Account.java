package baloro;

import java.util.Scanner;
import java.util.regex.Pattern;

class Account {
    private Accounts[] accounts;

    public void addAccounts(Scanner scanner) {
        System.out.print("Enter the number of accounts to create: ");
        int numAccounts = scanner.nextInt();
        scanner.nextLine();

        accounts = new Accounts[numAccounts];

        for (int i = 0; i < numAccounts; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            accounts[i] = registerAccount(scanner, i);
        }

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an account to view:");
            for (int i = 0; i < numAccounts; i++) {
                System.out.println((i + 1) + ". Account " + (i + 1));
            }
            System.out.println((numAccounts + 1) + ". Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= numAccounts) {
                accounts[choice - 1].view();
            } else if (choice == numAccounts + 1) {
                running = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public Accounts registerAccount(Scanner scanner, int currentIndex) {
        int id;
        boolean isDuplicate;

        do {
            isDuplicate = false;
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < currentIndex; j++) {
                if (accounts[j] != null && accounts[j].getId() == id) {
                    System.out.println("Error: ID " + id + " is already taken. Please enter a different ID.");
                    isDuplicate = true;
                }
            }
        } while (isDuplicate);

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        String password;
        while (true) {
            System.out.print("Password: ");
            password = scanner.nextLine();

            if (isValidPassword(password, firstName, lastName, username)) {
                break; 
            } else {
                System.out.println("Password does not meet criteria. Please try again.");
            }
        }

        return new Accounts(id, firstName, lastName, email, username, password);
    }

    private boolean isValidPassword(String password, String firstName, String lastName, String username) {
        if (password.length () <8) {
            System.out.println("Password must be at least 8 characters.");
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find() ||
            !Pattern.compile("[a-z]").matcher(password).find() ||
            !Pattern.compile("[0-9]").matcher(password).find() ||
            !Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.");
            return false;
        }

        String[] commonPasswords = { "admin1234", "password", "1234", firstName.toLowerCase(), lastName.toLowerCase(), username.toLowerCase() };
        for (String common : commonPasswords) {
            if (password.equals(common)) {
                System.out.println("Password cannot be a common password.");
                return false;
            }
        }

        return true; 
    }
}