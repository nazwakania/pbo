/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myclass;

/**
 *
 * @author Sani Rahmatani
 */
public class MataKuliah {
 
    private String kode_matkul;
    private String namaMk;
    private int sks;

    // Constructor
    public MataKuliah(String kode_matkul, String namaMk, int sks) {
        setKode_matkul(kode_matkul);
        this.namaMk = namaMk;
        setSks(sks);
    }

    // Getters
    public String getKode_matkul() {
        return kode_matkul;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public int getSks() {
        return sks;
    }

    // Setters dengan Validasi
    public void setKode_matkul(String kode_matkul) {
        if (kode_matkul == null || kode_matkul.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Kode matkul tidak boleh kosong!");
        }
        this.kode_matkul = kode_matkul.trim();
    }

    public void setSks(int sks) {
        if (sks < 1 || sks > 6) {
            throw new IllegalArgumentException("❌ SKS harus berada di antara 1-6!");
        }
        this.sks = sks;
    }
    
    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    // Method info() sesuai format
    public String info() {
        return String.format("%s - %s (%d SKS)", kode_matkul, namaMk, sks);
    }
}