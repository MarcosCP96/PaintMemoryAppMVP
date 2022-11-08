package com.example.paintmemoryappfragmentsmvp.useCase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TurnCounterUseCaseTest {

    @Test
    fun `sumar un turno`() {
        val turnCounterUseCase = TurnCounterUseCase()
        turnCounterUseCase.increaseTurns()
        assertEquals(1, turnCounterUseCase.getTurns())
    }

    @Test
    fun getTurns() {
        val turnCounterUseCase = TurnCounterUseCase()
        assertEquals(0, turnCounterUseCase.getTurns())
    }
}