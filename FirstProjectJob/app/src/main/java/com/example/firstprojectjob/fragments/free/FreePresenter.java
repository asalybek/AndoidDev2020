package com.example.firstprojectjob.fragments.free;

import android.util.Log;

import com.example.firstprojectjob.model.Knp;
import com.example.firstprojectjob.rest.ApiClient;
import com.example.firstprojectjob.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FreePresenter {
    FragmentFree fragmentFree ;
    public FreePresenter(FragmentFree fragmentFree){
        this.fragmentFree = fragmentFree;
    }
    void getKnps() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        apiService.getKnpList().enqueue(new Callback<Knp[]>() {
            @Override
            public void onResponse(Call<Knp[]> call, Response<Knp[]> response) {
                /*int size  = response.body().length;
                Log.e("TAG","Size"+size);*/
                if (response.isSuccessful()) {
                    fragmentFree.modifyKnps(response.body());
                }
            }
            @Override
            public void onFailure(Call<Knp[]> call, Throwable t) {
                Log.e("REST", "Hi OnFailure", t);
            }
        });
    }
}
