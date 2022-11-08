package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew

class GameFinishedUseCase {
    fun isGameFinished(listOfCards: List<CardNew>): Boolean {
        return (listOfCards.filter { !it.isEnabled }.size == listOfCards.size)
    }
}