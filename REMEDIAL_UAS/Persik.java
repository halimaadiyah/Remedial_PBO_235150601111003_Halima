public class Persik extends Tanaman implements Perawatan {
    private double perkembangan;

    // construktor
    public Persik() {
        super(180, 250);
        this.perkembangan = 0.15;
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
        prosesBerbuah += berbuah * 0.025;
    }

    @Override
    public String toString() {
        return "Persik -\n" + super.toString();
    }
}
