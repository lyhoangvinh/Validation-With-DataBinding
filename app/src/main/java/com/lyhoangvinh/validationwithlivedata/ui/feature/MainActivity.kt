package com.lyhoangvinh.validationwithlivedata.ui.feature

import com.lyhoangvinh.validationwithlivedata.ui.base.activity.BaseSingleFragmentActivity
import com.lyhoangvinh.validationwithlivedata.ui.feature.login.LoginFragment

class MainActivity : BaseSingleFragmentActivity<LoginFragment>() {
    override fun createFragment() = LoginFragment()
}
