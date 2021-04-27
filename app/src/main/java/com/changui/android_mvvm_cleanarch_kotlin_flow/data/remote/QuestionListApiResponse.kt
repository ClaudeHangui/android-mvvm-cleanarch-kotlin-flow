package com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote

import com.changui.android_mvvm_cleanarch_kotlin_flow.data.model.QuestionDataModel


data class QuestionListApiResponse(
    var has_more: Boolean = false,
    val items: List<QuestionDataModel> = emptyList(),
    val quota_max: Int = -1,
    val quota_remaining: Int = -1
)

