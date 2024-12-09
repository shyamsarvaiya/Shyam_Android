package com.example.sharedprefrenceex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity

class MainActivity4 : PreferenceActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main4)
        addPreferencesFromResource(R.xml.prefs)
    }
}