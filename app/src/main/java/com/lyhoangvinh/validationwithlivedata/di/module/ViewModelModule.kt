package com.lyhoangvinh.validationwithlivedata.di.module

import androidx.lifecycle.ViewModelProvider
import com.lyhoangvinh.validationwithlivedata.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


}