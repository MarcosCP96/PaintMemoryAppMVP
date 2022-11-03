package com.example.paintmemoryappfragmentsmvp.interfaces

import android.content.Intent
import com.example.paintmemoryapp.models.Card
import com.example.paintmemoryapp.models.DeckOfPairs

interface MemoryGameInterface {

    interface PointCountPresenter{
        fun backToMenuIntent(): Intent
        fun playAgainIntent(): Intent
    }

    interface PointCountView{
        fun backToMenu()
        fun playAgain()
        fun goToActivity(intent: Intent)
    }

    interface GameActivityView{
        fun flipCard(card: Card,
                     listOfPlayedCards: MutableList<Card>)
        fun isListFull(listOfPlayedCards: MutableList<Card>): Boolean
        fun showAlertCardRepeated()
        fun flipCardToBack(card: Card)
        fun shuffleCards(listOfCards: List<Card>,
                         deckOfPairs: DeckOfPairs,
                         listOfPlayedCards: MutableList<Card>)
        fun updateTurns()
        fun goToActivity(intent: Intent)
    }

    interface GameActivityPresenter{
        fun flipCard(card: Card,
                     listOfPlayedCards: MutableList<Card>,
                     listOfCards: List<Card>)
        fun backToMenu()
        fun isListFull(listOfPlayedCards: MutableList<Card>): Boolean
        fun areCardsTagDifferent(listOfCards: List<Card>,
                                 listOfPlayedCards: MutableList<Card>)
        fun showAlertCardRepeated()
        fun areCardsDrawableEqual(listOfCards: List<Card>,
                                  listOfPlayedCards: MutableList<Card>)
        fun flipCardToBack(card: Card)
        fun disableEqualCards(firstCard: Card,
                              secondCard: Card)
        fun isGameFinished(listOfCards: List<Card>)
        fun goToPointCount()
        fun shuffleCards(listOfCards: List<Card>,
                         deckOfPairs: DeckOfPairs,
                         listOfPlayedCards: MutableList<Card>)
        fun updateTurns()
        fun backToMenuIntent(): Intent
        fun pointCountIntent(): Intent
    }

    interface MainActivityView{
        fun startGame()
        fun showHelp()
    }

    interface MainActivityPresenter{
        fun startGame()
    }
}