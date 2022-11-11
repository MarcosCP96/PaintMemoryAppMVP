package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class CardTurnerUseCaseTest {

    @Test
    fun `comparedcards es false`() {
        val cardTurnerUseCase = CardTurnerUseCase()
        val list = listOf(CardNew(1,1, true, true))
        val playedList = mutableListOf(CardNew(1,1, true, true))
        cardTurnerUseCase.turnCard(list, playedList)
        assertFalse(list[0].isTurned)
    }
}