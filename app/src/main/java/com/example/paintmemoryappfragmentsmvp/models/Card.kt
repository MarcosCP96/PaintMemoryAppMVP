package com.example.paintmemoryapp.models

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.views.GameActivity

class Card() {
    var imageView: ImageView? = null
    var card_back: Int = R.drawable.app_icon_small
    var drawable: Int = R.drawable.app_icon_small
    var tag: String = ""
}