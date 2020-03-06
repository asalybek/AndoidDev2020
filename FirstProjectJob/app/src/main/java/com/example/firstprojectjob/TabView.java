package com.example.firstprojectjob;

import com.example.firstprojectjob.activities.SecondMainActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class TabView {
    private SecondMainActivity mSecondMainActivity = new SecondMainActivity(this);
    private TabLayout tabLayout;
    private int[] tabIcons= {
            R.drawable.ic_page,
            R.drawable.ic_tab_liked
    };
    public void setupTabIcons(){
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(tabIcons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(tabIcons[1]);
    }
    public TabLayout getTabLayout(){
        tabLayout = mSecondMainActivity.findViewById(R.id.tabLayout);
        return tabLayout;
    }

}
