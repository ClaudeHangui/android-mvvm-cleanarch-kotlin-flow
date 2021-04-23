package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.repository

import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.functional.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.QuestionDomainModel

interface GetQuestionRepository {
    suspend fun getQuestions(): Either<Failure, List<QuestionDomainModel>>
    suspend fun getQuestion(): Either<Failure, QuestionDomainModel>
}