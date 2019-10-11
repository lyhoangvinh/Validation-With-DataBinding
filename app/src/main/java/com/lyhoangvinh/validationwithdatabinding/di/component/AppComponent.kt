package com.lyhoangvinh.validationwithdatabinding.di.component

import com.lyhoangvinh.validationwithdatabinding.MyApplication
import com.lyhoangvinh.validationwithdatabinding.di.module.AppModule
import com.lyhoangvinh.validationwithdatabinding.di.module.BuildersModule
import com.lyhoangvinh.validationwithdatabinding.di.module.DataModule
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.lyhoangvinh.validationwithdatabinding.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lyhoangvinh on 05/01/18.
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        DataModule::class,
        BuildersModule::class]
)
interface AppComponent : AndroidInjector<MyApplication> {
    @Suppress("DEPRECATION")
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}
