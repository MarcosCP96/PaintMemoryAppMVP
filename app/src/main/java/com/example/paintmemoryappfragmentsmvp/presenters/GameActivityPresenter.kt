package com.example.paintmemoryappfragmentsmvp.presenters

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.useCase.*

class GameActivityPresenter(private val presenterGameActivityInterface: MemoryGameInterface.GameActivityView,
                            private val shuffleCardUseCase: ShuffleCardsUseCase = ShuffleCardsUseCase(),
                            private val idTagEqualUseCase: IdTagEqualUseCase = IdTagEqualUseCase(),
                            private val isGameFinishedUseCase: GameFinishedUseCase = GameFinishedUseCase(),
                            private val cardDisablerUseCase: CardDisablerUseCase = CardDisablerUseCase(),
                            private val cardTurnerUseCase: CardTurnerUseCase = CardTurnerUseCase())
    : MemoryGameInterface.GameActivityPresenter {

    private var cards: List<CardNew> = listOf()
    private var playedPairOfCards: MutableList<CardNew> = mutableListOf()

    override fun initGame() {
        cards = shuffleCardUseCase.generate(1)
    }

    override fun getShuffledCards(): List<CardNew> = cards

    override fun flipCard(card: CardNew) {
        println("Primero: $cards")
        playedPairOfCards.add(card)
        cards.indexOf(card).apply { cards[this].isTurned = true }
        println("Segundo: $cards")
        presenterGameActivityInterface.updateCardAdapter(cards)
        if (isListFull(playedPairOfCards)) {
            presenterGameActivityInterface.updateTurns()
            try {
                when(idTagEqualUseCase.execute(playedPairOfCards)){
                    true -> cardDisablerUseCase.disableCard(cards, playedPairOfCards)
                    false -> cardTurnerUseCase.turnCard(cards, playedPairOfCards)
                }
                playedPairOfCards.clear()
                println("Tercero: $cards")
                presenterGameActivityInterface.updateCardAdapter(cards)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            if (isGameFinishedUseCase.isGameFinished(cards)) presenterGameActivityInterface.goToPointCount()
        }
    }

    override fun showAlertCardRepeated() {
        presenterGameActivityInterface.showAlertCardRepeated()
    }

    private fun isListFull(listOfPlayedCards: MutableList<CardNew>) = listOfPlayedCards.size == 2
}