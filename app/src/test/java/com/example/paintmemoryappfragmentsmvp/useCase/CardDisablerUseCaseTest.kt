package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class CardDisablerUseCaseTest {

    @Test
    fun `comparedcards es true`() {
        val cardDisablerUseCase = CardDisablerUseCase()
        val list = listOf(CardNew(1,1, false, true))
        val playedList = mutableListOf(CardNew(1,1, false, true))
        cardDisablerUseCase.disableCard(list, playedList)
        assertFalse(list[0].isEnabled)
    }
}