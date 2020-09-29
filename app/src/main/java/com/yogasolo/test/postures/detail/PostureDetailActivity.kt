package com.yogasolo.test.postures.detail

import android.os.Bundle
import androidx.core.view.ViewCompat
import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.R
import com.yogasolo.test.core.coroutines.ScopedActivity
import com.yogasolo.test.core.extensions.loadWithRoundedCorners
import kotlinx.android.synthetic.main.activity_posture_detail.*
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf

class PostureDetailActivity : ScopedActivity(), PostureDetailPresenter.View {

    companion object {
        const val POSTURE_EXTRA = "posture"
        const val VIEW_DETAIL = "view:detail"
    }

    private val _presenter: PostureDetailPresenter by currentScope.inject {
        parametersOf(
            this,
            intent.getSerializableExtra(POSTURE_EXTRA) as Posture?
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posture_detail)
        ViewCompat.setTransitionName(image_view_posture, VIEW_DETAIL)

        _presenter.attachView(this)
    }

    override fun setUpUI() {

    }

    override fun showPostureInfo(posture: Posture) {
        text_view_posture_name.text = posture.name
        text_view_posture_teacher.text = getString(R.string.by_name, posture.teacher)
        text_view_duration.text = getString(R.string.duration_x, posture.duration)
        text_view_posture_description.text = posture.description
        image_view_posture.loadWithRoundedCorners(posture.picture)
    }
}