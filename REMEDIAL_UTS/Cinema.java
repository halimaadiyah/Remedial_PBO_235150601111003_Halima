import java.util.ArrayList;

public class Cinema {
    private String name;
    private ArrayList<User> listUsers;
    private ArrayList<Studio> listStudio;
    private int studioCapacity;

    //setter getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // construktor
    public Cinema(String name, int studioCapacity) {
        this.name = name;
        this.studioCapacity = studioCapacity;
        this.listUsers = new ArrayList<>();
        this.listStudio = new ArrayList<>();
        init();
    }

    // method 
    public boolean registerUser(User user) {
        if (listUsers.contains(user)) { // berguna untuk chek user, apakah user yang sudah didaftarkan sudah ada dalam listuser atau belum
            return false; // user already registered
        }
        listUsers.add(user);
        return true;
    }

    // method
    public User authenticateUser(String email, String password) { // berguna mengidentifikasi pengguna berdasarkan email dan password
        for (User user : listUsers) {
            if (user.isMatch(email, password)) {
                return user;
            }
        }
        return null; // user not found
    }

    // method
    public void displayListStudio() { // fungsi method ini berguna untuk memberikan tampilan terkait studio yang ada dalam bioskop
        for (int i = 0; i < listStudio.size(); i++) {
            Studio studio = listStudio.get(i);
            System.out.println("Studio " + (i + 1) + ": " +
                    "Type: " + studio.getMovie().getGenres() +
                    ", Movie: " + studio.getMovie().getTitle());
        }
    }

    // method yang memiliki 1 parameter berupa studionumber
    public void displayStudioDetail(int studioNumber) {
        if (studioNumber > 0 && studioNumber <= listStudio.size()) {
            Studio studio = listStudio.get(studioNumber - 1);
            System.out.println("Studio " + studioNumber + ":");
            System.out.println(studio.getStudioInfo());
        } else {
            System.out.println("Invalid studio number."); // jika nomor studio tidak valid maka akan mencetak pesan di dalam kurung
        }
    }

    // method 
    public boolean addStudioWithMovies(Studio studio) { // berfungsi untuk menambahkan object studio ke dalam list studio
        if (listStudio.size() < studioCapacity) { 
            listStudio.add(studio);
            return true;
        } 
        return false;
    }

    // berguna untuk memesan tiket berdasarkan nomor studio, baris, dan kolom
    public boolean bookTicket(User user, int studioNumber, int row, int col) {
        if (studioNumber > 0 && studioNumber <= listStudio.size()) {
            Studio studio = listStudio.get(studioNumber - 1);
            if (studio.reserve(row, col)) {
                int price = studio.getTicketPrice();
                Ticket ticket = new Ticket(studio.getMovie(), studioNumber, price);
                user.addTicket(ticket);
                return true;
            }
        }
        return false;
    }

    private void init() {
        // Inisialisasi data studio (berupa nama film, rating, genre)
        Movie movie1 = new Movie("Pengabdi Setan 2", 9, "Horror");
        Movie movie2 = new Movie("Miracle In Cell 07", 9, "Drama Family");

        Studio studio1 = new Studio(movie1);
        Studio studio2 = new Studio(movie2);

        addStudioWithMovies(studio1);
        addStudioWithMovies(studio2);
    }
}
