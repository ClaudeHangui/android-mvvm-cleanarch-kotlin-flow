package com.changui.android_mvvm_cleanarch_kotlin_flow.domain.result

import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure

interface Result {
    open class Error(val error: Failure) : Result
    open class Success<T>(val data: T) : Result
    interface Loading
}