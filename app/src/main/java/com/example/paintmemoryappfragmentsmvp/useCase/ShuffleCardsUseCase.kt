package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.models.DeckOfPairs

class ShuffleCardsUseCase {
    fun generate(difficulty: Int): List<CardNew> {
        val listDrawables = DeckOfPairs().listOfDrawables
        val newList = when (difficulty) {
            1 -> listDrawables.shuffled().subList(0, 2)
            2 -> listDrawables.shuffled().subList(0, 3)
            else -> listDrawables.shuffled()
        }
        val mutableListRandom = mutableListOf<Int>()
        newList.forEach { card ->
            mutableListRandom.add(card)
            mutableListRandom.add(card)
        }
        return mutableListRandom.shuffled()
            .mapIndexed { index: Int, i: Int -> CardNew(index, i) }
    }
}