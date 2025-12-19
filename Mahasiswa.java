/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.praktikum;

import java.util.Scanner;

/**
 *
 * @author Fajar Saputra
 */
public class Mahasiswa {
    String nim;
    String nama;
    String prodi;
    double ipk;
    int kehadiran; // Tambahkan variabel untuk menyimpan jumlah kehadiran
    
    Dosen dosenWali;
    

    // Method menampilkan data mahasiswa
    public Mahasiswa( String nama1, String nim1, double ipk1, Dosen dosen){
        
    }
    
    public Mahasiswa(String nim, String nama,String prodi, Double ipk){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.ipk = ipk;
    }
    
    public Mahasiswa(String nim, String nama,String prodi, Double ipk, Dosen dosenWali){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.ipk = ipk;
        this.dosenWali = dosenWali;
    }
    
    // Setter & Getter
    public String getNama(){
        return nama;
    }
    
    public String getNim(){
        return nim;
    }
    
    public double getIpk(){
        return ipk;
    }
    
    public Dosen getDosenWali(){
        return dosenWali;
    }
    
    public void setDosenWali(Dosen dosenWali) {
        this.dosenWali = dosenWali;
    }
    
    public void updateNamaDosenWali(String namaBaru){
        if(this.dosenWali == null){
            this.dosenWali = new Dosen(namaBaru, "N/A", "N/A", "Aktif");
        } else {
           this.dosenWali.setNamaDosen(namaBaru); 
        }
    }
    
    /*void tampilData() {
        System.out.println("-----------------------------------");
        System.out.println("NIM       : " + nim);
        System.out.println("Nama      : " + nama);
        System.out.println("Prodi     : " + prodi);
        System.out.println("IPK       : " + ipk);
        System.out.println("Dosen Wali: " + dosenWali);
        System.out.println("Absensi   : " + hitungAbsensi());
        System.out.println("-----------------------------------");
    }*/
    
    /*public void setDosenWali(String namaDosen){
        this.dosenWali = new Dosen(namaDosen, "-", "-", "Aktif");
    }*/

    // Method menentukan predikat IPK
    public String predikatKelulusan() {
        if (ipk >= 3.5) return "Predikat: Cumlaude";
        else if (ipk >= 3.0)return "Sangat Memuaskan";
        else if (ipk >= 2.5)return "Memuaskan";
        else if (ipk >= 2.0)return "Cukup";
        else return "Tidak Lulus";
    }

    // Method input data mahasiswa
    /*void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM       : ");
        nim = input.nextLine();
        System.out.print("Masukkan Nama      : ");
        nama = input.nextLine();
        System.out.print("Masukkan Prodi     : ");
        prodi = input.nextLine();
        System.out.print("Masukkan IPK       : ");
        ipk = input.nextDouble();
        System.out.print("Masukkan Kehadiran : ");
        kehadiran = input.nextInt(); // input kehadiran sebagai persentase
    }*/
    
    public void infoSingkat(){
        System.out.println(nama + " (" + nim + ") - IPK: " + ipk + " - Dosen Wali: " + 
                (dosenWali != null ? dosenWali.getNamaDosen() : "Belum ada"));
    }

    // Method menentukan status absensi
    String hitungAbsensi() {
        if (kehadiran >= 75) return "Hadir";
        else return "Tidak Hadir";
    }

}

