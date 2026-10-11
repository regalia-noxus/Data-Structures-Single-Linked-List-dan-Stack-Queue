package perpustakaan;

// Class Node merepresentasikan satu elemen/gerbong data dalam Single Linked List
public class Node {
    // Atribut data buku
    String kodeBuku; // Kode untuk identifikasi buku
    String judul; // Judul buku yang disimpan
    String penulis; // Nama penulis buku
    
    // Pointer yang menunjuk ke node berikutnya
    Node next;

    // Konstruktor untuk inisialisasi data node baru
    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku; // Menyimpan kode buku ke node
        this.judul = judul; // Menyimpan judul buku ke node
        this.penulis = penulis; // Menyimpan penulis buku ke node
        this.next = null; // Awalnya tidak menunjuk ke mana-mana
    }
}
