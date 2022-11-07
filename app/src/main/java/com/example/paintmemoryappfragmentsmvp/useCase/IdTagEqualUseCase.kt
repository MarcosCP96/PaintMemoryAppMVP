package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew

class IdTagEqualUseCase {

    fun execute(playedListOfCards: MutableList<CardNew>): Boolean{
        if (playedListOfCards.size == 2){
            return areCardsIdDifferent(playedListOfCards[0],playedListOfCards[1])
        }
        throw java.lang.Exception("Solo puedes usar dos cartas")
    }

    private fun areCardsIdDifferent(firstCard: CardNew,secondCard: CardNew): Boolean {
        return if (firstCard.id == secondCard.id){
            false
        } else {
                areCardsDrawableEqual(firstCard, secondCard)
        }
    }

    private fun areCardsDrawableEqual(firstCard: CardNew, secondCard: CardNew) = firstCard.image == secondCard.image
}