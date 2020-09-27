package com.yogasolo.data.core

import arrow.core.Either
import arrow.core.Try
import retrofit2.Call

open class NetworkDataSource() {
    protected fun <T> handleCall(method: () -> Call<T>): Either<Exception, T> {
        return Try { method().execute() }.fold(
            { Either.left(Exception("")) },
            { response ->
                if (response.isSuccessful && response.body() != null) {
                    Either.right(response.body()!!)
                } else {
                    Either.left(Exception(response.message()))
                }
            }
        )
    }
}