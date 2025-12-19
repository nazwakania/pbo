/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myclass;

/**
 *
 * @author Sani Rahmatani
 */

public class DosenTetap extends Dosen {
    
    // Atribut tambahan
    private String nip;

    // Constructor
    public DosenTetap(String nama, String nidn, String prodi, String nip) {
        super(nama, nidn, prodi, "Tetap"); // Status Dosen di set default "Tetap"
        this.nip = nip;
    }

    // Getter
    public String getNip() {
        return nip;
    }

    // Setter
    public void setNip(String nip) {
        this.nip = nip;
    }

    // Override method absen()
    @Override
    public void absen() {
        System.out.println("✅ Dosen Tetap: " + super.getNama() + " (NIP: " + nip + ") berhasil absen masuk kerja.");
    }
}
