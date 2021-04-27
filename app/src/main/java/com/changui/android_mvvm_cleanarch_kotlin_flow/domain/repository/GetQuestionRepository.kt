package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.repository

import arrow.core.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.QuestionDomainModel
import kotlinx.coroutines.flow.Flow

interface GetQuestionRepository {
    suspend fun getQuestions(): Either<Failure, Flow<List<QuestionDomainModel>>>
    suspend fun getQuestion(): Either<Failure, Flow<QuestionDomainModel>>
}