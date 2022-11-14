package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class CardTurnerUseCaseTest {

    @Test
    fun `cartas iguales en list y playedList`() {
        val cardTurnerUseCase = CardTurnerUseCase()
        val list = listOf(CardNew(1,1, true, true),CardNew(2,1, true, true))
        val playedList = mutableListOf(list[0], list[1])
        cardTurnerUseCase.turnCard(list, playedList)
        list.forEach { assertFalse(it.isTurned) }
    }

    @Test
    fun `cartas diferentes en list y playedList`() {
        val cardTurnerUseCase = CardTurnerUseCase()
        val list = listOf(CardNew(1,1, true, true),CardNew(2,1, true, true))
        val playedList = mutableListOf(CardNew(3,1, true, true), CardNew(4,1, true, true))
        cardTurnerUseCase.turnCard(list, playedList)
        list.forEach { assertTrue(it.isTurned) }
    }

    @Test
    fun `solo una carta coincide`() {
        val cardTurnerUseCase = CardTurnerUseCase()
        val list = listOf(CardNew(1,1, true, true),CardNew(2,1, true, true))
        val playedList = mutableListOf(CardNew(1,1, true, true), CardNew(4,1, true, true))
        cardTurnerUseCase.turnCard(list, playedList)
        assertTrue(list.any { !it.isTurned })
    }
}