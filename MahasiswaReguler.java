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
public class MahasiswaReguler extends Mahasiswa { // Pewarisan dari Mahasiswa
    
    int IdKategoriKelas;
    
    public MahasiswaReguler(String nim, String nama, String prodi, double ipk, Dosen dosenWali){
        super(nim, nama, prodi, ipk, dosenWali);
        setIdKategoriKelas (IdKategoriKelas);
        
    }
    
    public int getidKategoriKelas(){ 
        return IdKategoriKelas; 
    }
    
    public void setIdKategoriKelas(int idKategoriKelas){ 
        this.IdKategoriKelas = idKategoriKelas; 
    }
    
    // Override method tampilData() untuk menampilkan data tambahan
    @Override
    public void tampilData() {
        System.out.println("-----------------------------------");
        System.out.println("NIM        : " + nim);
        System.out.println("Nama       : " + nama);
        System.out.println("Prodi      : " + prodi);
        System.out.println("IPK        : " + ipk);
        System.out.println("Umur       : " + umur); // Tambahan
        System.out.println("Dosen Wali : " + dosenWali); 
    }


}

