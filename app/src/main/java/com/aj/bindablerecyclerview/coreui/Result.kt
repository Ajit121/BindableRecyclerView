package com.aj.bindablerecyclerview.coreui

enum class Status { Failure, Success }
data class Result<T>(val data: T? = null, val status: Status, val message: String? = null) {
    companion object {
        fun <T> success(data: T): Result<T> = Result(status = Status.Success, data = data)
        fun <T> failure(message: String): Result<T> =
            Result(status = Status.Failure, message = message)
    }
}