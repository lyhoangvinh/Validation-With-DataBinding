package com.lyhoangvinh.validationwithdatabinding.ui.feature.login

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.lyhoangvinh.validationwithdatabinding.BR
import com.lyhoangvinh.validationwithdatabinding.data.entities.LoginFields
import javax.inject.Inject

class LoginForm @Inject constructor() : BaseObservable() {

    private val fields = LoginFields()

    private val errors = LoginFields()

    var buttonClick = MutableLiveData<LoginFields>()
        private set

    @Bindable
    fun isValid(): Boolean {
        var valid = isEmailValid(false)
        valid = isPasswordValid(false) && valid
        notifyPropertyChanged(BR.emailError)
        notifyPropertyChanged(BR.passwordError)
        return valid
    }

    fun isEmailValid(setMessage: Boolean): Boolean {
        val email = fields.email
        if (email != null && email.length > 5) {
            val indexOfAt = email.indexOf("@")
            val indexOfDot = email.lastIndexOf(".")
            return if (indexOfAt in 1 until indexOfDot && indexOfDot < email.length - 1) {
                errors.email = null
                notifyPropertyChanged(BR.valid)
                true
            } else {
                if (setMessage) {
                    errors.email = "Error Email"
                    notifyPropertyChanged(BR.valid)
                }
                false
            }
        }
        if (setMessage) {
            errors.email = "error_too_short"
            notifyPropertyChanged(BR.valid)
        }

        return false
    }

    fun isPasswordValid(setMessage: Boolean): Boolean {
        val password = fields.password
        return if (password != null && password.length > 5) {
            errors.password = null
            notifyPropertyChanged(BR.valid)
            true
        } else {
            if (setMessage) {
                errors.password = "error_too_short"
                notifyPropertyChanged(BR.valid)
            }

            false
        }
    }

    fun onClick() {
        if (isValid()) {
            buttonClick.value = fields
        }
    }

    fun getFields(): LoginFields {
        return fields
    }

    @Bindable
    fun getEmailError(): String? {
        return errors.email
    }

    @Bindable
    fun getPasswordError(): String? {
        return errors.password
    }
}