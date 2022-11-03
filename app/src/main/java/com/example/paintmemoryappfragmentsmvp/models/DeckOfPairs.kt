package com.example.paintmemoryappfragmentsmvp.models

import com.example.paintmemoryappfragmentsmvp.R

class DeckOfPairs {
    private var listOfDrawablesTagPairs = mutableListOf(Pair(R.drawable.eraser_front_card,"eraser1"),
        Pair(R.drawable.eraser_front_card,"eraser2"),
        Pair(R.drawable.pencil_front_card,"pencil1"),
        Pair(R.drawable.pencil_front_card,"pencil2"),
        Pair(R.drawable.spray_front_card,"spray1"),
        Pair(R.drawable.spray_front_card,"spray2"),
        Pair(R.drawable.bucket_front_card,"bucket1"),
        Pair(R.drawable.bucket_front_card,"bucket2"))
    var listOfDrawablesTagPairsShuffled = listOfDrawablesTagPairs.shuffled()
}