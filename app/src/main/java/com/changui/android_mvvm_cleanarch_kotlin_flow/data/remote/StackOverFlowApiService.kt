package com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface StackOverFlowApiService {
    @GET("search")
    suspend fun getAndroidQuestions(@QueryMap(encoded=true) options: LinkedHashMap<String, String> ): QuestionListApiResponse
}