package com.example.firstprojectjob;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    FragmentManager fm;
    MenuItem prevMenuItem;
    ViewPager viewPager;

    FragmentPage mFragmentPage;
    FragmentLiked mFragmentLiked;
    FragmentFree mFragmentFree;
    //PostsContainer postsContainer = PostsContainer.PostsContainer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //postsContainer.createPosts();
        PostsContainer postsContainer = PostsContainer.get(MainActivity.this);
       fm = getSupportFragmentManager();
       fragment = fm.findFragmentById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_list:
                            fragment = new FragmentPage();
                            fm.beginTransaction()
                                    .replace(R.id.fragment_container, fragment)
                                    .commit();

                        break;
                    case R.id.action_favorite:
                            fragment = new FragmentLiked();
                            fm.beginTransaction()
                                    .replace(R.id.fragment_container, fragment)
                                    .commit();

                        break;
                    case R.id.action_edit:
                            fragment = new FragmentFree();
                            fm.beginTransaction()
                                    .replace(R.id.fragment_container, fragment)
                                    .commit();

                        break;
                }
                return false;
            }
        });
    }
}
