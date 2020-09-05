package com.example.jackpiper.symptomtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.jackpiper.symptomtracker.Symgestant.SymgestantsListActivity;

public class MainActivity extends AppCompatActivity {

    private Fragment homeFragment = new HomeFragment();
    private Fragment calendarFragment = new CalendarFragment();
    private Fragment analysisFragment = new AnalysisFragment();
    private Fragment active = homeFragment;
    private FragmentManager fm = getSupportFragmentManager();
    private int currPosition = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.fragment_container, calendarFragment, "1").hide(calendarFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, analysisFragment, "3").hide(analysisFragment).commit();
        fm.beginTransaction().add(R.id.fragment_container, homeFragment, "2").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(homeFragment, 2);
                    return true;
                case R.id.navigation_calendar:
                    loadFragment(calendarFragment, 1);
                    return true;
                case R.id.navigation_analysis:
                    loadFragment(analysisFragment, 3);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment, int newPosition) {
        //switching fragment
        // cool new animations can be found at C:\Program Files (x86)\Android\android-sdk\platforms\android-19\data\res\anim
        Log.d("thing", "new: "+newPosition+" old: "+currPosition+" active: "+active.toString());
        if (newPosition < currPosition) {
            fm.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).hide(active).show(fragment).commit();
        } else if (newPosition > currPosition) {
            fm.beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left).hide(active).show(fragment).commit();
        }
        currPosition = newPosition;
        active = fragment;
    }

    public void openSymptoms(View view) {
        Intent intent = new Intent(this, SymgestantsListActivity.class);
        startActivity(intent);
    }

}
