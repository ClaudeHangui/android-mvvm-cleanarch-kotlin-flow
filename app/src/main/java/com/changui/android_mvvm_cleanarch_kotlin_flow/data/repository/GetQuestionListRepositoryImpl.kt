package com.changui.android_mvvm_cleanarch_kotlin_flow.data.repository

import arrow.core.Either
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.LocalDataSource
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.RemoteDataSource
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.mapper.DataToDomainMapper
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.scope.CoroutineScopes
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.QuestionDomainModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.repository.GetQuestionRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class GetQuestionListRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: DataToDomainMapper,
    private val coroutineScopes: CoroutineScopes
) : GetQuestionRepository {
    override suspend fun getQuestions(): Either<Failure, Flow<List<QuestionDomainModel>>> {
        coroutineScopes.io.launch {
            remoteDataSource.fetchQuestions().map {
                localDataSource.deleteAllQuestion()
                localDataSource.saveQuestions(it.items)
            }
        }

        val concatMapper = flow {
            emitAll(localDataSource.readQuestions().map { allDataModel ->
                mapper.map(allDataModel)
            })
        }
        return Either.Right(concatMapper.distinctUntilChanged())
    }

    override suspend fun getQuestion(): Either<Failure, Flow<QuestionDomainModel>> {
        TODO("Not yet implemented")
    }

    fun <T> combineConcat(vararg flows: Flow<T>) = flow {
        flows.forEach {
            it.collect {
                emit(it)
            }
        }
    }
}