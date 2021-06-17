package com.example.jadwalsholat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.model.DataItem;

import java.util.ArrayList;

public class JadwalSholatAdapter extends RecyclerView.Adapter<JadwalSholatAdapter.ViewHolder> {

    private ArrayList<DataItem> dataItems = new ArrayList<>();
    private Context context;

    public JadwalSholatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        dataItems.clear();
        dataItems.addAll(items);
        notifyDataSetChanged();//gk tau fungsinya apa
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_solat,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.terbit.setText(dataItems.get(position).getTimings().getSunrise());
        holder.imsak.setText(dataItems.get(position).getTimings().getImsak());
        holder.subuh.setText(dataItems.get(position).getTimings().getFajr());
        holder.duhur.setText(dataItems.get(position).getTimings().getDhuhr());
        holder.asar.setText(dataItems.get(position).getTimings().getAsr());
        holder.magrib.setText(dataItems.get(position).getTimings().getMaghrib());
        holder.isya.setText(dataItems.get(position).getTimings().getIsha());
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView imsak, subuh, terbit, duhur, asar, magrib, isya;
//        TextView jm_imsak, jm_subuh, jm_terbit, jm_duhur, jm_asar, jm_magrib, jm_isya;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                imsak = itemView.findViewById(R.id.tv_jam_imsak);
                subuh = itemView.findViewById(R.id.tv_jam_subuh);
                terbit = itemView.findViewById(R.id.tv_jam_terbit);
                duhur = itemView.findViewById(R.id.tv_jam_dhuhur);
                asar = itemView.findViewById(R.id.tv_jam_asar);
                magrib = itemView.findViewById(R.id.tv_jam_magrib);
                isya = itemView.findViewById(R.id.tv_jam_isya);
        }
    }
}
