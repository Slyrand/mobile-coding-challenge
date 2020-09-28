package com.yogasolo.test.postures.di

import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.postures.detail.PostureDetailActivity
import com.yogasolo.test.postures.detail.PostureDetailPresenter
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

    scope(named<PostureDetailActivity>()) {
        scoped { (scope: CoroutineScope, posture: Posture?) ->
            PostureDetailPresenter(
                posture = posture,
                executor = get(),
                coroutineScope = scope
            )
        }
    }
}