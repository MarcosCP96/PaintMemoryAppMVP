package com.example.paintmemoryappfragmentsmvp.presenters

import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.useCase.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.kotlin.*

internal class GameActivityPresenterTest {
    val viewmock: MemoryGameInterface.GameActivityView = mock()
    private val cardDisablerUseCase: CardDisablerUseCase = mock()
    private val cardTurnerUseCase: CardTurnerUseCase = mock()
    private val shuffleCardUseCase: ShuffleCardsUseCase = mock()
    private val idTagEqualUseCase: IdTagEqualUseCase = mock()
    private val isGameFinishedUseCase: GameFinishedUseCase = mock()

    @Test
    fun initGame() {
        val presenter = GameActivityPresenter(
            viewmock,
            shuffleCardUseCase,
            idTagEqualUseCase,
            isGameFinishedUseCase,
            cardDisablerUseCase,
            cardTurnerUseCase
        )
        presenter.initGame()
        verify(shuffleCardUseCase).generate(any())
    }

    @Test
    fun getShuffledCards() {
        val expected = listOf(CardNew(1, 1), CardNew(2, 1))
        whenever(shuffleCardUseCase.generate(any())).thenReturn(expected)
        val presenter = GameActivityPresenter(
            viewmock,
            shuffleCardUseCase,
            idTagEqualUseCase,
            isGameFinishedUseCase,
            cardDisablerUseCase,
            cardTurnerUseCase
        )
        presenter.initGame()
        val result = presenter.getShuffledCards()
        assertEquals(expected, result)
    }

    @Test
    fun flipCard() {
        val expected = listOf(CardNew(1, 1), CardNew(2, 1))
        whenever(shuffleCardUseCase.generate(any())).thenReturn(expected)
        val presenter = GameActivityPresenter(
            viewmock, shuffleCardUseCase, idTagEqualUseCase,
            isGameFinishedUseCase, cardDisablerUseCase, cardTurnerUseCase
        )
        presenter.initGame()
        presenter.flipCard(CardNew(1, 1))
        verify(viewmock).updateCardAdapter(listOf(CardNew(1, 1, isTurned = true), CardNew(2, 1)))
        verify(viewmock, times(0)).updateTurns()
        verify(idTagEqualUseCase, times(0)).execute(any())
        verify(cardDisablerUseCase, times(0)).disableCard(any(), any())
        verify(cardTurnerUseCase, never()).turnCard(any(), any())
        verify(isGameFinishedUseCase, never()).isGameFinished(any())
        verify(viewmock, never()).goToPointCount()
    }

    @Test
    fun flipCard2() {
        val expected = listOf(CardNew(1, 1), CardNew(2, 1))
        whenever(shuffleCardUseCase.generate(any())).thenReturn(expected)
        val presenter = GameActivityPresenter(
            viewmock, shuffleCardUseCase, idTagEqualUseCase,
            isGameFinishedUseCase, cardDisablerUseCase, cardTurnerUseCase)
        presenter.initGame()
        presenter.flipCard(CardNew(1, 1))
        println("---------")
        presenter.flipCard(CardNew(2, 1))

        val argument = ArgumentCaptor.forClass(
            List::class.java
        )

        verify(viewmock, times(3)).updateCardAdapter(argument.capture() as List<CardNew>)
        assertEquals(listOf(CardNew(1, 1, isTurned = true), CardNew(2, 1)), argument.firstValue)

//        argumentCaptor<List<CardNew>>().apply {
//            verify(viewmock, times(3)).updateCardAdapter(capture())
//            println(allValues)
//            assertEquals(3, allValues.size)
//            assertEquals(listOf(CardNew(1, 1, isTurned = true), CardNew(2, 1)), firstValue)
//            assertEquals(listOf(CardNew(1, 1, isTurned = true), CardNew(2, 1, isTurned = true)), secondValue)
//            assertEquals(listOf(CardNew(1, 1, isTurned = true), CardNew(2, 1, isTurned = true)), thirdValue)
//        }
//        verify(viewmock, times(0)).updateTurns()
//        verify(idTagEqualUseCase, times(0)).execute(any())
//        verify(cardDisablerUseCase, times(0)).disableCard(any(), any())
//        verify(cardTurnerUseCase, never()).turnCard(any(), any())
//        verify(isGameFinishedUseCase, never()).isGameFinished(any())
//        verify(viewmock, never()).goToPointCount()
    }
}