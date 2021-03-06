package com.mvp.dagger.rx.sample.photos

import android.content.Context
import androidx.coordinatorlayout.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View
import com.bumptech.glide.Glide
import com.mvp.dagger.rx.sample.R
import com.mvp.dagger.rx.sample.data.Photo
import kotlinx.android.synthetic.main.item_photo.view.*
import androidx.constraintlayout.widget.ConstraintLayout

class PhotoItemView : CoordinatorLayout, View.OnClickListener {

    var photo: Photo? = null

    lateinit var listener: OnPhotoClickListener

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.item_photo, this)
        layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        setOnClickListener(this)
    }

    fun bind(p: Photo?) {
        photo = p
        tvTitle.text = photo?.title
        Glide.with(this).load(photo?.thumbnailUrl).into(ivThumbnail)
    }

    fun setOnPhotoClickListener(l: OnPhotoClickListener) {
        listener = l
    }


    override fun onClick(v: View?) {
        listener.onPhotoClicked(photo)
    }

    interface OnPhotoClickListener {
        fun onPhotoClicked(photo: Photo?)
    }

}