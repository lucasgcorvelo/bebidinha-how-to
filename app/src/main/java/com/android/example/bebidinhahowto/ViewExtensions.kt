package com.android.example.bebidinhahowto

import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso

fun ImageView.loadDrawableImage (imageResource: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(context, imageResource))
}

fun ImageView.loadImageFromURL (url: String) {
    Picasso.get().load(url).into(this)
}