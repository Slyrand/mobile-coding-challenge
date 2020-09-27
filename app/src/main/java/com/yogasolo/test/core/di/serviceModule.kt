package com.yogasolo.test.core.di

import com.yogasolo.test.core.coroutines.Executor
import org.koin.core.module.Module
import org.koin.dsl.module

val serviceModule: Module = module {
    single { Executor() }
}