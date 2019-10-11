package com.lyhoangvinh.validationwithlivedata.di.module


import com.lyhoangvinh.validationwithlivedata.MyApplication
import com.lyhoangvinh.validationwithlivedata.utils.ConnectionLiveData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun providesConnectionLiveData(context: MyApplication): ConnectionLiveData = ConnectionLiveData(context)


}
