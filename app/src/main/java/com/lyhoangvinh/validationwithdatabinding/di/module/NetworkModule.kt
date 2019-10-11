package com.lyhoangvinh.validationwithdatabinding.di.module


import com.lyhoangvinh.validationwithdatabinding.MyApplication
import com.lyhoangvinh.validationwithdatabinding.utils.ConnectionLiveData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun providesConnectionLiveData(context: MyApplication): ConnectionLiveData = ConnectionLiveData(context)


}
