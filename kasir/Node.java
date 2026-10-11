package kasir;

// Class Node merepresentasikan entitas pelanggan dan transaksi
public class Node {
    String nomorAntrian; // Menyimpan nomor antrean pelanggan
    String namaPelanggan; // Menyimpan nama pelanggan
    double totalBelanja; // Menyimpan nominal belanja pelanggan
    
    // Pointer yang menunjuk ke node berikutnya
    Node next;

    // Konstruktor inisialisasi data
    public Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian; // Mengisi nomor antrean pada node baru
        this.namaPelanggan = namaPelanggan; // Mengisi nama pelanggan pada node baru
        this.totalBelanja = totalBelanja; // Mengisi total belanja pada node baru
        this.next = null; // Node baru belum terhubung ke node lain
    }
}
