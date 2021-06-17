package com.example.jadwalsholat.remote;

import com.example.jadwalsholat.model.JadwalSholatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v1/calendarByAddress?address=lampung&method=2&month=juni&year=2021")
    Call<JadwalSholatResponse> getJadwalSholat();
}
