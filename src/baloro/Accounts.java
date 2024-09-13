package baloro;

class Accounts {
        private final int id;
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String username;
        private final String password;

        public Accounts(int id, String firstName, String lastName, String email, String username, String password) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.username = username;
            this.password = password;
        }


        public int getId() {
            return id; 
        }

        public void view() {
            System.out.printf("%-10s %-15s %-15s %-30s %-15s\n", "ID", "First Name", "Last Name", "Email", "Username");
            System.out.printf("%-10d %-15s %-15s %-30s %-15s\n", id, firstName, lastName, email, username);
        }
    }
