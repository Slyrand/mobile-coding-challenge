package com.yogasolo.test.postures.list

import com.yogasolo.test.core.BasePresenter
import com.yogasolo.test.core.coroutines.Executor
import kotlinx.coroutines.CoroutineScope

class PosturesListPresenter(
    override val coroutineScope: CoroutineScope,
    override val executor: Executor
) : BasePresenter<PosturesListPresenter.View>, CoroutineScope by coroutineScope {

    interface View : BasePresenter.View {

    }

    private lateinit var _view: View

    override fun attachView(view: View) {
        _view = view
    }
}