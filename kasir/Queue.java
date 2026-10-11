package kasir;

// Class Queue mengelola antrean pelanggan (First In, First Out)
public class Queue {
    private Node front; // Menunjuk ke pelanggan paling depan (siap dilayani)
    private Node rear;  // Menunjuk ke pelanggan paling belakang (baru datang)
    private int size;   // Jumlah pelanggan dalam antrean

    public Queue() {
        this.front = null; // Antrean diawali tanpa pelanggan terdepan
        this.rear = null; // Antrean diawali tanpa pelanggan terakhir
        this.size = 0; // Jumlah pelanggan awal adalah nol
    }

    public boolean isEmpty() {
        return front == null; // Bernilai true jika antrean kosong
    }

    public int getSize() {
        return size; // Mengembalikan jumlah pelanggan yang mengantre
    }

    // Operasi Enqueue: Menambahkan pelanggan ke posisi paling belakang (rear)
    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja); // Membuat node untuk pelanggan baru

        if (isEmpty()) { // Memeriksa apakah ini pelanggan pertama
            front = rear = newNode; // Node pertama menjadi front sekaligus rear
        } else {
            rear.next = newNode; // Menghubungkan pelanggan terakhir ke node baru
            rear = newNode; // Memperbarui posisi belakang antrean
        }
        size++; // Menambah jumlah pelanggan dalam antrean
        System.out.println("Data pelanggan ditambahkan ke antrian!");
    }

    // Operasi Dequeue: Mengambil dan mencopot pelanggan terdepan (front)
    public Node dequeue() {
        if (isEmpty()) { // Mencegah pengambilan dari antrean kosong
            System.out.println("Antrian kosong! Tidak ada pelanggan untuk dilayani.");
            return null; // Menandakan tidak ada pelanggan yang bisa dilayani
        }

        Node temp = front; // Menyimpan pelanggan terdepan sebelum dikeluarkan
        front = front.next; // Memindahkan front ke pelanggan berikutnya

        // Jika setelah dequeue antrean menjadi kosong
        if (front == null) {
            rear = null; // Mengosongkan rear agar sesuai dengan front
        }

        temp.next = null; // Putuskan hubungan pointer dari antrean
        size--; // Mengurangi jumlah pelanggan setelah dequeue
        return temp; // Mengembalikan data pelanggan yang dilayani
    }

    // Menampilkan seluruh antrean dari depan ke belakang
    public void display() {
        System.out.println("\n--- DAFTAR ANTRIAN SAAT INI ---");
        if (isEmpty()) {
            System.out.println("Antrian saat ini sedang kosong.");
            return; // Menghentikan tampilan jika antrean kosong
        }

        Node current = front; // Memulai traversal dari pelanggan terdepan
        int no = 1; // Menyiapkan nomor urut saat menampilkan antrean
        while (current != null) { // Menelusuri semua pelanggan hingga akhir antrean
            System.out.printf("%d. [%s] %s - Total: Rp %,.0f\n", 
                no++, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next; // Berpindah ke pelanggan berikutnya
        }
        System.out.println("Total Pelanggan Mengantre: " + size);
    }
}
