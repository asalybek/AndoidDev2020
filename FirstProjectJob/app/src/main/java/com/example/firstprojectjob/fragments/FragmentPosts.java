package com.example.firstprojectjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstprojectjob.IChange;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.activities.SecondMainActivity;
import com.example.firstprojectjob.adapters.PostAdapter;
import com.example.firstprojectjob.model.Post;
import com.example.firstprojectjob.model.PostsContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentPosts extends Fragment implements IChange {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private boolean isAllPostVersion;
    private List<Post> dataSet = new ArrayList<>();

    private PostsContainer postsContainer = PostsContainer.get();

    public static FragmentPosts newInstance(boolean isAllPostVersion) {

        FragmentPosts fragment = new FragmentPosts();
        fragment.isAllPostVersion = isAllPostVersion;
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_posts,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);

        if(isAllPostVersion){
            Log.d("FragmentPosts","getALLPosts");
            dataSet.addAll(postsContainer.getAllPosts());
        }
        else{
            dataSet.addAll(postsContainer.getLikedPosts());
        }
        adapter = new PostAdapter(dataSet,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;

    }
    public void onPostLike() {
        ((SecondMainActivity)getActivity()).onPostLike();
    }
    public void updateLike(){

        Log.e(getClass().getSimpleName() +  (isAllPostVersion  ? "_ALL" : "_LIKE"), "init size: " + dataSet.size() );
        dataSet.clear();
        Log.e(getClass().getSimpleName()+  (isAllPostVersion  ? "_ALL" : "_LIKE"), "after clear size: " + dataSet.size() );
        dataSet.addAll(postsContainer.getLikedPosts());
        Log.e(getClass().getSimpleName()+  (isAllPostVersion  ? "_ALL" : "_LIKE"), "after add size: " + dataSet.size() );
        adapter.notifyDataSetChanged();
        //adapter = new PostAdapter(postsContainer.getLikedPosts(),this);
        //recyclerView.setAdapter(adapter);
    }
    public void updatePage(){
//        adapter = new PostAdapter(postsContainer.getAllPosts(),this);
//        recyclerView.setAdapter(adapter);

        Log.e(getClass().getSimpleName()+  (isAllPostVersion  ? "_ALL" : "_LIKE"), "init size: " + dataSet.size() );
        dataSet.clear();
        Log.e(getClass().getSimpleName()+  (isAllPostVersion  ? "_ALL" : "_LIKE"), "after clear size: " + dataSet.size() );
        Log.e(getClass().getSimpleName()+  (isAllPostVersion  ? "_ALL" : "_LIKE"), "all post size: " + postsContainer.getAllPosts().size() );
        dataSet.addAll(postsContainer.getAllPosts());
        Log.e(getClass().getSimpleName()+  (isAllPostVersion  ? "_ALL" : "_LIKE"), "after add size: " + dataSet.size() );
        adapter.notifyDataSetChanged();
    }

    public void updateBoth(){
        if(isAllPostVersion){
            adapter = new PostAdapter(postsContainer.getAllPosts(),this);
        }
        else {
            adapter = new PostAdapter(postsContainer.getLikedPosts(),this);
        }
        recyclerView.setAdapter(adapter);

    }
}
