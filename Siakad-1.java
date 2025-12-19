/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myclass;

import java.util.Scanner;


/**
 *
 * @author Sani Rahmatani
 */
public class Siakad {
    // --- Method Pendukung KRS ---

    private static void tambahMk(Scanner scanner, Mahasiswa mhs) {
        System.out.print("Masukkan Kode Mata Kuliah: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Mata Kuliah: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan SKS (1-6): ");
        String sksStr = scanner.nextLine();

        try {
            int sks = Integer.parseInt(sksStr);
            MataKuliah mkBaru = new MataKuliah(kode, nama, sks); 
            mhs.tambahMataKuliah(mkBaru);

        } catch (NumberFormatException e) {
            System.err.println("\n!!! Validasi Input Gagal: SKS harus berupa angka.");
        } catch (IllegalArgumentException e) {
            System.err.println("\n!!! Validasi Input Gagal: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n!!! Operasi Gagal: " + e.getMessage());
        }
    }

    private static void hapusMk(Scanner scanner, Mahasiswa mhs) {
        System.out.print("Masukkan Kode Mata Kuliah yang akan dihapus: ");
        String kode = scanner.nextLine();

        try {
            mhs.hapusMataKuliah(kode);
        } catch (Exception e) {
            System.err.println("\n!!! Operasi Gagal: " + e.getMessage());
        }
    }
    
