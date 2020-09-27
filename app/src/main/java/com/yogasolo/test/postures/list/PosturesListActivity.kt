package com.yogasolo.test.postures.list

import android.os.Bundle
import com.yogasolo.test.R
import com.yogasolo.test.core.coroutines.ScopedActivity

class PosturesListActivity : ScopedActivity(), PosturesListPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_postures_list)
    }

    override fun setUpUI() {

    }
}