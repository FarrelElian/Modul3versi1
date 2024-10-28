import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Kelas MesinKasirKedaiKopi2 merepresentasikan sebuah mesin kasir untuk kedai kopi.
 * Kelas ini menyimpan menu minuman dan menghitung total harga dari pesanan.
 */
public class MesinKasirKedaiKopi2 {
    /**
     * Harga untuk setiap jenis minuman.
     */
    private static final double HARGA_KOPI_HITAM = 15000.0;
    private static final double HARGA_CAPPUCCINO = 20000.0;
    private static final double HARGA_LATTE = 25000.0;
    private static final double HARGA_TEH = 10000.0;

    private Map<String, Double> menu;
    private double total;

    /**
     * Konstruktor untuk kelas MesinKasirKedaiKopi2.
     * Menginisialisasi menu dan total harga.
     */
    public MesinKasirKedaiKopi2() {
        menu = new HashMap<>();
        total = 0.0;
        menu.put("Kopi Hitam", HARGA_KOPI_HITAM);
        menu.put("Cappuccino", HARGA_CAPPUCCINO);
        menu.put("Latte", HARGA_LATTE);
        menu.put("Teh", HARGA_TEH);
    }

    /**
     * Mengambil menu minuman yang tersedia.
     *
     * @return Map yang berisi nama minuman dan harganya.
     */
    public Map<String, Double> getMenu() {
        return menu;
    }

    /**
     * Mengambil total harga dari semua item yang telah ditambahkan.
     *
     * @return Total harga.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Mengatur total harga.
     *
     * @param total Total harga yang baru.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Menampilkan menu minuman yang tersedia di kedai kopi.
     */
    public void tampilkanMenu() {
        System.out.println("Menu Kedai Kopi:");
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            System.out.println(item.getKey() + " - Rp " + item.getValue());
        }
    }

    /**
     * Memeriksa item yang tersedia dalam menu.
     * @param namaItem Nama item yang akan diperiksa.
     * @return true jika item tersedia, false jika tidak.
     */
    private boolean isItemAvailable(String namaItem) {
        return menu.containsKey(namaItem);
    }

    /**
     * Menambahkan item ke total harga jika item tersedia dalam menu.
     *
     * @param namaItem Nama item yang akan ditambahkan.
     */
    public void tambahItem(String namaItem) {
        if (isItemAvailable(namaItem)) {
            total += menu.get(namaItem);
            System.out.println(namaItem + " telah ditambahkan. Total: Rp " + total);
        } else {
            System.out.println("Item tidak tersedia dalam menu.");
        }
    }

    /**
     * Metode utama untuk menjalankan program kasir kedai kopi.
     */
    public static void main(String[] args) {
        MesinKasirKedaiKopi2 kasir = new MesinKasirKedaiKopi2();
        StrukPrinter printer = new StrukPrinter();
        Scanner scanner = new Scanner(System.in);
        String input;

        kasir.tampilkanMenu();

        while (true) {
            System.out.print("Masukkan nama item [(atau ketik 'selesai' untuk mencetak struk): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("selesai")) {
                break;
            }
            kasir.tambahItem(input);
        }

        printer.cetakStruk(kasir.getTotal());
        scanner.close();
    }
}

/**
 * Kelas StrukPrinter untuk mencetak struk pembelian.
 */
class StrukPrinter {
    /**
     * Mencetak struk pembelian dengan total harga.
     *
     * @param total Total harga yang harus dibayar.
     */
    public void cetakStruk(double total) {
        System.out.println("Struk Pembelian:");
        System.out.println("Total yang harus dibayar: Rp " + total);
    }
}