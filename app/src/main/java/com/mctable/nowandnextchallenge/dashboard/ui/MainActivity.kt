package com.mctable.nowandnextchallenge.dashboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctable.nowandnextchallenge.R
import com.mctable.nowandnextchallenge.dashboard.ui.fragment.DashboardFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}