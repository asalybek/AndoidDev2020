package com.example.firstprojectjob.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstprojectjob.IDislike;
<<<<<<< HEAD:FirstProjectJob/app/src/main/java/com/example/firstprojectjob/fragments/FragmentLiked.java
import com.example.firstprojectjob.RecyclerViewPresenter;
=======
>>>>>>> 249e58d08497a4155595a38e7d7e2f7296d912c2:FirstProjectJob/app/src/main/java/com/example/firstprojectjob/FragmentLiked.java
import com.example.firstprojectjob.model.Post;
import com.example.firstprojectjob.adapters.PostAdapter;
import com.example.firstprojectjob.model.PostsContainer;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.activities.SecondMainActivity;

import java.util.List;
import java.util.Objects;

public class FragmentLiked extends Fragment implements IDislike {
    private RecyclerView recyclerView;
//    RecyclerViewPresenter mRecyclerViewPresenter;
////    public FragmentLiked(RecyclerViewPresenter mRecyclerViewPresenter){
////        this.mRecyclerViewPresenter = mRecyclerViewPresenter;
////    }
    private PostAdapter adapter;
    private List<Post> dataSet;
    private PostsContainer postsContainer = PostsContainer.get();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_liked, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        dataSet = postsContainer.getLikedPosts();

        adapter = new PostAdapter(dataSet,this);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;
    }

    public void updateLike() {
        dataSet.clear();
        dataSet.addAll(postsContainer.getLikedPosts());
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
        ((SecondMainActivity) Objects.requireNonNull(getActivity())).onPostDisLike();
    }
}

