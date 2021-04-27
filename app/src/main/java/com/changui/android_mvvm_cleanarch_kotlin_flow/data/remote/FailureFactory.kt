package com.changui.android_mvvm_cleanarch_kotlin_flow.data.remote

import com.changui.android_mvvm_cleanarch_kotlin_flow.domain.error.Failure
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException

interface BaseFailureFactory {
    fun produce(exception: Exception): Failure
}

const val HTTP_INTERNAL_SERVER_ERROR = 500

class FailureFactory : BaseFailureFactory {

    override fun produce(exception: Exception): Failure {
        return when (exception) {
            is SocketTimeoutException -> Failure.ServerTimeoutError
            is HttpException -> {
                val response = exception.response()
                return handleHttpCode(response)
            }
            else -> Failure.UnknownError
        }
    }


    private fun <T> handleHttpCode(response: Response<T>?): Failure {
        return when (response?.code()) {
            HTTP_INTERNAL_SERVER_ERROR -> Failure.ServerError
            else -> Failure.UnknownError
        }
    }
}