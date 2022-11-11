package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class ShuffleCardsUseCaseTest {

    @Test
    fun `generar lista de 4 cartas`() {
        val shuffleCardsUseCase = ShuffleCardsUseCase()
        assertEquals(4, shuffleCardsUseCase.generate(1).size)
    }

    @Test
    fun `generar lista de 4 cartas con parejas`() {
        val shuffleCardsUseCase = ShuffleCardsUseCase()
        val list = shuffleCardsUseCase.generate(1).groupingBy { it.image }.eachCount().filter { it.value >= 1 }
        list.forEach { assertTrue(it.value == 2) }
    }

    @Test
    fun `generar lista de 6 cartas`() {
        val shuffleCardsUseCase = ShuffleCardsUseCase()
        assertEquals(6, shuffleCardsUseCase.generate(2).size)
    }

    @Test
    fun `generar lista de 6 cartas con parejas`() {
        val shuffleCardsUseCase = ShuffleCardsUseCase()
        val list = shuffleCardsUseCase.generate(2).groupingBy { it.image }.eachCount().filter { it.value >= 1 }
        list.forEach { assertTrue(it.value == 2) }
    }

    @Test
    fun `generar lista de 8 cartas`() {
        val shuffleCardsUseCase = ShuffleCardsUseCase()
        assertEquals(8, shuffleCardsUseCase.generate(3).size)
    }

    @Test
    fun `generar lista de 8 cartas con parejas`() {
        val shuffleCardsUseCase = ShuffleCardsUseCase()
        val list = shuffleCardsUseCase.generate(3).groupingBy { it.image }.eachCount()
            .filter { it.value >= 1 }
        list.forEach { assertTrue(it.value == 2) }
    }
}