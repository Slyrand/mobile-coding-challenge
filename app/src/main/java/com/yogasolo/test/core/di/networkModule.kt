package com.yogasolo.test.core.di

import com.yogasolo.data.core.ApiClient
import com.yogasolo.data.postures.network.PostureService
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { ApiClient.createService(PostureService::class.java) }
}