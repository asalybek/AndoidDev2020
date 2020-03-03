package com.example.firstprojectjob;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.firstprojectjob.model.Knp;
import com.example.firstprojectjob.model.KnpResponse;
import com.example.firstprojectjob.rest.ApiClient;
import com.example.firstprojectjob.rest.ApiInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    FragmentManager fm;
    private final static String API_KEY = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     ApiInterface apiService =
               ApiClient.getClient().create(ApiInterface.class);
     apiService.getKnpList().enqueue(new Callback<Knp[]>() {
         @Override
         public void onResponse(Call<Knp[]> call, Response<Knp[]> response) {
            int size  = response.body().length;
            //.body().getKnpListSize();
             Log.e(TAG,"Size"+size);
         }

         @Override
         public void onFailure(Call<Knp[]> call, Throwable t) {
             Log.e("REST","Hi OnFailure", t);
         }
     });
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
