package perpustakaan;

import java.util.Scanner; // Digunakan untuk membaca input pengguna

public class Main {
    public static void main(String[] args) { // Titik awal eksekusi program
        Scanner scanner = new Scanner(System.in); // Menyiapkan pembaca input dari keyboard
        LinkedList listBuku = new LinkedList(); // Membuat objek pengelola buku berbasis Single Linked List
        boolean running = true; // untuk engontrol apakah menu terus dijalankan

        while (running) { // Mengulangi menu selama program masih berjalan
            // Menampilkan antarmuka menu utama
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan; // Menyimpan nomor menu yang dipilih
            try { // Menangani kemungkinan input bukan angka
                pilihan = Integer.parseInt(scanner.nextLine().trim()); // Mengubah input pengguna menjadi bilangan bulat
            } catch (NumberFormatException e) { // Menangkap kesalahan ketika input bukan bilangan bulat
                System.out.println("Pilihan tidak valid! Masukkan angka 1-5.");
                continue; // Kembali ke menu utama
            }

            System.out.println(); // Spasi antar tampilan

            switch (pilihan) { // Menjalankan perintah sesuai nomor menu
                case 1:
                    // Validasi kodeBuku maksimal 5 karakter
                    String kodeBuku;
                    while (true) { // Meminta ulang kode sampai valid
                        System.out.print("Masukkan Kode Buku: ");
                        kodeBuku = scanner.nextLine().trim(); // Menghilangkan spasi di awal dan akhir kode

                        if (kodeBuku.isEmpty()) { // Menolak kode yang kosong
                            System.out.println("Kode buku tidak boleh kosong!");
                        } else if (kodeBuku.length() > 5) { // Menolak kode lebih dari lima karakter
                            System.out.println("Validasi gagal: kodeBuku maksimal 5 karakter! Silakan coba lagi.");
                        } else {
                            break; // Validasi lolos
                        }
                    }

                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine().trim(); // Membaca judul buku

                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine().trim(); // Membaca nama penulis buku

                    // Masukkan ke akhir linked list
                    listBuku.push(kodeBuku, judul, penulis);
                    break;

                case 2:
                    // Hapus buku terakhir (Pop)
                    listBuku.pop();
                    break;

                case 3:
                    // Cari buku berdasarkan kode
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String kodeCari = scanner.nextLine().trim(); // Membaca kode buku yang akan dicari
                    listBuku.cariBuku(kodeCari);
                    break;

                case 4:
                    // Lihat seluruh buku
                    listBuku.tampilkanSemua();
                    break;

                case 5:
                    // Keluar program
                    System.out.println("Keluar dari program. Terima kasih sudah menggunakan program sederhana ini");
                    running = false; // Mengakhiri perulangan menu
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
        }

        scanner.close(); // Menutup Scanner setelah program selesai
    }
}
