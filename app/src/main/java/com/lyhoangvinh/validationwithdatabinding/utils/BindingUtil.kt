package com.lyhoangvinh.validationwithdatabinding.utils

import android.text.TextUtils
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter

object BindingUtil {

    @JvmStatic
    @BindingAdapter("error")
    fun setError(editText: EditText, str: String?) {
        if (!TextUtils.isEmpty(str)) {
            editText.error = str.toString()
        }
    }

    @JvmStatic
    @BindingAdapter("onFocus")
    fun bindFocusChange(editText: EditText, onFocusChangeListener: View.OnFocusChangeListener) {
        if (editText.onFocusChangeListener == null) {
            editText.onFocusChangeListener = onFocusChangeListener
        }
    }
}