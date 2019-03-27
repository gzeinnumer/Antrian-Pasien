package com.riska.riskatulmahmudah.antrianpasien;

import com.google.gson.annotations.SerializedName;

public class ResultDokterItem{

	@SerializedName("dokter_id")
	private String dokterId;

	@SerializedName("dokter_alamat")
	private String dokterAlamat;

	@SerializedName("dokter_nama")
	private String dokterNama;

	@SerializedName("dokter_spesialis")
	private String dokterSpesialis;

	public void setDokterId(String dokterId){
		this.dokterId = dokterId;
	}

	public String getDokterId(){
		return dokterId;
	}

	public void setDokterAlamat(String dokterAlamat){
		this.dokterAlamat = dokterAlamat;
	}

	public String getDokterAlamat(){
		return dokterAlamat;
	}

	public void setDokterNama(String dokterNama){
		this.dokterNama = dokterNama;
	}

	public String getDokterNama(){
		return dokterNama;
	}

	public void setDokterSpesialis(String dokterSpesialis){
		this.dokterSpesialis = dokterSpesialis;
	}

	public String getDokterSpesialis(){
		return dokterSpesialis;
	}

	public ResultDokterItem(String dokterId, String dokterAlamat, String dokterNama, String dokterSpesialis) {
		this.dokterId = dokterId;
		this.dokterAlamat = dokterAlamat;
		this.dokterNama = dokterNama;
		this.dokterSpesialis = dokterSpesialis;
	}
}
