package com.example.firstprojectjob.fragments.free;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstprojectjob.adapters.FreeAdapter;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.model.Knp;
import com.example.firstprojectjob.rest.ApiClient;
import com.example.firstprojectjob.rest.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFree extends Fragment {
    RecyclerView recyclerView;
    private FreeAdapter freeAdapter;
    private List<Knp> mKnpList = new ArrayList<>();
    FreePresenter freePresenter = new FreePresenter(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_free,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);
        freeAdapter = new FreeAdapter(mKnpList);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(freeAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),LinearLayoutManager.VERTICAL));
        //getKnps();

        freePresenter.getKnps();

        return v;
    }

//    public void getKnps() {
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        apiService.getKnpList().enqueue(new Callback<Knp[]>() {
//            @Override
//            public void onResponse(Call<Knp[]> call, Response<Knp[]> response) {
//                /*int size  = response.body().length;
//                Log.e("TAG","Size"+size);*/
//                if (response.isSuccessful()) {
//                    for (Knp knp : response.body()) {
//                        mKnpList.add(knp);
//                    }
//                   freeAdapter.notifyDataSetChanged();
//                }
//            }
//            @Override
//            public void onFailure(Call<Knp[]> call, Throwable t) {
//                Log.e("REST", "Hi OnFailure", t);
//            }
//        });
//    }

    public void modifyKnps(Knp[] knps){

        mKnpList.addAll(Arrays.asList(knps));

//        for (Knp knp : knps) {
//            mKnpList.add(knp);
//        }
        freeAdapter.notifyDataSetChanged();
    }
}
