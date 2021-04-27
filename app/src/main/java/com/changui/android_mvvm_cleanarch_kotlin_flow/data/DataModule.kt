package com.changui.android_mvvm_cleanarch_kotlin_flow.data

import com.changui.android_mvvm_cleanarch_kotlin_flow.data.mapper.DataToDomainMapper
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence.AppDataBase
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence.LocalDataSourceImpl
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote.RemoteDataSourceImpl
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.repository.GetQuestionListRepositoryImpl
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.repository.GetQuestionRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule : Module = module {
    single { AppDataBase.getInstance(androidApplication()) }
    single { get<AppDataBase>().getQuestionsDao() }
    factory { DataToDomainMapper() }
    factory <LocalDataSource>{ LocalDataSourceImpl(get())}
    factory <RemoteDataSource>{ RemoteDataSourceImpl(get(), get())}
    factory <GetQuestionRepository>{ GetQuestionListRepositoryImpl(get(), get(), get(), get()) }
}