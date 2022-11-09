package com.example.paintmemoryappfragmentsmvp.useCase

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class ShuffleCardsUseCaseTest {

    @Test
    fun `generar lista de cartas`() {
        val shuffleCardsUseCase: ShuffleCardsUseCase = mock()
        shuffleCardsUseCase.generate(1)
        verify(shuffleCardsUseCase).generate(1)
    }
}