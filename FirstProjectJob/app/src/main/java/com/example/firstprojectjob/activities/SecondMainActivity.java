package com.example.firstprojectjob.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.firstprojectjob.IChange;
import com.example.firstprojectjob.IDislike;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.TabDesigner;
import com.example.firstprojectjob.adapters.ViewPagerFragmentAdapter;
import com.example.firstprojectjob.fragments.FragmentLiked;
import com.example.firstprojectjob.fragments.FragmentPage;
import com.example.firstprojectjob.fragments.FragmentPosts;
import com.example.firstprojectjob.model.PostsContainer;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class SecondMainActivity extends AppCompatActivity implements IChange {

    private FragmentPosts fragmentPage;
    private FragmentPosts fragmentLiked;
    PostsContainer postsContainer = PostsContainer.get();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(), 0, getFragments()));
        tabLayout.setupWithViewPager(viewPager);
        TabDesigner.setupTabIcons(tabLayout);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        fragmentPage = FragmentPosts.newInstance(true);
        fragmentLiked = FragmentPosts.newInstance(false);
        fragments.add(fragmentPage);
        fragments.add(fragmentLiked);

        return fragments;
    }

    @Override
    public void onPostLike() {
        fragmentPage.updatePage();
        fragmentLiked.updateLike();
//        fragmentPage.updateBoth();
//        fragmentLiked.updateBoth();

    }
//    @Override
//    public void onPostDisLike() {
//        fragmentLiked.updateLike();
//        fragmentPage.updateLike();
//    }
    }

