package com.example.paintmemoryapp.models

import com.example.paintmemoryappfragmentsmvp.R


class DeckOfPairs {
    var listOfDrawablesTagPairsHardMode = mutableListOf(Pair(R.drawable.eraser_front_card,"eraser"),
        Pair(R.drawable.eraser_front_card,"eraser"),
        Pair(R.drawable.pencil_front_card,"pencil"),
        Pair(R.drawable.pencil_front_card,"pencil"),
        Pair(R.drawable.spray_front_card,"spray"),
        Pair(R.drawable.spray_front_card,"spray"),
        Pair(R.drawable.bucket_front_card,"bucket"),
        Pair(R.drawable.bucket_front_card,"bucket"))
    var listOfDrawablesTagPairsShuffledHardMode = listOfDrawablesTagPairsHardMode.shuffled()

    var listOfDrawablesTagPairsEasyMode = mutableListOf(Pair(R.drawable.eraser_front_card,"eraser"),
        Pair(R.drawable.eraser_front_card,"eraser"),
        Pair(R.drawable.pencil_front_card,"pencil"),
        Pair(R.drawable.pencil_front_card,"pencil"),
        Pair(R.drawable.spray_front_card,"spray"),
        Pair(R.drawable.spray_front_card,"spray"))
    var listOfDrawablesTagPairsShuffledEasyMode = listOfDrawablesTagPairsEasyMode.shuffled()
}