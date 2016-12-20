package com.example.boss.xmlpreferences;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSettingsFragment(savedInstanceState);
    }

    private void createSettingsFragment(Bundle savedInstanceState) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if(savedInstanceState == null){
            Fragment prefFragment = new PrefFragment();
            ft.add(R.id.activity_main,prefFragment,"PrefFragment");
            ft.commit();
        }
    }
}
