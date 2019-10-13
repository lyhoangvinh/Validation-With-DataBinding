package com.lyhoangvinh.validationwithdatabinding.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lyhoangvinh.validationwithdatabinding.di.qualifier.ApplicationContext
import com.lyhoangvinh.validationwithdatabinding.MyApplication
import com.lyhoangvinh.validationwithdatabinding.ui.feature.login.LoginForm
import com.lyhoangvinh.validationwithdatabinding.utils.DateDeserializer
import dagger.Module
import dagger.Provides
import lyhoangvinh.com.myutil.thread.BackgroundThreadExecutor
import lyhoangvinh.com.myutil.thread.UIThreadExecutor
import java.lang.reflect.Modifier
import java.util.*
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(application: MyApplication) = application

    @Provides
    @Singleton
    fun provideGSon(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
        .disableHtmlEscaping()
        .setPrettyPrinting()
        .registerTypeAdapter(Date::class.java, DateDeserializer())
        .create()

    @Provides
    @Singleton
    fun provideBackgroundThreadExecutor(): BackgroundThreadExecutor =
        BackgroundThreadExecutor.getInstance()

    @Provides
    @Singleton
    fun provideUIThreadExecutor(): UIThreadExecutor = UIThreadExecutor.getInstance()

}