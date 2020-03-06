package com.example.firstprojectjob;

import com.google.android.material.tabs.TabLayout;

public class TabDesigner {

    public static void setupTabIcons(TabLayout tabLayout){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_page);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_liked);
    }
}
