package com.example.kumpulandoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kumpulandoa.Adapter;
import com.example.kumpulandoa.DoaInterface;
import com.example.kumpulandoa.DoaItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<DoaItem> doaItemArrayList;
    private DoaInterface doaInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://doa-doa-api-ahmadramadhan.fly.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        doaInterface = retrofit.create(DoaInterface.class);

        getDoa();

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        doaItemArrayList = new ArrayList<>();
        adapter = new Adapter(doaItemArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void getDoa(){
        Call<List<DoaItem>> call = doaInterface.getDoa();
        call.enqueue(new Callback<List<DoaItem>>() {
            @Override
            public void onResponse(Call<List<DoaItem>> call, Response<List<DoaItem>> response) {
                List<DoaItem> doaItemList = response.body();
                doaItemArrayList.addAll(doaItemList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DoaItem>> call, Throwable t) {

            }
        });
    }
}