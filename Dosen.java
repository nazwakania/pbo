/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum;

/**
 *
 * @author Sani Rahmatani
 */
public class Dosen {
    String namaDosen;
    String nidn;
    String prodi;
    String statusDosen;
    
    public Dosen() {
        
    }
    
    public Dosen(String namaDosen,String nidn,String prodi, String statusDosen){
        this.namaDosen = namaDosen;
        this.nidn = nidn;
        this.prodi = prodi;
        this.statusDosen = statusDosen;
    }
    
    public String getNamaDosen(){
        return namaDosen;
    }
    
    public void getNamaDosen(String namaDosen){
        this.namaDosen = namaDosen;
    }
    
    public String getNidn(){
        return nidn;
    }
    
    public void getNidn(String nidn){
        this.nidn = nidn;
    }
    
    public String getProdi(){
        return prodi;
    }
    
    public String getProdi(String prodi){
        this.prodi = prodi;
        return null;
    }
    
    public String getStatusDosen(){
        return statusDosen;
    }
    
    public void getStatusDosen(String statusDosen){
        this.statusDosen = statusDosen;
    }
    
    public void info() {
        System.out.println("Nama Dosen  : " + namaDosen);
        System.out.println("NIDN        : " + nidn);
        System.out.println("Prodi       : " + prodi);
        System.out.println("Status Dosen: " + statusDosen);
    }

    void setNamaDosen(String namaBaru) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

