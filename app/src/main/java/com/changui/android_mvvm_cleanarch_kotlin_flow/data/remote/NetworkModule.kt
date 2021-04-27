package com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote

import com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote.DatasourceProperties.SERVER_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import org.koin.dsl.module

val remoteDataSourceModule : Module = module {
    single { provideLoggingInterceptor() }
    single { provideApiInterceptor() }
    single { createOkHttpClient(get(), get()) }
    single { provideMoshiBuilder() }
    single { createWebService<StackOverFlowApiService>(get(), get(), getProperty(SERVER_URL)) }
    factory { FailureFactory() }
}

fun provideMoshiBuilder(): Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


object DatasourceProperties {
    const val SERVER_URL = "https://api.stackexchange.com/2.2"
    const val TIMEOUT = 60L
}

private fun createOkHttpClient(apiInterceptor: Interceptor, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(DatasourceProperties.TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(DatasourceProperties.TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(apiInterceptor)
        .addInterceptor(loggingInterceptor)
        .retryOnConnectionFailure(true)
        .build()
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

private fun provideApiInterceptor(): Interceptor {
    return Interceptor { chain ->
        var request = chain.request()
        val url = request.url
            .newBuilder()
            .build()
        request = request.newBuilder().url(url).build()
        chain.proceed(request)
    }
}

private inline fun <reified T> createWebService(okHttpClient: OkHttpClient, moshiBuilder: Moshi, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
        .build()
    return retrofit.create(T::class.java)
}