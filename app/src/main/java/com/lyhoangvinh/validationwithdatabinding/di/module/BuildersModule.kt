package com.lyhoangvinh.validationwithdatabinding.di.module

import com.lyhoangvinh.validationwithdatabinding.ui.feature.MainActivity
import com.lyhoangvinh.validationwithdatabinding.ui.feature.MainModule
import com.lyhoangvinh.validationwithdatabinding.ui.feature.login.LoginFragment
import com.lyhoangvinh.validationwithdatabinding.ui.feature.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun loginFragment(): LoginFragment

}