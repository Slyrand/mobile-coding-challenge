package com.yogasolo.test.postures.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.R
import com.yogasolo.test.core.coroutines.ScopedActivity
import com.yogasolo.test.postures.detail.PostureDetailActivity
import kotlinx.android.synthetic.main.activity_postures_list.*
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf

class PosturesListActivity : ScopedActivity(), PosturesListPresenter.View {

    private val _presenter: PosturesListPresenter by currentScope.inject { parametersOf(this) }
    private lateinit var _posturesAdapter: PosturesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postures_list)

        _presenter.attachView(this)
    }

    override fun setUpUI() {
        _posturesAdapter = PosturesAdapter(onPostureClick = { posture, view ->
            navigateToPosture(posture, view)
        })
        postures_recycler_view.adapter = _posturesAdapter
        postures_recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun addPostures(postures: List<Posture>) {
        _posturesAdapter.addAll(postures)
    }

    private fun navigateToPosture(posture: Posture, view: View) {
        val intent = Intent(this, PostureDetailActivity::class.java)
        intent.putExtra(PostureDetailActivity.POSTURE_EXTRA, posture)
        val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this, androidx.core.util.Pair(view, PostureDetailActivity.VIEW_DETAIL)
        )

        ActivityCompat.startActivity(this, intent, activityOptions.toBundle())
    }
}