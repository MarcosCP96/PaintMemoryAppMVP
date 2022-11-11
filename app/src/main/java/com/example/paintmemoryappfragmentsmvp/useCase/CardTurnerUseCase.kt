package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew

class CardTurnerUseCase {
    fun turnCard(cards: List<CardNew>, playedPairOfCards: MutableList<CardNew>){
        cards.forEach { card ->
            if (playedPairOfCards.any { card.id == it.id })
                card.isTurned = false
        }
    }
}