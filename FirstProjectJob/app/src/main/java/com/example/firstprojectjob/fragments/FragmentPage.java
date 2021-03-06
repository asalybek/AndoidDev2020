package com.example.firstprojectjob.fragments;

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

import com.example.firstprojectjob.IChange;
import com.example.firstprojectjob.adapters.PostAdapter;
import com.example.firstprojectjob.model.PostsContainer;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.activities.SecondMainActivity;

import java.util.Objects;

public class FragmentPage extends Fragment implements IChange {
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private PostsContainer postsContainer = PostsContainer.get();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(getClass().getSimpleName(), "onCreateView");
        View v = inflater.inflate(R.layout.fragment_page,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);
        adapter = new PostAdapter(postsContainer.getAllPosts(),this);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onPostLike() {
        ((SecondMainActivity) Objects.requireNonNull(getActivity())).onPostLike();
    }
    public void updateLike(){
        adapter = new PostAdapter(postsContainer.getAllPosts(),this);
        recyclerView.setAdapter(adapter);
    }
}
