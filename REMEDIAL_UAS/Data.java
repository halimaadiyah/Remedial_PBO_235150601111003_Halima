import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private static ArrayList<Tanaman> tanamans = new ArrayList<>();
    private static ArrayList<Integer> lokasi = new ArrayList<>();
    private static int masaTanam;

    // guna untuk memantau siklus tumbuhan berupa storberi, persik, tomat
    public static void mulai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan masa tanam (dalam bulan): ");
        int bulan = scanner.nextInt();
        masaTanam = bulan * 30;

        menanam();
        menanam();
        menanam();

        for (int hari = 1; hari <= masaTanam; hari++) {
            for (int i = 0; i < tanamans.size(); i++) {
                Tanaman tanaman = tanamans.get(i);
                if (tanaman.status().equals("Hidup")) {
                    tanaman.berkembang();
                    if (lokasi.contains(i)) {
                        continue;
                    }
                    if (tanaman.status().equals("Mati")) {
                        lokasi.add(i);
                        menanam();
                    }
                    if (hari % 90 == 0) {
                        if (tanaman instanceof Perawatan) {
                            ((Perawatan) tanaman).treatment();
                        }
                    }
                }
            }
        }
    }

    // guna memilih jenis tanaman yang ingin ditanam dimana terdapat banyak pilihan seperti (tomat, stroberi, persik)
    public static void menanam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih tanaman yang ingin Anda tanam:");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");
        int pilihan = scanner.nextInt();

        Tanaman tanaman;
        switch (pilihan) {
            case 1:
                tanaman = new Tomat();
                break;
            case 2:
                tanaman = new Stroberi();
                break;
            case 3:
                tanaman = new Persik();
                break;
            default:
                System.out.println("Pilihan tidak valid, defaulting to Tomat.");
                tanaman = new Tomat();
                break;
        }
        tanamans.add(tanaman);
        System.out.println(tanaman.getClass().getSimpleName() + " berhasil ditanam.");
    }

    // guna untuk menampilakan informasi terkait tanaman berhasil di tambahkan/ ditanam
    public static void info() {
        System.out.println("---PROSES PENGEMBANGAN---");
        System.out.println("--------------------------");
        System.out.println("------HASIL MENANAM------");

        for (int i = 0; i < tanamans.size(); i++) {
            Tanaman tanaman = tanamans.get(i);
            System.out.println();
            System.out.println("Tanaman buah ke-" + (i + 1));
            System.out.println(tanaman.toString());
        }
    }
}
