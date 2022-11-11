package com.example.paintmemoryappfragmentsmvp.useCase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.*

internal class TurnCounterUseCaseTest {

    @Test
    fun `sumar un turno`() {
        val turnCounterUseCase = TurnCounterUseCase()
        turnCounterUseCase.increaseTurns()
        assertEquals(1, turnCounterUseCase.getTurns())
    }

    @Test
    fun `getTurns devuelve 0`() {
        val turnCounterUseCase = TurnCounterUseCase()
        turnCounterUseCase.getTurns()
        assertEquals(0, turnCounterUseCase.getTurns())
    }
}