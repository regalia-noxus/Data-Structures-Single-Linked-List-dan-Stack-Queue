package kasir;

import java.util.Scanner; // Mengimpor Scanner untuk membaca input pengguna

public class Main {
    public static void main(String[] args) { // Titik awal eksekusi program kasir
        Scanner scanner = new Scanner(System.in); // Menyiapkan pembaca input dari keyboard
        Queue antrianPelanggan = new Queue(); // Membuat antrean pelanggan dengan prinsip FIFO
        Stack riwayatTransaksi = new Stack(); // Membuat riwayat transaksi dengan prinsip LIFO
        boolean berjalan = true; // Mengontrol perulangan menu utama

        while (berjalan) { // Mengulang menu selama program berjalan
            // Tampilan menu utama persis sesuai panduan dan gambar
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan; // Menyimpan pilihan menu dari pengguna
            try { // Memeriksa apakah pilihan dapat dibaca sebagai angka
                pilihan = Integer.parseInt(scanner.nextLine().trim()); // Mengubah input menu menjadi bilangan bulat
            } catch (NumberFormatException e) { // Menangani input menu yang bukan bilangan bulat
                System.out.println("Pilihan tidak valid! Masukkan angka 1-5.");
                continue; // Meminta pengguna memilih menu kembali
            }

            System.out.println(); // Spasi antar baris

            switch (pilihan) { // Menjalankan operasi berdasarkan pilihan menu
                case 1:
                    // Menu 1: Tambah Antrian (Enqueue)
                    System.out.print("Masukkan Nomor Antrian: ");
                    String noAntrian = scanner.nextLine().trim(); // Membaca nomor antrean pelanggan

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine().trim(); // Membaca nama pelanggan

                    double total = 0; // Menyiapkan nilai total belanja
                    while (true) { // Mengulang input sampai total belanja valid
                        System.out.print("Masukkan Total Belanja: ");
                        try {
                            total = Double.parseDouble(scanner.nextLine().trim()); // Mengubah input total belanja menjadi angka desimal
                            if (total < 0) { // Menolak total belanja bernilai negatif
                                System.out.println("Total belanja tidak boleh bernilai negatif!");
                                continue; // Mengulang permintaan total belanja
                            }
                            break; // Mengakhiri validasi jika total belanja sah
                        } catch (NumberFormatException e) { // Menangani total belanja yang bukan angka
                            System.out.println("Input total belanja harus berupa angka!");
                        }
                    }

                    // Enqueue ke antrean
                    antrianPelanggan.enqueue(noAntrian, nama, total);
                    break;

                case 2:
                    // Menu 2: Layani Pelanggan (Dequeue dari Queue + Push ke Stack)
                    Node dilayani = antrianPelanggan.dequeue(); // Mengambil pelanggan paling depan sesuai FIFO
                    if (dilayani != null) { // Memproses pelanggan hanya jika antrean tidak kosong
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian + " (" + dilayani.namaPelanggan + ")");
                        
                        // Simpan ke riwayat transaksi (Stack)
                        riwayatTransaksi.push(dilayani.nomorAntrian, dilayani.namaPelanggan, dilayani.totalBelanja); // Menempatkan transaksi terbaru di puncak stack
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                    // Menu 3: Tampilkan Antrian Saat Ini
                    antrianPelanggan.display();
                    break;

                case 4:
                    // Menu 4: Lihat Riwayat Transaksi (LIFO)
                    riwayatTransaksi.display();
                    break;

                case 5:
                    // Menu 5: Keluar Program
                    System.out.println("Terima kasih, program kasir ditutup.");
                    berjalan = false; // Menghentikan perulangan menu
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
        }

        scanner.close(); // Menutup Scanner setelah program selesai
    }
}
