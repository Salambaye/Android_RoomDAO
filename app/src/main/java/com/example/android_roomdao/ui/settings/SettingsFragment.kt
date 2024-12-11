package com.example.android_roomdao.ui.settings

import androidx.preference.PreferenceFragmentCompat
import android.os.Bundle
class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}