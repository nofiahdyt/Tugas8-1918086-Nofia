package com.example.kumpulandoa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    ArrayList<DoaItem> doaItemArrayList;

    public Adapter(ArrayList<DoaItem> doaItemArrayList) {
        this.doaItemArrayList = doaItemArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,null,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, int position) {
        holder.judul.setText(doaItemArrayList.get(position).getId()+". "+
                doaItemArrayList.get(position).getDoa());
        holder.doa.setText(doaItemArrayList.get(position).getAyat());
        holder.latin.setText(doaItemArrayList.get(position).getLatin());
        holder.arti.setText(doaItemArrayList.get(position).getArtinya());
    }

    @Override
    public int getItemCount() {
        return doaItemArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView judul,doa,latin,arti;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            judul=itemView.findViewById(R.id.txt_NamaDoa);
            doa=itemView.findViewById(R.id.ayat);
            latin=itemView.findViewById(R.id.latin);
            arti=itemView.findViewById(R.id.artinya);
        }
    }
}
