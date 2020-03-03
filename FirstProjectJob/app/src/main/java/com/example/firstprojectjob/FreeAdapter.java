package com.example.firstprojectjob;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.FreeHolder> {
    @NonNull
    @Override
    public FreeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FreeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FreeHolder extends RecyclerView.ViewHolder{

        public FreeHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

