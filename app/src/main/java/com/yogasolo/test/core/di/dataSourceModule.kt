package com.yogasolo.test.core.di

import com.yogasolo.data.postures.network.PostureNetworkDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

val dataSourceModule: Module = module {
    single {
        PostureNetworkDataSource(
            service = get(),
        )
    }
}