package com.yogasolo.test.postures.list

import android.os.Bundle
import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.R
import com.yogasolo.test.core.coroutines.ScopedActivity
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf

class PosturesListActivity : ScopedActivity(), PosturesListPresenter.View {

    private val _presenter: PosturesListPresenter by currentScope.inject {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postures_list)

        _presenter.attachView(this)
    }

    override fun setUpUI() {

    }

    override fun addPostures(postures: List<Posture>) {

    }
}