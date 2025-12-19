/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myclass;

/**
 *
 * @author Sani Rahmatani
 */
public class Dosen {
    private String nama;
    private String nidn;
    private String prodi;
    private String statusDosen;

    // Getter
    public String getNama(){
        return nama;
    }
    public String getNidn(){
        return nidn;
    }

    public String getProdi(){
        return prodi;
    }

    public String getStatus(){
        return statusDosen;
    }
    // Method 'getdosenWali()' dihapus

    // Setter
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNidn(String nidn){
        this.nidn = nidn;
    }
    public void setProdi(String prodi){
        this.prodi = prodi;
    }
    public void setStatus(String status){
        this.statusDosen = status; // Mengubah 'statusDosen' ke 'status' agar sesuai dengan parameter
    }
    // Method 'setdosenWali()' dihapus

    // Constructor default
    public Dosen() {
        this.nama = "Belum Ditetapkan";
        this.nidn = "-";
        this.prodi = "-";
        this.statusDosen = "Tetap";
    }

    // Constructor berparameter
    public Dosen(String nama, String nidn, String prodi, String statusDosen) {
        this.nama = nama;
        this.nidn = nidn;
        this.prodi = prodi;
        this.statusDosen = statusDosen;
    }

    // --- Method Baru: absen() ---
    public void absen() {
        System.out.println("Absensi Dosen " + this.nama + " sedang diproses (Parent Class).");
    }

    String getdosenWali() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

