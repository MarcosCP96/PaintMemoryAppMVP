package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew

class GameFinishedUseCase {
    fun isGameFinished(listOfCards: List<CardNew>): Boolean {
//        var disabledCards = 0
//        listOfCards.forEach { card ->
//            if (!card.isEnabled) disabledCards++
//        }
//        if (disabledCards == listOfCards.size) {
//            return true
//        }
//        return false
        return (listOfCards.filter { !it.isEnabled }.size == listOfCards.size)
    }
}