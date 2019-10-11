package com.lyhoangvinh.validationwithdatabinding.di.module


import com.lyhoangvinh.validationwithdatabinding.MyApplication
import com.lyhoangvinh.validationwithdatabinding.data.SharedPrefs
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {


    @Singleton
    @Provides
    internal fun providesSharedPrefs(context: MyApplication): SharedPrefs = SharedPrefs.getInstance(context)


}