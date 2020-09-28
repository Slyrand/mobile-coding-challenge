package com.yogasolo.test.core.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.yogasolo.test.R

fun ImageView.loadWithRoundedCorners(
    url: String?,
    radius: Int = 18,
    @DrawableRes placeHolder: Int = R.drawable.bg_posture_picture
) {
    val requestOptions = RequestOptions()
        .placeholder(placeHolder)
        .transform(
            CenterCrop(),
            RoundedCorners(radius)
        )
    Glide.with(context)
        .load(url)
        .apply(requestOptions)
        .into(this)
}