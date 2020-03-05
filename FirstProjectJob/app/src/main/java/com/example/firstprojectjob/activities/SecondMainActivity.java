package com.example.firstprojectjob.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.firstprojectjob.IChange;
import com.example.firstprojectjob.IDislike;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.adapters.ViewPagerFragmentAdapter;
import com.example.firstprojectjob.fragments.FragmentLiked;
import com.example.firstprojectjob.fragments.FragmentPage;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class SecondMainActivity extends AppCompatActivity implements IChange, IDislike {
    private TabLayout tabLayout;
    private int[] tabIcons= {
            R.drawable.ic_page,
            R.drawable.ic_tab_liked
    };
    FragmentPage fragmentPage;
    FragmentLiked fragmentLiked;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ViewPager viewPager = findViewById(R.id.view_pager);
        List<Fragment> fragments = new ArrayList<>();

        fragmentPage = new FragmentPage();
        fragmentLiked = new FragmentLiked();
        fragments.add(fragmentPage);
        fragments.add(fragmentLiked);
        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(),0,fragments));

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    public void setupTabIcons(){
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(tabIcons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(tabIcons[1]);
    }
    @Override
    public void onPostLike() {
        fragmentLiked.updateLike();
        //fragmentPage.updateLike();
    }
    @Override
    public void onPostDisLike() {
        fragmentLiked.updateLike();
        fragmentPage.updateLike();
    }
}
