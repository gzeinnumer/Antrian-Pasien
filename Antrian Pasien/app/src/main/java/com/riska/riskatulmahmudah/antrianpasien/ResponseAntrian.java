package com.riska.riskatulmahmudah.antrianpasien;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseAntrian{

	@SerializedName("result_antrian")
	private List<ResultAntrianItem> resultAntrian;

	@SerializedName("kode")
	private int kode;

	public void setResultAntrian(List<ResultAntrianItem> resultAntrian){
		this.resultAntrian = resultAntrian;
	}

	public List<ResultAntrianItem> getResultAntrian(){
		return resultAntrian;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}