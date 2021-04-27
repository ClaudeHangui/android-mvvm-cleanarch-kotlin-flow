package com.changui.android_mvvm_cleanarch_kotlin_flow.domain

import arrow.core.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.QuestionDomainModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.repository.GetQuestionRepository
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.result.Result
import kotlinx.coroutines.flow.Flow

interface GetQuestionListUseCase {
    suspend fun execute(): GetQuestionListResult
}

class GetQuestionListUseCaseImpl(private val repository: GetQuestionRepository) : GetQuestionListUseCase {
    override suspend fun execute(): GetQuestionListResult {
        return repository.getQuestions().toResult()
    }
}


sealed class GetQuestionListResult : Result {
    object VerifyPhoneNumberProgress : GetQuestionListResult()
    data class VerifyPhoneNumberSuccess(val questionListData: Flow<List<QuestionDomainModel>>) : GetQuestionListResult()
    data class VerifyPhoneNumberError(val error: Failure) : GetQuestionListResult()
}

private fun Either<Failure, Flow<List<QuestionDomainModel>>>.toResult(): GetQuestionListResult =
    when (this) {
        is Either.Left -> GetQuestionListResult.VerifyPhoneNumberError(this.value)
        is Either.Right -> GetQuestionListResult.VerifyPhoneNumberSuccess(this.value)
    }