package com.example.firstprojectjob.rest;

import com.example.firstprojectjob.model.Knp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("https://armrbk.kazincombank.kz:30500/banking/transfers/knps/")
    Call<Knp[]> getKnpList();
}

