public abstract class Tanaman {
    protected int masaHidup;
    protected int lamaHidup;
    protected int buah;
    protected int prosesBerbuah;
    protected int berbuah;

    // Getter and Setter
    public int getMasaHidup() {
        return masaHidup;
    }

    public void setMasaHidup(int masaHidup) {
        this.masaHidup = masaHidup;
    }

    public int getLamaHidup() {
        return lamaHidup;
    }

    public void setLamaHidup(int lamaHidup) {
        this.lamaHidup = lamaHidup;
    }

    public int getBuah() {
        return buah;
    }

    public void setBuah(int buah) {
        this.buah = buah;
    }

    // construktor
    public Tanaman(int masaHidup, int berbuah) {
        this.masaHidup = masaHidup;
        this.lamaHidup = 0;
        this.buah = 0;
        this.prosesBerbuah = 0;
        this.berbuah = berbuah;
    }

    abstract void berkembang();

    // guna memberikan informasi terkait status tanaman
    public String status() {
        return lamaHidup >= masaHidup ? "Mati" : "Hidup";
    }

    @Override
    public String toString() {
        return "Masa Hidup    : " + masaHidup + " hari\n" +
               "Umur tanaman  : " + lamaHidup + " hari\n" +
               "Menghasilkan  : " + buah + " buah\n" +
               "Status        : " + status();
    }
}
