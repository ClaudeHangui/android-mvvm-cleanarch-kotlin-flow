package com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.model.QuestionDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Query("SELECT * FROM Question")
    fun findAllQuestions(): Flow<List<QuestionDataModel>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(posts: QuestionDataModel)

    @Query("DELETE FROM Question")
    fun deleteAll()
}