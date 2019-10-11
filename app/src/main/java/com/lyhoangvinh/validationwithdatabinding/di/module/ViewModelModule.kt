package com.lyhoangvinh.validationwithdatabinding.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lyhoangvinh.validationwithdatabinding.di.ViewModelFactory
import com.lyhoangvinh.validationwithdatabinding.di.qualifier.ViewModelKey
import com.lyhoangvinh.validationwithdatabinding.ui.feature.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun homeViewModel(viewModel: LoginViewModel): ViewModel
}