package com.example.paintmemoryapp.models

import com.example.paintmemoryappfragmentsmvp.R


class DeckOfPairs {
    var listOfDrawablesTagPairsHardMode = mutableListOf(Pair(R.drawable.eraser_front_card,"eraser1"),
        Pair(R.drawable.eraser_front_card,"eraser2"),
        Pair(R.drawable.pencil_front_card,"pencil1"),
        Pair(R.drawable.pencil_front_card,"pencil2"),
        Pair(R.drawable.spray_front_card,"spray1"),
        Pair(R.drawable.spray_front_card,"spray2"),
        Pair(R.drawable.bucket_front_card,"bucket1"),
        Pair(R.drawable.bucket_front_card,"bucket2"))
    var listOfDrawablesTagPairsShuffledHardMode = listOfDrawablesTagPairsHardMode.shuffled()

    var listOfDrawablesTagPairsEasyMode = mutableListOf(Pair(R.drawable.eraser_front_card,"eraser"),
        Pair(R.drawable.eraser_front_card,"eraser"),
        Pair(R.drawable.pencil_front_card,"pencil"),
        Pair(R.drawable.pencil_front_card,"pencil"),
        Pair(R.drawable.spray_front_card,"spray"),
        Pair(R.drawable.spray_front_card,"spray"))
    var listOfDrawablesTagPairsShuffledEasyMode = listOfDrawablesTagPairsEasyMode.shuffled()
}