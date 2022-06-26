package com.mctable.nowandnextchallenge.commons.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mctable.nowandnextchallenge.R
import com.mctable.nowandnextchallenge.databinding.BottomSheetErrorBinding

data class ErrorBottomSheetModel(
    val title: String,
    val description: String,
    val buttonText: String,
    val buttonClick: () -> Unit
)

class ErrorBottomSheet(
    private val errorBottomSheetModel: ErrorBottomSheetModel
) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return requireActivity().layoutInflater.inflate(R.layout.bottom_sheet_error, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BottomSheetErrorBinding.bind(view)
        setupFields()
    }

    private fun setupFields() {
        with(errorBottomSheetModel) {
            binding.mbtAction.setOnClickListener {
                buttonClick.invoke()
            }
            binding.tvTitle.text = title
            binding.tvDescription.text = description
            binding.mbtAction.text = buttonText
        }
    }
}