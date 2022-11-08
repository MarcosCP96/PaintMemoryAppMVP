package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew

class CardComparatorUseCase {
    fun compareCards(comparedCards: Boolean, cards: List<CardNew>, playedPairOfCards: List<CardNew>){
        if (comparedCards){
            cards.forEach { card ->
                    if (playedPairOfCards.any { card.id == it.id })
                        card.isEnabled = false
            }
        } else {
            cards.forEach { card ->
                    if (playedPairOfCards.any { card.id == it.id })
                        card.isTurned = false
            }
        }
    }
}