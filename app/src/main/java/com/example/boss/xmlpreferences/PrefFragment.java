package com.example.boss.xmlpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by BOSS on 17.12.2016.
 */

public class PrefFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    final private String EDIT_TEXT = "edit_text";
    final private String COLOR_LIST = "colors_list";
    private EditTextPreference editText;
    private int[] colorArray;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_screen);
        createColorArray();
        findViews();
        setLoginText();
        setColor();
    }

    public void createColorArray() {
        colorArray = new int[4];
        colorArray[0] = R.color.backgroundColor;
        colorArray[1] = R.color.backgroundOrange;
        colorArray[2] = R.color.backgroundGreen;
        colorArray[3] = R.color.backgroundRed;
    }

    public void setColor() {
        int index = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(COLOR_LIST, ""));
        getActivity().getWindow().getDecorView().setBackgroundColor(getResources().getColor(colorArray[index]));
    }

    public void findViews() {
        editText = (EditTextPreference) findPreference(EDIT_TEXT);
    }

    public void setLoginText() {
        String s = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(EDIT_TEXT, "");
        editText.setSummary(s);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences pref, String key) {
        switch (key) {
            case COLOR_LIST:
                setColor();
                break;
            case EDIT_TEXT:
                setLoginText();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}
