public class Tomat extends Tanaman implements Perawatan {
    private double perkembangan;

    // Constructor
    public Tomat() {
        super(100, 100);
        this.perkembangan = 0.25;
    }

    // Override method berkembang
    @Override
    void berkembang() {
        if (status().equals("Hidup")) {
            lamaHidup++;
            prosesBerbuah += perkembangan;
            if (prosesBerbuah >= berbuah) {
                buah++;
                prosesBerbuah -= berbuah;
            }
        }
    }

    // Override method treatment
    @Override
    public void treatment() {
        prosesBerbuah += berbuah * 0.05;
    }

    // Override method toString
    @Override
    public String toString() {
        return "Tomat -\n" + super.toString();
    }
}
