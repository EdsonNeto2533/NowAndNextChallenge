package com.mctable.nowandnextchallenge.dashboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctable.nowandnextchallenge.R
import com.mctable.nowandnextchallenge.dashboard.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}