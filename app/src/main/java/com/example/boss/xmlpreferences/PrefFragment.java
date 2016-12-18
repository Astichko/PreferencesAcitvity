package com.example.boss.xmlpreferences;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by BOSS on 17.12.2016.
 */

public class PrefFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_screen);

        ListPreference prefList = (ListPreference) findPreference("list");
        prefList.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                preference.setSummary(o.toString());
                return false;
            }
        });
        EditTextPreference prefEditText = (EditTextPreference) findPreference("edit_text");
        prefEditText.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                preference.setSummary(o.toString());
                return false;
            }
        });
    }
}
