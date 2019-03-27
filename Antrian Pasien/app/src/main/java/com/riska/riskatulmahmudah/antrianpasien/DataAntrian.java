package com.riska.riskatulmahmudah.antrianpasien;

class DataAntrian {
    //9.deklarasikan apa apa saja yang akan ditampilkan di rv
    private int antrianNo;
    private String antrianNama;
    private String antrianAlamat;

    //10. create construktor
    public DataAntrian(int antrianNo, String antrianNama, String antrianAlamat) {
        this.antrianNo = antrianNo;
        this.antrianNama = antrianNama;
        this.antrianAlamat = antrianAlamat;
    }

    //11.generate getter setter
    public int getAntrianNo() {
        return antrianNo;
    }

    public void setAntrianNo(int antrianNo) {
        this.antrianNo = antrianNo;
    }

    public String getAntrianNama() {
        return antrianNama;
    }

    public void setAntrianNama(String antrianNama) {
        this.antrianNama = antrianNama;
    }

    public String getAntrianAlamat() {
        return antrianAlamat;
    }

    public void setAntrianAlamat(String antrianAlamat) {
        this.antrianAlamat = antrianAlamat;
    }
}
