package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.model

data class UserDomainModel(
    val accept_rate: Int,
    val display_name: String,
    val link: String,
    val profile_image: String,
    val reputation: Int,
    val user_id: Int,
    val user_type: String
)
