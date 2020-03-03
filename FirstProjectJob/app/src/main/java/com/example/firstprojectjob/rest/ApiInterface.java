package com.example.firstprojectjob.rest;

import com.example.firstprojectjob.model.Knp;
import com.example.firstprojectjob.model.KnpResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("https://armrbk.kazincombank.kz:30500/banking/transfers/knps/")
    Call<Knp[]> getKnpList();
    //Call<KnpResponse> getKnpListSize();
}

