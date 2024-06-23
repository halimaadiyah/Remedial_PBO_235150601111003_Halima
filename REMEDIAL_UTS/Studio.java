public class Studio {
    private Movie movie;
    private String type;
    private boolean[][] seats;

    // construktur
    public Studio(Movie movie) {
        this.movie = movie;
        setSeats();
    }

    // berguna untuk memeriksa status pemesanan tempat duduk dalam suatu seat dengan didasari baris dan kolomnya 
    public int isBooked(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            return -1; // Mengembalikan nilai -1 jika keluar batasan
        }
        return seats[row][col] ? 1 : 0; // Mengembalikan 1 jika tempat duduk sudah dipesan, 0 jika belum
    }
    
    // adanya method getStudioInfo ini berguna untuk mendapatkan informasi detail mengenai studio
    public String getStudioInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movie: ").append(movie.getTitle()).append("\n");
        sb.append("Type: ").append(type).append("\n");
        sb.append("Ticket Price: ").append(getTicketPrice()).append("k\n");
        sb.append("Seats:\n");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                sb.append(seats[i][j] ? "X " : "O ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // method reserve berfungsi untuk memesan kursi studio, di dasari dengan baris dan kolo yang di berikan
    public boolean reserve(int row, int col) {
        if (row >= 0 && row < seats.length && col >= 0 && col < seats[0].length) {
            if (!seats[row][col]) {
                seats[row][col] = true; // untuk menandai kursi yang sudah dipesan
                return true;
            }
        }
        return false;
    }

    // berguna untuk set kursi berdasarkan genre film yang akan di putarkan
    private void setSeats() {
        if (movie != null) {
            String genres = movie.getGenres();
            if (genres.equalsIgnoreCase("Horor")) {
                type = "Imax";
                seats = new boolean[8][9];
            } else if (genres.equalsIgnoreCase("Drama Family")) {
                type = "Premiere";
                seats = new boolean[6][4];
            } else {
                type = "Regular";
                seats = new boolean[5][5];
            }
        }
    }

    // guna untuk mengetahi harga tiket berdasarkan tipe studio
    public int getTicketPrice() {
        switch (type) {
            case "Premiere":
                return 120;
            case "Imax":
                return 100;
            default:
                return 50;
        }
    }

    public Movie getMovie() {
        return movie;
    }
}
