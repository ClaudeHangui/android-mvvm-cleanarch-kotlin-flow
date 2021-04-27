package com.changui.android_mvvm_cleanarch_kotlin_flow.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.UserDataModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.UserParceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.TypeParceler

@Entity(tableName = "Question")
@Parcelize
data class QuestionDataModel(
    val accepted_answer_id: Int,
    val answer_count: Int,
    val closed_date: Int,
    val closed_reason: String,
    val content_license: String,
    val creation_date: Int,
    val is_answered: Boolean,
    val last_activity_date: Int,
    val last_edit_date: Int,
    val link: String,
    @Embedded(prefix = "question_")
    @TypeParceler<UserDataModel, UserParceler>
    val owner: UserDataModel,
    @PrimaryKey
    val question_id: Int,
    val score: Int,
    val tags: List<String>,
    val title: String,
    val view_count: Int
): Parcelable
