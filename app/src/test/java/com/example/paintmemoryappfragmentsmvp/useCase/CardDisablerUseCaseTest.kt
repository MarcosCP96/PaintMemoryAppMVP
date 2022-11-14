package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class CardDisablerUseCaseTest {

    @Test
    fun `cartas iguales en list y playedList`() {
        val cardDisablerUseCase = CardDisablerUseCase()
        val list = listOf(CardNew(1,1, true, true),CardNew(2,1, true, true))
        val playedList = mutableListOf(list[0], list[1])
        cardDisablerUseCase.disableCard(list, playedList)
        list.forEach { assertFalse(it.isEnabled) }
    }

    @Test
    fun `cartas diferentes en list y playedList`() {
        val cardDisablerUseCase = CardDisablerUseCase()
        val list = listOf(CardNew(1,1, true, true),CardNew(2,1, true, true))
        val playedList = mutableListOf(CardNew(3,1, true, true), CardNew(4,1, true, true))
        cardDisablerUseCase.disableCard(list, playedList)
        list.forEach { assertTrue(it.isEnabled) }
    }

    @Test
    fun `solo una carta coincide`() {
        val cardDisablerUseCase = CardDisablerUseCase()
        val list = listOf(CardNew(1,1, true, true),CardNew(2,1, true, true))
        val playedList = mutableListOf(CardNew(1,1, true, true), CardNew(4,1, true, true))
        cardDisablerUseCase.disableCard(list, playedList)
        assertTrue(list.any { !it.isEnabled })
    }
}