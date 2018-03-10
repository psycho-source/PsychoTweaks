package com.test.fragments;



import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.test.R;

public class DisplayFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.disp_pref);

    }
}
