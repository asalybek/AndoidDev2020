package com.example.firstprojectjob;

import android.os.Bundle;
import android.os.Handler;
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

import java.util.List;

public class FragmentLiked extends Fragment implements IDislike {
    RecyclerView recyclerView;
    private PostAdapter adapter;
    ImageButton like;
    private List<Post> dataSet;
    PostsContainer postsContainer = PostsContainer.get(getContext());

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.e(getClass().getSimpleName(), "onCreateView");
        View v = inflater.inflate(R.layout.fragment_liked, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        dataSet = postsContainer.getLikedPosts();

        adapter = new PostAdapter(dataSet,this);
        //adapter.setDislikeListener(this);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        like = v.findViewById(R.id.ic_like);
        return v;
    }

    public void updateLike() {
        Log.e("Update", "updateLike");

        dataSet.clear();
        dataSet.addAll(PostsContainer.get(getContext()).getLikedPosts());
        adapter.notifyDataSetChanged();

        //adapter = new PostAdapter(postsContainer.getLikedPosts(),this);
        //adapter.setDislikeListener(this);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                recyclerView.setAdapter(adapter);
//            }
//        }, 300);


    }

    @Override
    public void onPostDisLike() {
        ((SecondMainActivity) getActivity()).onPostDisLike();
    }
}

