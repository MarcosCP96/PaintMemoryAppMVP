package com.example.paintmemoryappfragmentsmvp.useCase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

internal class TurnCounterUseCaseTest {

    @Test
    fun `sumar un turno`() {
        val turnCounterUseCase: TurnCounterUseCase = mock()
        val turnCounterUseCase2 = TurnCounterUseCase()
        turnCounterUseCase.increaseTurns()
        verify(turnCounterUseCase).increaseTurns()
        turnCounterUseCase2.increaseTurns()
        assertEquals(1, turnCounterUseCase2.getTurns())
    }

    @Test
    fun `getTurns funciona`() {
        val turnCounterUseCase: TurnCounterUseCase = mock()
        val turnCounterUseCase2 = TurnCounterUseCase()
        turnCounterUseCase.getTurns()
        assertEquals(0, turnCounterUseCase2.getTurns())
        verify(turnCounterUseCase).getTurns()

    }

    @Test
    fun `getTurns devuelve los turnos que debe`(){
        val turnCounterUseCase: TurnCounterUseCase = mock()
        whenever(turnCounterUseCase.getTurns()).thenReturn(1)
        assertEquals(1, turnCounterUseCase.getTurns())
    }
}