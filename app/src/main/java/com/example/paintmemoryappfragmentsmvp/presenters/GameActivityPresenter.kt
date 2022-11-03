package com.example.paintmemoryappfragmentsmvp.presenters

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.models.Card
import com.example.paintmemoryappfragmentsmvp.models.DeckOfPairs
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import com.example.paintmemoryappfragmentsmvp.views.PointsCountActivity

class GameActivityPresenter(gameActivity: GameActivity): MemoryGameInterface.GameActivityPresenter {
    private val presenterGameActivity = gameActivity

    override fun flipCard(card: Card,
                          listOfPlayedCards: MutableList<Card>,
                          listOfCards: List<Card>) {
        listOfPlayedCards.add(card)
        presenterGameActivity.flipCard(card)
        if (presenterGameActivity.isListFull(listOfPlayedCards)){
            areCardsTagDifferent(listOfCards, listOfPlayedCards)
        }
    }

    override fun backToMenu() {
        presenterGameActivity.goToActivity(backToMenuIntent())
    }

    override fun isListFull(listOfPlayedCards: MutableList<Card>):Boolean {
        return listOfPlayedCards.size == 2
    }

    override fun areCardsTagDifferent(
        listOfCards: List<Card>,
        listOfPlayedCards: MutableList<Card>
    ) {
        updateTurns()
        if (listOfPlayedCards[0].tag == listOfPlayedCards[1].tag){
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
        listOfCards: List<Card>,
        listOfPlayedCards: MutableList<Card>
    ) {
        if (listOfPlayedCards[0].drawable == listOfPlayedCards[1].drawable){
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

    override fun flipCardToBack(card: Card) {
        presenterGameActivity.flipCardToBack(card)
    }

    override fun disableEqualCards(firstCard: Card, secondCard: Card) {
        firstCard.imageView?.isEnabled = false
        secondCard.imageView?.isEnabled = false
    }

    override fun isGameFinished(listOfCards: List<Card>) {
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

    override fun shuffleCards(
        listOfCards: List<Card>,
        deckOfPairs: DeckOfPairs,
        listOfPlayedCards: MutableList<Card>
    ) {
        var counter = 0
        listOfCards.forEach { card ->
            card.drawable = deckOfPairs.listOfDrawablesTagPairsShuffled[counter].first
            card.tag = deckOfPairs.listOfDrawablesTagPairsShuffled[counter].second
            counter++
        }
    }

    override fun updateTurns() {
        presenterGameActivity.updateTurns()
    }

    override fun backToMenuIntent(): Intent = Intent(presenterGameActivity, MainActivity::class.java)

    override fun pointCountIntent(): Intent = Intent(presenterGameActivity, PointsCountActivity::class.java)
}