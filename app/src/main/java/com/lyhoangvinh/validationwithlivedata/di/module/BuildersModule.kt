package com.lyhoangvinh.validationwithlivedata.di.module

import com.lyhoangvinh.validationwithlivedata.ui.feature.MainActivity
import com.lyhoangvinh.validationwithlivedata.ui.feature.MainModule
import com.lyhoangvinh.validationwithlivedata.ui.feature.login.LoginFragment
import com.lyhoangvinh.validationwithlivedata.ui.feature.login.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun loginFragment(): LoginFragment

}