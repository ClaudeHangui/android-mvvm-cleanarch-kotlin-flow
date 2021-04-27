package com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence

import com.changui.android_mvvm_cleanarch_kotlin_flow.data.LocalDataSource
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.model.QuestionDataModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(private val dao: QuestionDao): LocalDataSource {
    override suspend fun saveQuestions(data: List<QuestionDataModel>) {
        data.forEach { dao.insertList(it) }
    }

    override suspend fun readQuestions() =
         flow {
             emitAll(dao.findAllQuestions().distinctUntilChanged())
        }


    override suspend fun deleteAllQuestion() {
        dao.deleteAll()
    }
}