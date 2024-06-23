import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("UTP A Cinema", 2); // Membuat bioskop dengan nama "UTP A Cinema" dan 2 studio

        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== UTP A Cinema ===");
            System.out.println("Menu:"); // nantinya pengguna diminta untuk memilih antara login, registrasi, atau keluar dari program.
            System.out.println("1. Login"); 
            // ketika pengguna memilih point 1, maka pengguna akan diminta untuk memasukkan email dan password, yang sebelumnya telah di dapatkan ketika melakukan registasi.
            // dan ketika data yang dimasukkan ke opsi login sesuai dengan register maka akan ditujukan ke menu dasbor. pada dasbor ini pengguna dapat memilih berbagai opsi lagi nantinya
            System.out.println("2. Register"); // pada opsi 2 ini pengguna diminta untuk memasukkan informasi seperti nama lengkap, email, password, dan saldo awal.
            System.out.println("3. Exit");
            System.out.print("Pick your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumes newline character

            switch (choice) {
                case 1:
                    // Login
                    System.out.print("Email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPassword = scanner.nextLine();

                    currentUser = cinema.authenticateUser(loginEmail, loginPassword);
                    if (currentUser != null) {
                        System.out.println("Login successful.");

                        // Menu dashboard setelah login
                        boolean loggedIn = true;
                        while (loggedIn) {
                            System.out.println("\nWelcome " + currentUser.getFullName() + " to " + cinema.getName() + "!");
                            System.out.println("Menu:");
                            System.out.println("1. Book Ticket");
                            System.out.println("2. Display My Tickets");
                            System.out.println("3. Display List of Studios");
                            System.out.println("4. Display Studio Detail");
                            System.out.println("5. Top Up Balance");
                            System.out.println("6. Exit Program");
                            System.out.print("Pick your choice: ");

                            int loggedInChoice = scanner.nextInt();
                            scanner.nextLine(); // Consumes newline character

                            switch (loggedInChoice) {
                                case 1:
                                    // Book Ticket
                                    // pada opsi ini nantinya pengguna akan diminta memaskukkan beberapa ketentuan, seperti:
                                    System.out.print("Enter studio number: "); //nomor studio, terdapat 2 ketersediaan studio (1/2)
                                    int studioNumber = scanner.nextInt();
                                    System.out.print("Enter row number: "); //pengguna berkesempatan memilih baris dari seet tempat yang ingin di pesan
                                    int row = scanner.nextInt();
                                    System.out.print("Enter column number: "); //lalu pengguna juga berkesempatan memilih kolom dari seet tempat yang ingin di pesan
                                    int col = scanner.nextInt();

                                    if (cinema.bookTicket(currentUser, studioNumber, row, col)) {
                                        System.out.println("Ticket booked successfully.");
                                    } else {
                                        System.out.println("Ticket booking failed.");
                                    }
                                    break;
                                case 2:
                                    // Display My Tickets
                                    currentUser.displayAllTickets(); //nantinya akan menampilkan keseluruhan tiket yang telah di pesan pengguna 
                                    break;
                                case 3:
                                    // Display List of Studios
                                    cinema.displayListStudio(); //nantinya akan menampilkan daftar keseluruhan dari studio yang tersedia 
                                    break;
                                case 4:
                                    // Display Studio Detail
                                    System.out.print("Enter studio number: "); //nantinya bisa untuk memasukkan nomor studio dan dapat menampilkan detail movie
                                    int detailStudioNumber = scanner.nextInt();
                                    cinema.displayStudioDetail(detailStudioNumber);
                                    break;
                                case 5:
                                    // Top Up Balance
                                    System.out.print("Enter amount to top up: "); //berguna untuk menambah jumlah saldo pengguna 
                                    int amount = scanner.nextInt();
                                    currentUser.topUpBalance(amount);
                                    System.out.println("Balance topped up successfully. Current balance: " + currentUser.getBalance());
                                    break;
                                case 6:
                                    // Exit Program
                                    loggedIn = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                            }
                        }
                    } else {
                        System.out.println("Login failed. Incorrect email or password.");
                    }
                    break;
                case 2:
                    // Register
                    System.out.println("Registering new user:");
                    System.out.print("Full Name: ");
                    String regFullName = scanner.nextLine();
                    System.out.print("Email: ");
                    String regEmail = scanner.nextLine();
                    System.out.print("Password: ");
                    String regPassword = scanner.nextLine();
                    System.out.print("Initial Balance: ");
                    int initialBalance = scanner.nextInt();
                    scanner.nextLine(); // Consumes newline character

                    User newUser = new User(regEmail, regPassword, regFullName);
                    newUser.topUpBalance(initialBalance);

                    if (cinema.registerUser(newUser)) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Registration failed. User already exists.");
                    }
                    break;
                case 3:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }

        scanner.close();
    }
}
