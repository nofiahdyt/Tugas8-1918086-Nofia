package com.example.kumpulandoa;

import com.example.kumpulandoa.DoaItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DoaInterface {

    String BASE_URL="https://doa-doa-api-ahmadramadhan.fly.dev/";

    @GET("api") Call<List<DoaItem>> getDoa();
}
