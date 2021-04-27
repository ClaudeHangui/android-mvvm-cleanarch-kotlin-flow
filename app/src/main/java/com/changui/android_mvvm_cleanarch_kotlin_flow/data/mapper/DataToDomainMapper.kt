package com.changui.android_mvvm_cleanarch_kotlin_flow.data.mapper

import com.changui.android_mvvm_cleanarch_kotlin_flow.data.model.QuestionDataModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.Mapper
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.QuestionDomainModel
import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model.UserDomainModel

class DataToDomainMapper: Mapper<List<QuestionDataModel>, List<QuestionDomainModel>> {
    override fun map(input: List<QuestionDataModel>): List<QuestionDomainModel> {
        return input.map {
            QuestionDomainModel(
                it.accepted_answer_id,
                it.answer_count,
                it.closed_date,
                it.closed_reason,
                it.content_license,
                it.creation_date,
                it.is_answered,
                it.last_activity_date,
                it.last_edit_date,
                it.link,
                UserDomainModel(it.owner.accept_rate, it.owner.display_name,
                    it.owner.link, it.owner.profile_image, it.owner.reputation,
                    it.owner.user_id, it.owner.user_type),
                it.question_id,
                it.score,
                it.tags,
                it.title,
                it.view_count
            )
        }
    }
}

