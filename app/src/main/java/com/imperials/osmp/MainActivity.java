package com.imperials.osmp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        // Writing data to SharedPreferences
        Bundle b = getIntent().getExtras();

        String framesize = b.getString("keyframesize");
        String pagesize = b.getString("keypagesize");
        String pages = b.getString("keypages");


        SharedPreferences settings = getSharedPreferences("OSMP_Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("key1", framesize);
        editor.putString("key2", pagesize);
        editor.putString("key3", pages);
        editor.commit();

//Instead of "some value" tera string daal in first fragment



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);






    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

      //  Bundle bundle =getIntent().getExtras();

     //   String fname = bundle.getString("keyname");
       // String fnumber = bundle.getString("keynumber");

        @Override
        public Fragment getItem(int position) {

         //   Bundle bundle = new Bundle();
           // bundle.putString("edttext1",fname);
           // bundle.putString("edttext2",fnumber);
            switch (position) {
                case 0:
                    FIFO fifo =new FIFO();
                 //   fifo.setArguments(bundle);
                    return fifo;
                case 1:
                    LRU lru = new LRU();
                    return lru;
                case 2:
                    LFU lfu = new LFU();
                    return lfu;
                case 3:
                    Optimal optimal = new Optimal();
                    return optimal;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "FIFO";

                case 1:
                    return "LRU";


                case 2:
                    return "LFU";

                case 3:
                    return "Optimal";

            }
            return null;
        }
    }
}
