/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum;
import java.util.Scanner;
import java.util.Locale;
/**
 *
 * @author Sani Rahmatani
 */
public class Siakad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        Mahasiswa[] mhs = new Mahasiswa[100];
        int jumlah = 3;
        int pilihan;
        
        Dosen dosenAwal = new Dosen("Prof. Ani", "987654", "Teknik Informatika", "Aktif");
        mhs[0] = new Mahasiswa("Budi Santosa", "2022001", 3.75, dosenAwal);
        mhs[1] = new Mahasiswa("Sani Rahmatani", "242011021", 4.00, dosenAwal);
        mhs[2] = new Mahasiswa("Nelidasuki Ramdani","242011022", 4.00, dosenAwal);
        
        do{
            System.out.println("\n=== MENU SIAKAD ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Daftar Mahasiswa");
            System.out.println("3. Cari Berdasarkan NIM");
            System.out.println("4. Hitung Rata-rata IPK");
            System.out.println("5. Ganti Dosen Wali");
            System.out.println("0. Keluar");
            System.out.println("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();
            
            switch(pilihan){
                case 1:
                    System.out.print("Nama: ");
                    String nama = input.nextLine();
                    System.out.print("NIM: ");
                    String nim = input.nextLine();
                    
                    boolean nimUnik = true;
                    for (int i =0; i < jumlah; i++){
                        if(mhs[i].getNim().equals(nim)){
                            nimUnik = false;
                            break;
                        }                       
                    }
                
                
                    if(!nimUnik){
                        System.out.println("❌ NIM sudah digunakan!");
                        break;
                    }
                    System.out.print("IPK: ");
                    double ipk = input.nextDouble();
                    input.nextLine();
                    
                    if(ipk < 0.0 || ipk > 4.0){
                        System.out.println("❌ IPK tidak valid!");
                        break;
                    }
                    
                    System.out.print("Nama Dosen Wali: ");
                    String namaDosen = input.nextLine();
                    Dosen dosen = new Dosen(namaDosen, "123456", "Teknik Informatika", "Tetap");
                    mhs[jumlah]= new Mahasiswa(nama, nim, ipk, dosen);
                    jumlah++;
                    
                    System.out.println("✅ Mahasiswa berhasil ditambahkan!");
                    break;

                    
                case 2:
                    System.out.println("\n=== Daftar Mahasiswa ===");
                    if(jumlah == 0){
                        System.out.println("Belum ada data mahasiswa yang terdaftar");
                    } else{
                        for(int i = 0; i < jumlah; i++){
                            mhs[i].infoSingkat();
                        }                              
                    }
                    break;
                    
                case 3:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cariNim = input.nextLine();
                    boolean ditemukan = false;
                    
                    for(int i = 0; i < jumlah; i++){
                        if(mhs[i].getNim().equals(cariNim)){
                            System.out.println("=== Data Mahasiswa ===");
                            mhs[i].infoSingkat();
                            System.out.println("Predikat: " + mhs[i].predikatKelulusan());
                            ditemukan = true;
                            break;
                        }
                    }
                    
                    if(!ditemukan){
                        System.out.println("❌ Mahasiswa tidak ditemukan");
                    }
                    break;
                    
                case 4:
                    double total = 0;
                    for(int i = 0; i < jumlah; i++){
                        total += mhs[i].getIpk();
                    }
                    double rata = (jumlah > 0) ? total / jumlah : 0;
                    System.out.println("📊 Rata-rata IPK " + rata);
                
                    break;

                case 5:
                    System.out.print("Masukan NIM mahasiswa: ");
                    String nimGanti = input.nextLine();
                    boolean ketemu = false;
                    
                    for(int i = 0; i < jumlah; i++){
                        if(mhs[i].getNim().equals(nimGanti)){
                            System.out.print("Masukan nama dosen wali baru: ");
                            String dosenBaru = input.nextLine();
                            
                            mhs[i].updateNamaDosenWali(dosenBaru);
                            System.out.println("✅ Dosen wali berhasil diganti!");
                            ketemu = true;
                            break;
                        }
                    }
                    if(!ketemu){
                        System.out.println("❌ NIM tidak ditemukan!");
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while(pilihan != 0);
        
        input.close();
        
        
        
        
        /*Dosen dosenWali = new Dosen("Bu Gia", "12345", "Teknik Informatika", "Tetap");
        Mahasiswa mhs1= new Mahasiswa("242011021", "Sani Rahmatani", "Teknik Informatika", 4.00, dosenWali);
        
        System.out.println("\n");
        
        // Objek 1: Data dimasukkan manual
        Mahasiswa mhs2 = new Mahasiswa();
        mhs2.setDosenWali("Bu Gia");
        mhs2.infoSingkat();
        
        System.out.println();
        System.out.println("=== Data Mahasiswa Manual ===");
        System.out.println("NIM       : 2310001");
        System.out.println("Nama      : Andi Pratama");
        System.out.println("Prodi     : Teknik Informatika");
        System.out.println("IPK       : 3.65");
        System.out.println("Dosen Wali: " + mhs2.getDosenWali().getNama());
        System.out.println();
        

        // Objek 2: Data dimasukkan manual juga
        Mahasiswa mhs3 = new Mahasiswa("2310002", "Budi Santoso", "Sistem Informasi", 2.75, dosenWali);

//        // Objek 3: Input data lewat scanner (method inputData)
//        System.out.println("\n=== Input Data Mahasiswa Baru ===");
//        Mahasiswa mhs4 = new Mahasiswa();
//        mhs4.inputData();

        // Tampilkan semua data mahasiswa
        System.out.println("\n=== DATA MAHASISWA TERDAFTAR ===");
        mhs1.tampilData();
        mhs3.tampilData();
//        mhs4.tampilData();*/
    }
}
