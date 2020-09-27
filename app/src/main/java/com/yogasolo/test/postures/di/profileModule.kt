package com.yogasolo.test.postures.di

import com.yogasolo.test.postures.list.PosturesListActivity
import com.yogasolo.test.postures.list.PosturesListPresenter
import kotlinx.coroutines.CoroutineScope
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val posturesModule: Module = module {
    scope(named<PosturesListActivity>()) {
        scoped { (scope: CoroutineScope) ->
            PosturesListPresenter(
                posturesRepository = get(),
                executor = get(),
                coroutineScope = scope
            )
        }
    }
}