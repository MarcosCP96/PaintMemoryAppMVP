package com.example.paintmemoryappfragmentsmvp.presenters

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.useCase.*

class GameActivityPresenter(gameActivityInterface: MemoryGameInterface.GameActivityView) : MemoryGameInterface.GameActivityPresenter {
    private val presenterGameActivityInterface = gameActivityInterface
    private val cardComparatorUseCase = CardComparatorUseCase()
    private val shuffleCardUseCase = ShuffleCardsUseCase()
    private val idTagEqualUseCase = IdTagEqualUseCase()
    private val isGameFinishedUseCase = GameFinishedUseCase()
    private var cards: List<CardNew> = listOf()
    private var playedPairOfCards: MutableList<CardNew> = mutableListOf()

    override fun initGame() {
        cards = shuffleCardUseCase.generate(1)
    }

    override fun getShuffledCards(): List<CardNew> = cards

    override fun flipCard(card: CardNew) {
        playedPairOfCards.add(card)
        if (isListFull(playedPairOfCards)) presenterGameActivityInterface.updateTurns()
        cards.indexOf(card).apply { cards[this].isTurned = true }
        presenterGameActivityInterface.updateCardAdapter(cards)

        try {
            val comparedCards = idTagEqualUseCase.execute(playedPairOfCards)
            cardComparatorUseCase.compareCards(comparedCards, cards, playedPairOfCards)
            playedPairOfCards.clear()
            presenterGameActivityInterface.updateCardAdapter(cards)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (isGameFinishedUseCase.isGameFinished(cards)) presenterGameActivityInterface.goToPointCount()
    }

    override fun showAlertCardRepeated() {
        presenterGameActivityInterface.showAlertCardRepeated()
    }

    private fun isListFull(listOfPlayedCards: MutableList<CardNew>) = listOfPlayedCards.size == 2
}