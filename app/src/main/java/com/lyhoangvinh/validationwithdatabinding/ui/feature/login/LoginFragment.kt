package com.lyhoangvinh.validationwithdatabinding.ui.feature.login

import android.content.Context
import android.view.View
import com.lyhoangvinh.validationwithdatabinding.R
import com.lyhoangvinh.validationwithdatabinding.databinding.FragmentLoginBinding
import com.lyhoangvinh.validationwithdatabinding.ui.base.fragment.BaseViewModelFragment

class LoginFragment : BaseViewModelFragment<FragmentLoginBinding, LoginViewModel>() {
    override fun getLayoutResource() = R.layout.fragment_login
    override fun createViewModelClass() = LoginViewModel::class.java
    override fun initialize(view: View, ctx: Context?) {
        binding.vm = viewModel
    }
}