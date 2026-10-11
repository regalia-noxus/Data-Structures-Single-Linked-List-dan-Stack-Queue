package kasir;

// Class Stack mengelola riwayat transaksi (Last In, First Out)
public class Stack {
    private Node top; // Menunjuk ke transaksi yang paling baru selesai
    private int size; // Jumlah total transaksi yang telah dilayani

    public Stack() {
        this.top = null; // Stack diawali tanpa transaksi
        this.size = 0; // Jumlah transaksi awal adalah nol
    }

    public boolean isEmpty() {
        return top == null; // Bernilai true jika belum ada transaksi
    }

    // Operasi Push: Menyimpan transaksi yang baru selesai ke puncak stack
    public void push(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja); // Membuat node riwayat transaksi baru
        newNode.next = top; // Menghubungkan node baru ke transaksi sebelumnya
        top = newNode; // Menjadikan transaksi baru sebagai puncak stack
        size++; // Menambah jumlah transaksi tersimpan
    }

    // Menampilkan riwayat transaksi dari yang terbaru ke terlama (LIFO)
    public void display() {
        System.out.println("\n--- RIWAYAT TRANSAKSI (TERBARU KE TERLAMA) ---");
        if (isEmpty()) { // Memeriksa apakah riwayat transaksi kosong
            System.out.println("Belum ada transaksi yang selesai dilayani.");
            return; // Menghentikan tampilan jika belum ada transaksi
        }

        Node current = top; // Memulai traversal dari transaksi terbaru
        int no = 1; // Menyiapkan nomor urut tampilan transaksi
        while (current != null) { // Menelusuri transaksi dari terbaru ke terlama
            System.out.printf("%d. [%s] %s - Total: Rp %,.0f (Selesai)\n", 
                no++, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next; // Berpindah ke transaksi yang lebih lama
        }
        System.out.println("Total Transaksi Tersimpan: " + size);
    }
}
