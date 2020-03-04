package com.example.firstprojectjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstprojectjob.model.Knp;

import java.util.List;

public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.FreeHolder> {
    private List<Knp> mKnpList;

    public FreeAdapter(List<Knp> mKnpList){
        this.mKnpList = mKnpList;
    }
    @NonNull
    @Override
    public FreeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.knp_row,parent,false);
        return new FreeHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull FreeHolder holder, int position) {
        Knp knp = mKnpList.get(position);
        holder.name.setText(knp.getName());
    }

    @Override
    public int getItemCount() {
        return mKnpList.size();
    }

    public class FreeHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public FreeHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_txt);
        }
    }
}

