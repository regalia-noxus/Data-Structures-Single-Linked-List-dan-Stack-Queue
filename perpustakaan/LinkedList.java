package perpustakaan;

// Class LinkedList mengelola operasi-operasi Single Linked List
public class LinkedList {
    private Node head; // Penunjuk ke node pertama
    private int totalBuku; // Menyimpan total jumlah buku

    public LinkedList() {
        this.head = null; // Mengawali daftar dalam keadaan kosong
        this.totalBuku = 0; // Mengawali jumlah buku dari nol
    }

    // 1. Tambah Buku (Push): Menambahkan node baru di akhir daftar (Tail Insertion)
    public void push(String kodeBuku, String judul, String penulis) {
        Node newNode = new Node(kodeBuku, judul, penulis); // Membuat node untuk buku baru

        // Jika daftar masih kosong, node baru langsung menjadi head
        if (head == null) {
            head = newNode;
        } else {
            // Traversal hingga menemukan node terakhir (node yang next-nya null)
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Sambungkan node terakhir ke node baru
            current.next = newNode;
        }
        totalBuku++;
        System.out.println("Data berhasil ditambahkan!");
    }

    // 2. Hapus Buku (Pop): Menghapus node terakhir dari daftar (Tail Deletion)
    public void pop() {
        // Validasi jika daftar kosong
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return; // Menghentikan proses jika daftar kosong
        }

        // Jika hanya ada 1 buku di daftar
        if (head.next == null) {
            System.out.println("Buku '" + head.judul + "' (" + head.kodeBuku + ") berhasil dihapus!");
            head = null; // Mengosongkan head setelah satu-satunya buku dihapus
        } else {
            // Traversal hingga node kedua terakhir (node sebelum ekor)
            Node current = head;
            while (current.next.next != null) {
                current = current.next; // Melanjutkan penelusuran ke node berikutnya
            }
            // Putuskan hubungan ke node terakhir
            System.out.println("Buku '" + current.next.judul + "' (" + current.next.kodeBuku + ") berhasil dihapus!");
            current.next = null;
        }
        totalBuku--; // Mengurangi jumlah buku setelah penghapusan
    }

    // 3. Cari Buku: Menelusuri daftar berdasarkan kodeBuku
    public void cariBuku(String kodeBuku) {
        if (head == null) { // Memeriksa apakah daftar kosong
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        Node current = head; // Memulai pencarian dari node pertama
        boolean ditemukan = false; // Penanda hasil pencarian

        // Traversal linear search
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) { // Mencocokkan kode tanpa membedakan huruf besar dan kecil
                System.out.println("Detail Buku:");
                System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
                ditemukan = true; // Menandai bahwa buku sudah ditemukan
                break; // Menghentikan pencarian setelah menemukan buku
            }
            current = current.next; // Memeriksa node berikutnya jika belum cocok
        }

        if (!ditemukan) { // Menangani hasil pencarian yang tidak ditemukan
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // 4. Tampilkan Semua Buku: Menampilkan seluruh isi rantai sesuai urutan input
    public void tampilkanSemua() {
        System.out.println("Daftar Buku:");
        if (head == null) { // Memeriksa apakah daftar berisi buku
            System.out.println("(Belum ada data buku tersimpan)");
        } else {
            Node current = head; // Memulai penelusuran dari head
            while (current != null) { // Menelusuri node sampai akhir daftar
                System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
                current = current.next; // Berpindah ke buku berikutnya
            }
        }
        // Menampilkan total jumlah buku di akhir daftar
        System.out.println("Total Buku: " + totalBuku);
    }

    public int getTotalBuku() {
        return totalBuku; // Mengembalikan jumlah buku yang tercatat
    }
}
