package com.example.paintmemoryappfragmentsmvp.presenters

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.useCase.GameFinishedUseCase
import com.example.paintmemoryappfragmentsmvp.useCase.IdTagEqualUseCase
import com.example.paintmemoryappfragmentsmvp.useCase.ShuffleCardsUseCase
import com.example.paintmemoryappfragmentsmvp.useCase.TurnCounterUseCase
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import com.example.paintmemoryappfragmentsmvp.views.PointsCountActivity

class GameActivityPresenter(gameActivity: GameActivity): MemoryGameInterface.GameActivityPresenter {
    private val presenterGameActivity = gameActivity
    private val shuffleCardUseCase = ShuffleCardsUseCase()
    private var idTagEqualUseCase = IdTagEqualUseCase()
    private var isGameFinishedUseCase = GameFinishedUseCase()
    private var cards: List<CardNew> = listOf()
    private var playedPairOfCards: MutableList<CardNew> = mutableListOf()

    override fun initGame() {
        cards = shuffleCardUseCase.generate(1)
    }

    override fun getShuffledCards(): List<CardNew> = cards

    override fun flipCard(card: CardNew) {
        playedPairOfCards.add(card)
        
        if (playedPairOfCards.size == 2) presenterGameActivity.updateTurns()

        var cardToTurn = cards.indexOf(card)

        cards[cardToTurn].isTurned = true

        presenterGameActivity.updateCardAdapter(cards)

        try {
            val compared = idTagEqualUseCase.execute(playedPairOfCards)
            if (compared){
                cards.forEach { card ->
                    if (playedPairOfCards.any { card.id == it.id })
                        card.isEnabled = false
                }
            } else {
                cards.forEach { card ->
                    if (playedPairOfCards.any { card.id == it.id })
                        card.isTurned = false
                }
            }
            playedPairOfCards.clear()
            presenterGameActivity.updateCardAdapter(cards)
        } catch (e:Exception){
            e.printStackTrace()
        }
        if (isGameFinishedUseCase.isGameFinished(cards)) goToPointCount()
    }

    override fun backToMenu() {
        presenterGameActivity.goToActivity(backToMenuIntent())
    }

    override fun isListFull(listOfPlayedCards: MutableList<CardNew>):Boolean {
        return listOfPlayedCards.size == 2
    }

    override fun areCardsIdDifferent(
        listOfCards: List<CardNew>,
        listOfPlayedCards: MutableList<CardNew>
    ) {
        updateTurns()
        if (listOfPlayedCards[0].id == listOfPlayedCards[1].id){
            showAlertCardRepeated()
            listOfPlayedCards.forEach {
                    card -> flipCardToBack(card)
            }
            listOfPlayedCards.clear()
        } else {
            areCardsDrawableEqual(listOfCards, listOfPlayedCards)
        }
    }

    override fun showAlertCardRepeated() {
        presenterGameActivity.showAlertCardRepeated()
    }

    override fun areCardsDrawableEqual(
        listOfCards: List<CardNew>,
        listOfPlayedCards: MutableList<CardNew>
    ) {
        if (listOfPlayedCards[0].image == listOfPlayedCards[1].image){
            disableEqualCards(listOfPlayedCards[0], listOfPlayedCards[1])
            listOfPlayedCards.clear()
        } else {
            listOfPlayedCards.forEach {
                    card -> flipCardToBack(card)
            }
            listOfPlayedCards.clear()
        }
        isGameFinished(listOfCards)
    }

    override fun flipCardToBack(card: CardNew) {
//        presenterGameActivity.flipCardToBack(card)
    }

    override fun disableEqualCards(firstCard: CardNew, secondCard: CardNew) {
//        firstCard.imageView?.isEnabled = false
//        secondCard.imageView?.isEnabled = false
    }

    override fun isGameFinished(listOfCards: List<CardNew>) {
//        var disabledCards = 0
//        listOfCards.forEach { card ->
//            if (!card.imageView?.isEnabled!!) {
//                disabledCards++
//                if (disabledCards == listOfCards.size) goToPointCount()
//            }
//        }
    }

    override fun goToPointCount() {
        presenterGameActivity.goToActivity(pointCountIntent())
    }

    override fun updateTurns() {
        presenterGameActivity.updateTurns()
    }

    override fun backToMenuIntent(): Intent = Intent(presenterGameActivity, MainActivity::class.java)

    override fun pointCountIntent(): Intent = Intent(presenterGameActivity, PointsCountActivity::class.java)
        .putExtra("turns", presenterGameActivity.getTurns())
}