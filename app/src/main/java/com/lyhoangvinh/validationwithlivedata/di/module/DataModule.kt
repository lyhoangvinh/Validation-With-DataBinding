package com.lyhoangvinh.validationwithlivedata.di.module


import com.lyhoangvinh.validationwithlivedata.MyApplication
import com.lyhoangvinh.validationwithlivedata.data.SharedPrefs
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {


    @Singleton
    @Provides
    internal fun providesSharedPrefs(context: MyApplication): SharedPrefs = SharedPrefs.getInstance(context)


}