package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew

class CardDisablerUseCase {
    fun disableCard(cards: List<CardNew>, playedPairOfCards: MutableList<CardNew>){
        cards.forEach { card ->
            if (playedPairOfCards.any { card.id == it.id })
                card.isEnabled = false
        }
    }
}