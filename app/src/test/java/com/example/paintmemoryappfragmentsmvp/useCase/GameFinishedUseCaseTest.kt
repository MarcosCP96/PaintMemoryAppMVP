package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class GameFinishedUseCaseTest {

    @Test
    fun `game is finished`() {
        val gameFinishedUseCase = GameFinishedUseCase()
        val list = listOf(CardNew(1,1, true, false), CardNew(1,2, true, false))
        gameFinishedUseCase.isGameFinished(list)
        assertTrue(gameFinishedUseCase.isGameFinished(list))
    }

    @Test
    fun `game is not finished`() {
        val gameFinishedUseCase = GameFinishedUseCase()
        val list = listOf(CardNew(1,1, false, true), CardNew(1,2, true, false))
        gameFinishedUseCase.isGameFinished(list)
        assertFalse(gameFinishedUseCase.isGameFinished(list))
    }
}