import java.util.Scanner;

class PengunjungUTS {
    public static final int HARGA_DEWASA = 15000;
    public static final int HARGA_ANAK = 10000;
    private static int totalTransaksi = 0;
    private static int totalPendapatan = 0;

    private final String idTiket;
    private String nama;
    private String jenisPengunjung;
    private int jumlahTiket;

    //Construktor
    public PengunjungUTS(String nama, String jenisPengunjung, int jumlahTiket) {
        totalTransaksi++;
        this.idTiket = "TPS-260" + totalTransaksi;
        this.nama = nama;
        this.jenisPengunjung = jenisPengunjung;
        
        setJumlahTiket(jumlahTiket);
        
        totalPendapatan += hitungTotalBayar();
    }

    public String getNama() { return nama; }
    public String getIdTiket() { return idTiket; }
    
    public void setJumlahTiket(int jumlahTiket) {
        if (jumlahTiket > 0) {
            this.jumlahTiket = jumlahTiket;
        } else {
            System.out.println(">> Peringatan: Jumlah tiket tidak valid! Otomatis diset ke 1.");
            this.jumlahTiket = 1;
        }
    }

    public int hitungTotalBayar() {
        if (jenisPengunjung.equalsIgnoreCase("Dewasa")) {
            return jumlahTiket * HARGA_DEWASA;
        } else {
            return jumlahTiket * HARGA_ANAK;
        }
    }

    public void tampilkanData() {
        System.out.println("\n===== STRUK TIKET PANTAI SERAYA =====");
        System.out.println("ID Tiket        : " + idTiket);
        System.out.println("Nama Pengunjung : " + nama);
        System.out.println("Jenis Pengunjung: " + jenisPengunjung);
        System.out.println("Jumlah Tiket    : " + jumlahTiket);
        System.out.println("Total Bayar     : Rp" + hitungTotalBayar());
        System.out.println("=====================================\n");
    }

    public static void tampilkanLaporan() {
        System.out.println("\n===== LAPORAN TUTUP LOKET =====");
        System.out.println("Total Transaksi  : " + totalTransaksi + " Pembeli");
        System.out.println("Total Pendapatan : Rp" + totalPendapatan);
        System.out.println("===============================\n");
    }
}

public class SistemLoketUTSPantaiSeraya {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lanjut = "y";

        System.out.println("======================================");
        System.out.println("        SISTEM LOKET PANTAI SERAYA      ");
        System.out.println("======================================");

        while (lanjut.equalsIgnoreCase("y")) {
            System.out.print("\nMasukkan nama pemesan: ");
            String nama = input.nextLine();

            System.out.print("Jumlah tiket Dewasa (Ketik 0 jika tidak beli): ");
            int jmlDewasa = input.nextInt();
            
            System.out.print("Jumlah tiket Anak-anak (Ketik 0 jika tidak beli): ");
            int jmlAnak = input.nextInt();
            input.nextLine();

            if (jmlDewasa <= 0 && jmlAnak <= 0) {
                System.out.println(">>>>> Peringatan: Anda tidak memesan tiket apapun! <<<<<<");
            } else {
                
                // Jika membeli tiket Dewasa
                if (jmlDewasa > 0) {
                    PengunjungUTS pDewasa = new PengunjungUTS(nama, "Dewasa", jmlDewasa);
                    pDewasa.tampilkanData();
                }
                
                // Jika membeli tiket Anak-anak
                if (jmlAnak > 0) {
                    PengunjungUTS pAnak = new PengunjungUTS(nama, "Anak-anak", jmlAnak);
                    pAnak.tampilkanData();
                }
            }

            System.out.print("Antrian selanjutnya? (y/n): ");
            lanjut = input.nextLine();
        }

        PengunjungUTS.tampilkanLaporan();
        
        System.out.println("Loket selesai. Terima kasih!");
        input.close();
    }
}