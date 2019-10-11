package com.lyhoangvinh.validationwithlivedata.ui.feature.login

import android.content.Context
import android.view.View
import com.lyhoangvinh.validationwithlivedata.R
import com.lyhoangvinh.validationwithlivedata.databinding.FragmentLoginBinding
import com.lyhoangvinh.validationwithlivedata.ui.base.fragment.BaseViewModelFragment

class LoginFragment : BaseViewModelFragment<FragmentLoginBinding, LoginViewModel>() {
    override fun getLayoutResource() = R.layout.fragment_login
    override fun createViewModelClass() = LoginViewModel::class.java
    override fun initialize(view: View, ctx: Context?) {

    }
}