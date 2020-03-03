package com.example.firstprojectjob;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentPage extends Fragment implements IChange {
    RecyclerView recyclerView;
    private  PostAdapter adapter;
    ImageButton like;
    PostsContainer postsContainer = PostsContainer.get(getContext());
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(getClass().getSimpleName(), "onCreateView");
        View v = inflater.inflate(R.layout.fragment_page,container,false);
        like = v.findViewById(R.id.ic_like);
        recyclerView = v.findViewById(R.id.recyclerView);

        adapter = new PostAdapter(postsContainer.getAllPosts(),this);
        //adapter.setChangeListener(this);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        return v;
    }
    @Override
    public void onPostLike() {

        ((SecondMainActivity)getActivity()).onPostLike();
        Log.e(getClass().getSimpleName(), "onPostLike");
        //

    }
    public void updateLike(){
        Log.e(getClass().getSimpleName(),"updateLike");
        adapter = new PostAdapter(postsContainer.getAllPosts(),this);
        recyclerView.setAdapter(adapter);
    }

}
