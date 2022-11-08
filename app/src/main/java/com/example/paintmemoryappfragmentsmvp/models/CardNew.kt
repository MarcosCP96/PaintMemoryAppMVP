package com.example.paintmemoryappfragmentsmvp.models


data class CardNew(val id: Int,
                   val image: Int,
                   var isTurned: Boolean = false,
                   var isEnabled: Boolean = true)