    private static void menuKrs(Scanner scanner, Mahasiswa mhs) {
        int pilihan;
        do {
            System.out.println("\n*** Menu Kelola KRS Mahasiswa: " + " ***");
            System.out.println("1. Tambah Mata Kuliah ke KRS");
            System.out.println("2. Hapus Mata Kuliah dari KRS");
            System.out.println("3. Lihat KRS Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu (0-3): ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                pilihan = -1; 
            }

            switch (pilihan) {
                case 1: tambahMk(scanner, mhs); break;
                case 2: hapusMk(scanner, mhs); break;
                case 3: mhs.tampilKRS(); break;
                case 0: System.out.println("Kembali ke Menu Utama..."); break;
                default: System.out.println("❌ Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }
    
    private static Mahasiswa cariMahasiswa(Scanner sc, Mahasiswa[] data, int jumlah) {
        System.out.print("Masukkan NIM mahasiswa: ");
        String cariNim = sc.nextLine();
        for (int i = 0; i < jumlah; i++) {
            if (data[i].getNim().equals(cariNim)) {
                return data[i];
            }
        }
        System.out.println("❌ Data mahasiswa dengan NIM " + cariNim + " tidak ditemukan!");
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mahasiswa[] data = new Mahasiswa[100];
        int jumlah = 0;

        // Tambahkan beberapa dosen default (Menggunakan Subclass DosenTetap dan DosenLB)
        Dosen dsn1 = new DosenTetap("Dr. Andi Setiawan", "12345", "Teknik Informatika", "DT-001");
        Dosen dsn2 = new DosenLB("Dr. Budi Rahman", "67890", "Sistem Informasi");
        Dosen dsn3 = new DosenTetap("Dr. Candra Wijaya", "11223", "Teknik Informatika", "DT-003");
        
        // Ilustrasi pemanggilan method absen() (DEMO POLYMORPHISM)
        System.out.println("\n--- POLYMORPHISM DOSEN ---");
        dsn1.absen(); // Memanggil absen() di DosenTetap
        dsn2.absen(); // Memanggil absen() di DosenLB
        System.out.println("--------------------------------");
        
        // Data awal mahasiswa
        data[jumlah++] = new MahasiswaReguler("2310001", "Andi Pratama", "Teknik Informatika", 3.65, dsn1);
        data[jumlah++] = new MahasiswaReguler("242011020", "Budi Santoso", "Sistem Informasi", 2.75, dsn2);
        data[jumlah++] = new MahasiswaReguler("242011021", "Sani Rahmatani", "Teknik Informatika", 4.00, dsn3);

        // --- Kasus Ilustrasi KRS untuk Tiga Mahasiswa ---
        System.out.println("\n=================================");
        System.out.println("--- Inisialisasi KRS Data Awal ---");
        System.out.println("=================================");

        Mahasiswa andi = data[0];
        Mahasiswa budi = data[1];
        Mahasiswa sani = data[2];
        
        try {
            // 1. Andi Pratama (Kasus Utama Tugas)
            Dosen dsnWaliAndi = new DosenLB("Ds. Gia Yuliana", "22334", "IF");
            andi.setDosenWali(dsnWaliAndi); 
            andi.setUmur(20); 
            andi.tambahMataKuliah(new MataKuliah("IF101", "Pemrograman Dasar", 3));
            andi.tambahMataKuliah(new MataKuliah("IF102", "Pemrograman Berorientasi Objek", 3));
            andi.tampilKRS(); 
            
            // 2. Budi Santoso (Tambahan Ilustrasi)
            budi.setUmur(19);
            budi.tambahMataKuliah(new MataKuliah("SI201", "Basis Data", 4));
            budi.tambahMataKuliah(new MataKuliah("SI202", "Jaringan Komputer", 3));
            budi.tampilKRS();

            // 3. Sani Rahmatani (Tambahan Ilustrasi)
            sani.setUmur(21);
            sani.tambahMataKuliah(new MataKuliah("MT001", "Kalkulus I", 4));
            sani.tambahMataKuliah(new MataKuliah("MT002", "Aljabar Linear", 3));
            sani.tambahMataKuliah(new MataKuliah("IF103", "Struktur Data", 3));
            sani.tampilKRS();

        } catch (Exception e) {
             System.out.println("\nKesalahan Inisialisasi KRS: " + e.getMessage());
        }

        int pilih;
        do {
            System.out.println("\n=== MENU SIAKAD ===");
            System.out.println("1. Daftar Mahasiswa");
            System.out.println("2. Cari Mahasiswa berdasarkan NIM");
            System.out.println("3. Hitung Rata-rata IPK");
            System.out.println("4. Ganti Dosen Wali");
            System.out.println("5. Tambah Mahasiswa Baru");
            System.out.println("6. Kelola KRS Mahasiswa"); 
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            
            try {
                pilih = Integer.parseInt(sc.nextLine()); 
            } catch (NumberFormatException e) {
                pilih = -1;
            }

            Mahasiswa mhs = null;

            switch (pilih) {
                case 1:
                    System.out.println("\n=== DAFTAR MAHASISWA ===");
                    for (int i = 0; i < jumlah; i++) {
                        data[i].tampilData();
                    }
                    break;
                
                case 2: // Cari Mahasiswa
                    mhs = cariMahasiswa(sc, data, jumlah);
                    if (mhs != null) mhs.tampilData();
                    break;
                
                case 3: // Hitung Rata-rata IPK
                    if (jumlah == 0) {
                        System.out.println("Tidak ada data mahasiswa.");
                        break;
                    }
                    double totalIpk = 0;
                    for (int i = 0; i < jumlah; i++) {
                        totalIpk += data[i].getIpk();
                    }
                    double rataRata = totalIpk / jumlah;
                    System.out.printf("\n=== RATA-RATA IPK: %.2f ===\n", rataRata);
                    break;
                    
                case 4: // Ganti Dosen Wali
                    mhs = cariMahasiswa(sc, data, jumlah);
                    if (mhs != null) {
                        System.out.println("--- Ganti Dosen Wali ---");
                        System.out.print("Masukkan Nama Dosen Wali Baru: ");
                        String namaDsn = sc.nextLine();
                        System.out.print("Masukkan NIDN Dosen Wali Baru: ");
                        String nidnDsn = sc.nextLine();
                        // Asumsi dosen baru adalah DosenTetap untuk ilustrasi
                        Dosen dsnBaru = new DosenTetap(namaDsn, nidnDsn, mhs.getProdi(), "DT-BARU");
                        mhs.setDosenWali(dsnBaru);
                        System.out.println("✅ Dosen Wali berhasil diperbarui.");
                        mhs.tampilData();
                    }
                    break;

                /*case 5: // Tambah Mahasiswa Baru
                    if (jumlah < data.length) {
                        Mahasiswa mhsBaru = new MahasiswaReguler();
                        mhsBaru.inputData();
                        // Set Dosen Wali default untuk mahasiswa baru
                        Dosen dsnBaru = new DosenLB("Default Dosen LB", "99999", mhsBaru.getProdi());
                        mhsBaru.setDosenWali(dsnBaru);
                        
                        data[jumlah++] = mhsBaru;
                        System.out.println("✅ Mahasiswa baru berhasil ditambahkan!");
                    } else {
                        System.out.println("Kapasitas data mahasiswa penuh!");
                    }
                    break;*/
                
                case 6: // Kelola KRS Mahasiswa
                    mhs = cariMahasiswa(sc, data, jumlah);
                    if (mhs != null) menuKrs(sc, mhs);
                    break;
                    
                case 0:
                    System.out.println("Terima kasih telah menggunakan SIAKAD.");
                    break;
                    
                default:
                    System.out.println("❌ Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilih != 0);
        
        sc.close();
    }
}