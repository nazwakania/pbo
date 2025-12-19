/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myclass;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sani Rahmatani
 */
public abstract class Mahasiswa {
    protected String nim;
    protected String nama;
    protected String prodi; 
    protected double ipk;
    protected int umur; // Atribut bar
    protected Dosen dosenWali;
    
    // Atribut Revisi untuk KRS
    private List<MataKuliah> krs; 
    private int jumlahKrs; 

    // --- Getter dan Setter dengan Validasi ---
    
    public String getNim(){ return nim; }
    public String getNama(){ return nama; }
    public String getProdi(){ return prodi; }
    public double getIpk(){ return ipk; }
    public Dosen getDOsenWali(){ return dosenWali; }
    public int getUmur(){ return umur; }
    
    public void setNama(String nama){ this.nama = nama; }
    public void setProdi(String prodi){ this.prodi = prodi; }
    public void setDosenWali(Dosen dosenWali){ this.dosenWali = dosenWali; }
    
    // Setter IPK dengan Validasi
    public void setIpk(double ipk){
        if (ipk < 0.0 || ipk > 4.0) {
            throw new IllegalArgumentException("IPK harus di antara 0.0 - 4.0!");
        }
        this.ipk = ipk;
    }
    
    // Setter Umur dengan Validasi
    public void setUmur(int umur){
        if (umur < 17) {
            throw new IllegalArgumentException("Umur minimal 17 tahun!");
        }
        this.umur = umur;
    }

    // --- Constructor (Diubah untuk Inisialisasi KRS) ---

    // Constructor default
    public Mahasiswa() {
        this.nim = "-";
        this.nama = "-";
        this.prodi = "-";
        this.ipk = 0.0;
        this.umur = 17;
        this.dosenWali = new Dosen();
        this.krs = new ArrayList<>(); // Inisialisasi KRS
        this.jumlahKrs = 0;
    }
    
    // Constructor berparameter (digunakan di Siakad lama, diinisialisasi KRS)
    public Mahasiswa(String nim, String nama, String prodi, double ipk, Dosen dosenWali) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.ipk = ipk; 
        this.umur = 17; // Default Umur untuk data lama
        this.dosenWali = dosenWali;
        this.krs = new ArrayList<>(); // Inisialisasi KRS
        this.jumlahKrs = 0;
    }
    
    // --- Method Input & Tampil Data ---
    
    // Method inputData() (Diubah untuk menambahkan input Umur dan Validasi IPK)
    void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM     : ");
        nim = input.nextLine();
        System.out.print("Masukkan Nama    : ");
        nama = input.nextLine();
        System.out.print("Masukkan Prodi   : ");
        prodi = input.nextLine();

        // Input IPK dengan validasi
        do {
            System.out.print("Masukkan IPK (0.0 - 4.0): ");
            String ipkStr = input.next().replace(",", ".");
            try {
                double tempIpk = Double.parseDouble(ipkStr);
                setIpk(tempIpk); 
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Format IPK tidak valid! Contoh: 3.75");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        input.nextLine(); 
        
        // Input Umur dengan validasi
        do {
            System.out.print("Masukkan Umur (minimal 17): ");
            try {
                int tempUmur = Integer.parseInt(input.nextLine());
                setUmur(tempUmur); 
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Format Umur tidak valid! Harus berupa angka.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    // Method tampilData() (Ditambahkan Umur dan Dosen Wali yang benar)
    abstract void  tampilData();
        
    
    // --- Method KRS (Tambahan Baru) ---

    public void tambahMataKuliah(MataKuliah mk) throws Exception {
        // Cek duplikasi kode MK
        for (MataKuliah mataKuliah : krs) {
            if (mataKuliah.getKode_matkul().equalsIgnoreCase(mk.getKode_matkul())) {
                throw new Exception("Mata kuliah dengan kode " + mk.getKode_matkul() + " sudah terdaftar!");
            }
        }
        // Cek total SKS maksimal (Opsional: max 24 SKS)
        int totalSksSaatIni = hitungTotalSKS();
        if (totalSksSaatIni + mk.getSks() > 24) {
            throw new Exception("❌ Total SKS melebihi batas maksimal 24! SKS saat ini: " + totalSksSaatIni);
        }
        krs.add(mk);
        jumlahKrs++;
        System.out.println("✅ Mata kuliah " + mk.getNamaMk() + " berhasil ditambahkan ke KRS.");
    }

    public void hapusMataKuliah(String kode) throws Exception {
        MataKuliah mkDihapus = null;
        for (MataKuliah mataKuliah : krs) {
            if (mataKuliah.getKode_matkul().equalsIgnoreCase(kode.trim())) {
                mkDihapus = mataKuliah;
                break;
            }
        }
        if (mkDihapus != null) {
            krs.remove(mkDihapus);
            jumlahKrs--;
            System.out.println("✅ Mata kuliah dengan kode " + kode.trim() + " berhasil dihapus dari KRS.");
        } else {
            throw new Exception("❌ Mata kuliah dengan kode " + kode.trim() + " tidak ditemukan di KRS!");
        }
    }

    private int hitungTotalSKS() {
        int totalSks = 0;
        for (MataKuliah mk : krs) {
            totalSks += mk.getSks();
        }
        return totalSks;
    }

    public void tampilKRS() {
        System.out.println("\n===== KRS Mahasiswa =====");
        System.out.println("Nama    : " + this.nama);
        System.out.println("NIM     : " + this.nim);
        System.out.println("Dosen Wali: " + this.dosenWali.getNama());
        System.out.println("Mata Kuliah Diambil:");

        if (krs.isEmpty()) {
            System.out.println("- Belum ada mata kuliah yang diambil -");
        } else {
            for (MataKuliah mk : krs) {
                System.out.println("- " + mk.info());
            }
        }
        System.out.println("Total SKS: " + hitungTotalSKS());
        System.out.println("=========================\n");
    }
}