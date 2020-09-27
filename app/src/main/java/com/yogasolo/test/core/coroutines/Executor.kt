package com.yogasolo.test.core.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

data class Executor(
    val asyncContext: CoroutineContext = Dispatchers.IO,
    val uiContext: CoroutineContext = Dispatchers.Main
)