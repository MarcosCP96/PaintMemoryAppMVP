package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class GameFinishedUseCaseTest {

    @Test
    fun isGameFinished() {
        val gameFinishedUseCase: GameFinishedUseCase = mock()
        val gameFinishedUseCase2 = GameFinishedUseCase()
        val list = listOf(CardNew(1,1, true, false), CardNew(1,2, true, false))
        gameFinishedUseCase.isGameFinished(list)
        verify(gameFinishedUseCase).isGameFinished(list)
        assertTrue(gameFinishedUseCase2.isGameFinished(list))
    }
}