package com.lyhoangvinh.validationwithlivedata.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lyhoangvinh.validationwithlivedata.di.ViewModelFactory
import com.lyhoangvinh.validationwithlivedata.di.qualifier.ViewModelKey
import com.lyhoangvinh.validationwithlivedata.ui.feature.login.LoginViewModel
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