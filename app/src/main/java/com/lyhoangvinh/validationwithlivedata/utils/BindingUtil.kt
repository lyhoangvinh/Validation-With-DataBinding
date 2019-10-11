package com.lyhoangvinh.validationwithlivedata.utils

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter

object BindingUtil {

    @JvmStatic
    @BindingAdapter("error")
    fun setError(editText: EditText, str: String?) {
        editText.error = str.toString()
    }

    @JvmStatic
    @BindingAdapter("onFocus")
    fun bindFocusChange(editText: EditText, onFocusChangeListener: View.OnFocusChangeListener) {
        if (editText.onFocusChangeListener == null) {
            editText.onFocusChangeListener = onFocusChangeListener
        }
    }
}