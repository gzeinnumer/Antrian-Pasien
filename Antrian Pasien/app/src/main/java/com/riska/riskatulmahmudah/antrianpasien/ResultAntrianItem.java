package com.riska.riskatulmahmudah.antrianpasien;

import com.google.gson.annotations.SerializedName;

public class ResultAntrianItem{

	@SerializedName("pasien_id")
	private String pasienId;

	@SerializedName("pasien_nama")
	private String pasienNama;

	@SerializedName("dokter_id")
	private String dokterId;

	@SerializedName("pasien_alamat")
	private String pasienAlamat;

	@SerializedName("pasien_antrian")
	private String pasienAntrian;

	public void setPasienId(String pasienId){
		this.pasienId = pasienId;
	}

	public String getPasienId(){
		return pasienId;
	}

	public void setPasienNama(String pasienNama){
		this.pasienNama = pasienNama;
	}

	public String getPasienNama(){
		return pasienNama;
	}

	public void setDokterId(String dokterId){
		this.dokterId = dokterId;
	}

	public String getDokterId(){
		return dokterId;
	}

	public void setPasienAlamat(String pasienAlamat){
		this.pasienAlamat = pasienAlamat;
	}

	public String getPasienAlamat(){
		return pasienAlamat;
	}

	public void setPasienAntrian(String pasienAntrian){
		this.pasienAntrian = pasienAntrian;
	}

	public String getPasienAntrian(){
		return pasienAntrian;
	}

	public ResultAntrianItem(String pasienId, String pasienNama, String dokterId, String pasienAlamat, String pasienAntrian) {
		this.pasienId = pasienId;
		this.pasienNama = pasienNama;
		this.dokterId = dokterId;
		this.pasienAlamat = pasienAlamat;
		this.pasienAntrian = pasienAntrian;
	}
}