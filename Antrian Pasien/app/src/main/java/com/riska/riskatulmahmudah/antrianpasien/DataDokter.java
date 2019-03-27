package com.riska.riskatulmahmudah.antrianpasien;

public class DataDokter {
    private int dokterID;
    private String dokterNama;
    private String dokterSpesialis;
    private String dokterAlamat;

    public DataDokter(int dokterID, String dokterNama, String dokterSpesialis, String dokterAlamat) {
        this.dokterID = dokterID;
        this.dokterNama = dokterNama;
        this.dokterSpesialis = dokterSpesialis;
        this.dokterAlamat = dokterAlamat;
    }

    public int getDokterID() {
        return dokterID;
    }

    public void setDokterID(int dokterID) {
        this.dokterID = dokterID;
    }

    public String getDokterNama() {
        return dokterNama;
    }

    public void setDokterNama(String dokterNama) {
        this.dokterNama = dokterNama;
    }

    public String getDokterSpesialis() {
        return dokterSpesialis;
    }

    public void setDokterSpesialis(String dokterSpesialis) {
        this.dokterSpesialis = dokterSpesialis;
    }

    public String getDokterAlamat() {
        return dokterAlamat;
    }

    public void setDokterAlamat(String dokterAlamat) {
        this.dokterAlamat = dokterAlamat;
    }
}
