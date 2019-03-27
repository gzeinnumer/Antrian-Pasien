package com.riska.riskatulmahmudah.antrianpasien;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDokter{

	@SerializedName("result_dokter")
	private List<ResultDokterItem> resultDokter;

	@SerializedName("kode")
	private int kode;

	public void setResultDokter(List<ResultDokterItem> resultDokter){
		this.resultDokter = resultDokter;
	}

	public List<ResultDokterItem> getResultDokter(){
		return resultDokter;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}