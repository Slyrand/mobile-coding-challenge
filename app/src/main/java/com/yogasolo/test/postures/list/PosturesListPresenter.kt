package com.yogasolo.test.postures.list

import android.util.Log
import com.yogasolo.domain.postures.IPostureRepository
import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.core.BasePresenter
import com.yogasolo.test.core.coroutines.Executor
import kotlinx.coroutines.CoroutineScope

class PosturesListPresenter(
    private val posturesRepository: IPostureRepository,
    override val coroutineScope: CoroutineScope,
    override val executor: Executor
) : BasePresenter<PosturesListPresenter.View>, CoroutineScope by coroutineScope {

    interface View : BasePresenter.View {
        fun addPostures(postures: List<Posture>)
        fun showLoading()
        fun hideLoading()
        fun clearPostures()
    }

    private lateinit var _view: View

    override fun attachView(view: View) {
        _view = view
        _view.setUpUI()

        requestPostures()
    }

    fun onReload() {
        requestPostures()
    }

    private fun requestPostures() {
        _view.clearPostures()
        _view.showLoading()
        launchUI {
            await { posturesRepository.getPostures() }.fold(
                {
                    _view.hideLoading()
                    Log.d("PosturesListPresenter", "Error") },
                {
                    _view.hideLoading()
                    _view.addPostures(it)
                }
            )
        }
    }
}