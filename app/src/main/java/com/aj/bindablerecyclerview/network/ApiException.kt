package com.aj.bindablerecyclerview.network

import java.io.IOException

sealed class ApiException(open val code: Int, val error: String) : IOException() {
    class NoConnectivityException(
        override val code: Int = 409,
        override val message: String = "Seems there is no internet connection. \nPlease try again after sometime"
    ) : ApiException(code, message)

    class BadRequest(
        override val code: Int = 400,
        override val message: String = "Error 400 - Bad request."
    ) : ApiException(code, message)

    class UnauthorizedRequest(
        override val code: Int = 401,
        override val message: String = "Error 401 - Unauthorized request."
    ) : ApiException(code, message)

    class Forbidden(
        override val code: Int = 403,
        override val message: String = "Error 403 - Forbidden."
    ) : ApiException(code, message)

    class ResourceNotFound(
        override val code: Int = 404,
        override val message: String = "Error 404 - Not Found."
    ) : ApiException(code, message)

    class MethodNotAllowed(
        override val code: Int = 405,
        override val message: String = "Error 405 - Method not allowed."
    ) : ApiException(code, message)

    class NotAcceptable(
        override val code: Int = 406,
        override val message: String = "Error 406 - Not Acceptable."
    ) : ApiException(code, message)

    class RequestTimeout(
        override val code: Int = 408,
        override val message: String = "Error 408 - Request timeout."
    ) : ApiException(code, message)

    class ServerError(
        override val code: Int = 500,
        override val message: String = "Error 500 - Server error."
    ) : ApiException(code, message)
}