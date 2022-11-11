package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class ShuffleCardsUseCaseTest {

    @Test
    fun `generar lista de cartas`() {
        val expected = listOf(CardNew(1,1), CardNew(2,1))
        val shuffleCardsUseCase: ShuffleCardsUseCase = mock()
        whenever(shuffleCardsUseCase.generate(1)).thenReturn(expected)
        val result = shuffleCardsUseCase.generate(1)
        assertEquals(expected, result)
    }
}