package com.mctable.nowandnextchallenge.dashboard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mctable.nowandnextchallenge.R
import com.mctable.nowandnextchallenge.commons.views.ErrorBottomSheet
import com.mctable.nowandnextchallenge.commons.views.ErrorBottomSheetModel
import com.mctable.nowandnextchallenge.dashboard.ui.fragment.DashboardFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showErrorBottomSheet(buttonClick: () -> Unit) {
        ErrorBottomSheet(
            ErrorBottomSheetModel(
                title = getString(R.string.dashboard_error_bottom_sheet_title),
                description = getString(R.string.dashboard_error_bottom_sheet_description),
                buttonClick = { buttonClick.invoke() },
                buttonText = getString(R.string.dashboard_error_bottom_sheet_button_text)
            )
        ).show(supportFragmentManager, null)
    }
}