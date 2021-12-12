package com.example.kumpulandoa;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Doa {

	@SerializedName("Doa")
	private List<DoaItem> doa;

	public List<DoaItem> getDoa(){
		return doa;
	}
}