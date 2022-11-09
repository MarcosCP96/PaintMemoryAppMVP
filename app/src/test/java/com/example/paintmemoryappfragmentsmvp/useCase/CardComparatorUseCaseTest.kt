package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class CardComparatorUseCaseTest {

    @Test
    fun compareCards() {
        val cardComparator: CardComparatorUseCase = mock()
        val list = listOf<CardNew>(CardNew(0, 2131165397), CardNew(1, 2131165397))
        val cardsPlayed = listOf(list[0], list[1])
        cardComparator.compareCards(true, list, cardsPlayed)
        verify(cardComparator).compareCards(true, list, cardsPlayed)
    }
}