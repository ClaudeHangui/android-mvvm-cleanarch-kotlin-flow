package com.changui.android_mvvm_cleanarch_kotlin_flow

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.dataModule
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote.remoteDataSourceModule
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.domainModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@ExperimentalCoroutinesApi
@FlowPreview
class StackOverFlowApplication : MultiDexApplication() {
    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@StackOverFlowApplication)
            modules(listOf(remoteDataSourceModule, dataModule, domainModule))
        }
    }
}