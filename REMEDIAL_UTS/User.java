import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private String fullName;
    private int balance;
    private ArrayList<Ticket> ticketLists;
    private static final int MAX_TICKET = 20;

    // getter setter
    public int getBalance() {
        return balance;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // costruktor 
    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = 0;
        this.ticketLists = new ArrayList<>();
    }

    // method isMatch berguna untuk memverifikasi email & password
    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    // method addTicket ini berguna menambahkan object tiket, namun tetap dgn memperhatikan kapasitas max-nya
    public void addTicket(Ticket ticket) {
        if (ticketLists.size() < MAX_TICKET) {
            ticketLists.add(ticket);
        }
    }

    // method ini gunanya untuk mengetahui detail keseluruhan tiket yang telah tersimpan dlm ticketList
    public void displayAllTickets() {
        for (Ticket ticket : ticketLists) {
            System.out.println("Movie: " + ticket.getMovie().getTitle() +
                    ", Studio: " + ticket.getStudioNumber() +
                    ", Price: " + ticket.getTicketPrice());
        }
    }

    // method untuk menambahkan saldo
    public void topUpBalance(int amount) {
        balance += amount;
    }
}
