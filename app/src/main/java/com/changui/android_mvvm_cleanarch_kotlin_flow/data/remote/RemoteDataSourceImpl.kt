package com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote

import arrow.core.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.RemoteDataSource
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure

class RemoteDataSourceImpl(private val apiService: StackOverFlowApiService,
                           private val errorFactory: FailureFactory) : RemoteDataSource {
    override suspend fun fetchQuestions(): Either<Failure, QuestionListApiResponse> = try {
        val map: LinkedHashMap<String, String> = linkedMapOf(
            "order" to "desc",
            "sort" to "activity",
            "tagged" to "android",
            "site" to "stackoverflow"
        )
        Either.Right(apiService.getAndroidQuestions(map))
    } catch (e: Exception) {
        Either.Left(errorFactory.produce(e))
    }

}