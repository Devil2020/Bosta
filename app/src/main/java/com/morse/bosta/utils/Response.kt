package com.morse.bosta.utils

sealed class Response  {
    object Idle : Response()
    object Loading : Response()
    data class Success<ResponseType>(val response: ResponseType) : Response()
    data class Error(val reason: String) : Response()
}
