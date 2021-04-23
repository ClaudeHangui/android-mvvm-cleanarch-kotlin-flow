package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object UnknownError : Failure()
    object ServerTimeoutError : Failure()
}
