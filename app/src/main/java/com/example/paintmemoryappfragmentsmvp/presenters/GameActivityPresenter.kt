package com.example.paintmemoryappfragmentsmvp.presenters

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.useCase.ShuffleCardsUseCase
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import com.example.paintmemoryappfragmentsmvp.views.PointsCountActivity

class GameActivityPresenter(gameActivity: GameActivity): MemoryGameInterface.GameActivityPresenter {
    private val presenterGameActivity = gameActivity
    private val shuffleCardUseCase = ShuffleCardsUseCase()

    override fun getShuffledCards(): List<CardNew> = shuffleCardUseCase.generate(1)

    override fun flipCard(card: CardNew,
                          listOfPlayedCards: MutableList<CardNew>,
                          listOfCards: List<CardNew>) {
        listOfPlayedCards.add(card)
        presenterGameActivity.flipCard(card)
        if (presenterGameActivity.isListFull(listOfPlayedCards)){
            areCardsIdDifferent(listOfCards, listOfPlayedCards)
        }
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
        presenterGameActivity.flipCardToBack(card)
    }

    override fun disableEqualCards(firstCard: CardNew, secondCard: CardNew) {
        firstCard.imageView?.isEnabled = false
        secondCard.imageView?.isEnabled = false
    }

    override fun isGameFinished(listOfCards: List<CardNew>) {
        var disabledCards = 0
        listOfCards.forEach { card ->
            if (!card.imageView?.isEnabled!!) {
                disabledCards++
                if (disabledCards == listOfCards.size) goToPointCount()
            }
        }
    }

    override fun goToPointCount() {
        presenterGameActivity.goToActivity(pointCountIntent())
    }

//    override fun shuffleCards(
//        listOfCards: List<CardNew>,
//        deckOfPairs: DeckOfPairs,
//        listOfPlayedCards: MutableList<CardNew>
//    ) {
//        var counter = 0
//        listOfCards.forEach { card ->
//            card.image = deckOfPairs.listOfDrawablesTagPairsShuffled[counter].first
//            card.tag = deckOfPairs.listOfDrawablesTagPairsShuffled[counter].second
//            counter++
//        }
//    }

    override fun updateTurns() {
        presenterGameActivity.updateTurns()
    }

    override fun backToMenuIntent(): Intent = Intent(presenterGameActivity, MainActivity::class.java)

    override fun pointCountIntent(): Intent = Intent(presenterGameActivity, PointsCountActivity::class.java)
}