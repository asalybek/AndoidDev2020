package com.example.firstprojectjob.rest;

import com.example.firstprojectjob.model.Knp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/banking/transfers/knps/")
    Call<Knp[]> getKnpList();
}

