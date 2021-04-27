package com.changui.android_mvvm_cleanarch_kotlin_flow.data

import arrow.core.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.model.QuestionDataModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote.QuestionListApiResponse
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {
    suspend fun saveQuestions(data: List<QuestionDataModel>)
    suspend fun readQuestions(): Flow<List<QuestionDataModel>>
    suspend fun deleteAllQuestion()
}

interface RemoteDataSource {
    suspend fun fetchQuestions(): Either<Failure, QuestionListApiResponse>
}