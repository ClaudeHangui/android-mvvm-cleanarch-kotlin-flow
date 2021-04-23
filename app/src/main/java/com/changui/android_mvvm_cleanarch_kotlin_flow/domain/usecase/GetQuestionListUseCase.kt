package com.changui.android_mvvm_cleanarch_kotlin_flow.domain

import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.functional.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.QuestionDomainModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.repository.GetQuestionRepository
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.result.Result

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
    data class VerifyPhoneNumberSuccess(val questionListData: List<QuestionDomainModel>) : GetQuestionListResult()
    data class VerifyPhoneNumberError(val error: Failure) : GetQuestionListResult()
}

private fun Either<Failure, List<QuestionDomainModel>>.toResult(): GetQuestionListResult =
    when (this) {
        is Either.Left -> GetQuestionListResult.VerifyPhoneNumberError(this.failure)
        is Either.Right -> GetQuestionListResult.VerifyPhoneNumberSuccess(this.success)
    }