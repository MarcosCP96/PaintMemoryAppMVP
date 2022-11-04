package com.example.paintmemoryappfragmentsmvp.models

import android.widget.ImageView
import com.example.paintmemoryappfragmentsmvp.R

class Card {
    var imageView: ImageView? = null
    var cardBack: Int = R.drawable.app_icon_small
    var drawable: Int = R.drawable.app_icon_small
    var tag: String = ""
}

data class CardNew(var image: Int,
                   var isTurned: Boolean,
                   val id: Int,
                   var imageView: ImageView? = null)