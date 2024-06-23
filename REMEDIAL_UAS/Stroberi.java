public class Stroberi extends Tanaman implements Perawatan {
    private double perkembangan;

    // construktor
    public Stroberi() {
        super(60, 150);
        this.perkembangan = 0.35;
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
        return "Stroberi -\n" + super.toString();
    }
}
