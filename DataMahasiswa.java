import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    String nim;
    String jurusan;

    Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Nama: " + this.nama + ", NIM: " + this.nim + ", Jurusan: " + this.jurusan;
    }
}

public class DataMahasiswa {
    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Hapus Data Mahasiswa");
            System.out.println("3. Tampilkan Data Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline

            switch (pilihan) {
                case 1:
                    tambahData(scanner);
                    break;
                case 2:
                    hapusData(scanner);
                    break;
                case 3:
                    lihatData();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

    static void tambahData(Scanner scanner) {
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan jurusan mahasiswa: ");
        String jurusan = scanner.nextLine();
        daftarMahasiswa.add(new Mahasiswa(nama, nim, jurusan));
        System.out.println("Data mahasiswa berhasil ditambahkan.\n");
    }

    static void hapusData(Scanner scanner) {
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();
        daftarMahasiswa.removeIf(mahasiswa -> mahasiswa.nim.equals(nim));
        System.out.println("Data mahasiswa berhasil dihapus.\n");
    }

    static void lihatData() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.\n");
        } else {
            for (Mahasiswa mhs : daftarMahasiswa) {
                System.out.println(mhs);
            }
            System.out.println(); // Menambah baris kosong setelah menampilkan data
        }
    }
}