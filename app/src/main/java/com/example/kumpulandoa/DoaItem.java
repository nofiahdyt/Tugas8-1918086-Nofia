package com.example.kumpulandoa;

import com.google.gson.annotations.SerializedName;

public class DoaItem{

	@SerializedName("ayat")
	private String ayat;

	@SerializedName("doa")
	private String doa;

	@SerializedName("artinya")
	private String artinya;

	@SerializedName("id")
	private String id;

	@SerializedName("latin")
	private String latin;

	public String getAyat(){
		return ayat;
	}

	public String getDoa(){
		return doa;
	}

	public String getArtinya(){
		return artinya;
	}

	public String getId(){
		return id;
	}

	public String getLatin(){
		return latin;
	}
}