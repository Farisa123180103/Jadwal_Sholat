package com.example.jadwalsholat.view;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jadwalsholat.model.DataItem;
import com.example.jadwalsholat.model.JadwalSholatResponse;
import com.example.jadwalsholat.remote.BaseApp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalViewModel extends ViewModel {
    private BaseApp baseApp;

    private MutableLiveData<ArrayList<DataItem>> listJadwalSholat = new MutableLiveData<ArrayList<DataItem>>();

    public void setJadwalSholat() {
        if (this.baseApp == null) {
            baseApp = new BaseApp();
        }

        baseApp.getApiJadwal().getJadwalSholat().enqueue(new Callback<JadwalSholatResponse>() {
            @Override
            public void onResponse(Call<JadwalSholatResponse> call, Response<JadwalSholatResponse> response) {
                JadwalSholatResponse responseSholat = response.body();
                if (responseSholat != null && responseSholat.getData() != null) {
                    ArrayList<DataItem> data = responseSholat.getData();
                    listJadwalSholat.postValue(data);
                    Log.d("JadwalViewModel", "onSuccess: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<JadwalSholatResponse> call, Throwable t) {
                Log.e("JadwalViewModel", "onFailure: "+t.getMessage());
            }
        });
    }
    public LiveData<ArrayList<DataItem>> getJadwalSholat(){
        return listJadwalSholat;
    }
}
