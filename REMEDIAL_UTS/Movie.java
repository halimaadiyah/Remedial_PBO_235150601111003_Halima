public class Movie {
    private String title;
    private int rating;
    private String genres;

    // getter
    public String getTitle() {
        return title;
    }
    public int getRating() {
        return rating;
    }

    public String getGenres() {
        return genres;
    }

    // construktor
    public Movie(String title, int rating, String genres) {
        this.title = title;
        if (rating < 1) {
            this.rating = 1;
        } else if (rating > 10) {
            this.rating = 10;
        } else {
            this.rating = rating;
        }
        this.genres = genres;
    }
}
