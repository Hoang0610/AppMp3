package com.example.hoangmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.hoangmp3.Adapter.MainViewPagerAdapter;
import com.example.hoangmp3.Fragment.Fragment_TimKiem;
import com.example.hoangmp3.Fragment.Fragment_TrangChu;
import com.example.hoangmp3.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_TrangChu(),"Home");
        mainViewPagerAdapter.addFragment(new Fragment_TimKiem(),"Search" );
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0 ).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.search);
    }

    private void anhXa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }
}