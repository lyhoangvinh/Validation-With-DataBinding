package com.lyhoangvinh.validationwithdatabinding.ui.feature

import com.lyhoangvinh.validationwithdatabinding.ui.base.activity.BaseSingleFragmentActivity
import com.lyhoangvinh.validationwithdatabinding.ui.feature.login.LoginFragment

class MainActivity : BaseSingleFragmentActivity<LoginFragment>() {
    override fun createFragment() = LoginFragment()
}
