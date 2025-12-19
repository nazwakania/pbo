/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myclass;

/**
 *
 * @author Sani Rahmatani
 */
public class DosenLB extends Dosen {

    // Constructor
    public DosenLB(String nama, String nidn, String prodi) {
        super(nama, nidn, prodi, "Luar Biasa"); // Status Dosen di set default "Luar Biasa"
    }

    // Override method absen()
    @Override
    public void absen() {
        System.out.println("✅ Dosen Luar Biasa: " + super.getNama() + " berhasil absen mengajar mata kuliah.");
    }
}
