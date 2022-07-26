package com.morse.bosta.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.morse.bosta.domain.repository.IUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

inline fun <T> execute(
    condition: Boolean,
    crossinline doIfTrue: suspend () -> Unit ,
    crossinline `return` : suspend () -> T
): Flow<T> {
    return flow {
        if (condition) {
            doIfTrue.invoke()
        }
        val cacheResponse = `return`.invoke()
        emit(cacheResponse)
    }
}

inline fun <T> execute(crossinline function: suspend () -> T) = flow<T> {
    val response = function.invoke()
    emit(response)
}
    .flowOn(Dispatchers.IO)


inline fun <Type> AppCompatActivity.collect(
    flow: Flow<Type>,
    crossinline doOnSubscribe: (Type) -> Unit
) {
    lifecycleScope.launch {
        flow
            .flowWithLifecycle(this@collect.lifecycle)
            .collect { action ->
                doOnSubscribe.invoke(action)
            }
    }
}