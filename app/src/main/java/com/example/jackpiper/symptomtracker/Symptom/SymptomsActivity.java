package com.example.jackpiper.symptomtracker.Symptom;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.jackpiper.symptomtracker.R;
import com.example.jackpiper.symptomtracker.SymgestantFragment;

public class SymptomsActivity extends AppCompatActivity implements SymgestantFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
