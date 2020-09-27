package com.yogasolo.test.core

import com.yogasolo.test.core.coroutines.Executor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

interface BasePresenter<in T : BasePresenter.View> {

    val coroutineScope: CoroutineScope
    val executor: Executor

    interface View {
        fun setUpUI()
    }

    fun attachView(view: T)

    fun <T> CoroutineScope.launchUI(
        fn: suspend CoroutineScope.() -> T
    ) = launch(executor.uiContext) { fn() }

    suspend fun <T> CoroutineScope.await(
        dispatcher: CoroutineContext = executor.asyncContext,
        fn: suspend CoroutineScope.() -> T
    ) = withContext(dispatcher) { fn() }
}