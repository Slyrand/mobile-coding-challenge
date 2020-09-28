package com.yogasolo.test.postures.detail

import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.core.BasePresenter
import com.yogasolo.test.core.coroutines.Executor
import kotlinx.coroutines.CoroutineScope

class PostureDetailPresenter(
    private val posture: Posture?,
    override val coroutineScope: CoroutineScope,
    override val executor: Executor
) : BasePresenter<PostureDetailPresenter.View>, CoroutineScope by coroutineScope {

    interface View : BasePresenter.View {
        fun showPostureInfo(posture: Posture)
    }

    private lateinit var _view: View

    override fun attachView(view: View) {
        _view = view
        _view.setUpUI()

        posture?.let {
            _view.showPostureInfo(it)
        }
    }
}