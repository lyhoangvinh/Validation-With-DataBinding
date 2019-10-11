package com.lyhoangvinh.validationwithdatabinding.ui.feature.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.lyhoangvinh.validationwithdatabinding.ui.base.viewmodel.BaseViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(val login: LoginForm) : BaseViewModel() {
    var onFocusEmail: View.OnFocusChangeListener? = null
    var onFocusPassword: View.OnFocusChangeListener? = null

    override fun onFirstTimeUiCreate(lifecycleOwner: LifecycleOwner, bundle: Bundle?) {
        onFocusEmail = View.OnFocusChangeListener { view, focused ->
            val et = view as EditText
            if (et.text.isNotEmpty() && !focused) {
                login.isEmailValid(true)
            }
        }

        onFocusPassword = View.OnFocusChangeListener { view, focused ->
            val et = view as EditText
            if (et.text.isNotEmpty() && !focused) {
                login.isPasswordValid(true)
            }
        }
        login.buttonClick.observe(lifecycleOwner, Observer {
            //todo: call api login
            Log.d("BUTTON_CLICK_XXX", "${it.email}, ${it.password}")
        })
    }
}