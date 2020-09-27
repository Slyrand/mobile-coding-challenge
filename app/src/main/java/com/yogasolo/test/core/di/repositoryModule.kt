package com.yogasolo.test.core.di

import com.yogasolo.data.postures.PostureRepository
import com.yogasolo.domain.postures.IPostureRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single {
        PostureRepository(
            networkDataSource = get(),
        ) as IPostureRepository
    }
}