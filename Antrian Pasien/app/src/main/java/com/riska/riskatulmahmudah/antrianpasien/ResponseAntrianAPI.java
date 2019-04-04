package com.riska.riskatulmahmudah.antrianpasien;

import com.google.gson.annotations.SerializedName;

public class ResponseAntrianAPI{

	@SerializedName("DokterID")
	private String dokterID;

	@SerializedName("NoUrut")
	private int noUrut;

	@SerializedName("AntrianID")
	private String antrianID;

	@SerializedName("NoAntrian")
	private int noAntrian;

	@SerializedName("Jam")
	private String jam;

	@SerializedName("Tgl")
	private String tgl;

	@SerializedName("RSID")
	private String rSID;

	@SerializedName("NamaPasien")
	private String namaPasien;

	@SerializedName("DokterName")
	private String dokterName;

	public ResponseAntrianAPI(String dokterID,
							  int noUrut,
							  String antrianID,
							  int noAntrian,
							  String jam,
							  String tgl,
							  String rSID,
							  String namaPasien,
							  String dokterName) {
		this.dokterID = dokterID;
		this.noUrut = noUrut;
		this.antrianID = antrianID;
		this.noAntrian = noAntrian;
		this.jam = jam;
		this.tgl = tgl;
		this.rSID = rSID;
		this.namaPasien = namaPasien;
		this.dokterName = dokterName;
	}

	public void setDokterID(String dokterID){
		this.dokterID = dokterID;
	}

	public String getDokterID(){
		return dokterID;
	}

	public void setNoUrut(int noUrut){
		this.noUrut = noUrut;
	}

	public int getNoUrut(){
		return noUrut;
	}

	public void setAntrianID(String antrianID){
		this.antrianID = antrianID;
	}

	public String getAntrianID(){
		return antrianID;
	}

	public void setNoAntrian(int noAntrian){
		this.noAntrian = noAntrian;
	}

	public int getNoAntrian(){
		return noAntrian;
	}

	public void setJam(String jam){
		this.jam = jam;
	}

	public String getJam(){
		return jam;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setRSID(String rSID){
		this.rSID = rSID;
	}

	public String getRSID(){
		return rSID;
	}

	public void setNamaPasien(String namaPasien){
		this.namaPasien = namaPasien;
	}

	public String getNamaPasien(){
		return namaPasien;
	}

	public void setDokterName(String dokterName){
		this.dokterName = dokterName;
	}

	public String getDokterName(){
		return dokterName;
	}
}