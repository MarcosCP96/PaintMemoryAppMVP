package com.example.paintmemoryappfragmentsmvp.interfaces

import android.widget.TextView
import com.example.paintmemoryapp.models.Card

interface MemoryGameInterface {

    interface PointCountPresenter{
        fun backToMenu()
        fun playAgain()
    }

    interface PointCountView{
        fun backToMenu()
        fun playAgain()
    }

    interface GameActivityView{
        fun flipCard(card: Card)
        fun backToMenu()
        fun isListFull(listOfPlayedCards: MutableList<Card>): Boolean
        fun areCardsIdDifferent(listOfCards: List<Card>, listOfPlayedCards: MutableList<Card>)
        fun showAlertCardRepeated()
        fun showToastIfEqualTag()
        fun showToastIfDifferentTag()
        fun flipCardToBack(card: Card)
        fun increaseTurns()
        fun goToPointCount()
    }

    interface GameActivityPresenter{
        fun flipCard(card: Card)
        fun backToMenu()
        fun isListFull(listOfPlayedCards: MutableList<Card>): Boolean
        fun areCardsIdDifferent(listOfCards: List<Card>, listOfPlayedCards: MutableList<Card>)
        fun showAlertCardRepeated()
        fun areCardsTagEqual(listOfCards: List<Card>, listOfPlayedCards: MutableList<Card>)
        fun showToastIfEqualTag()
        fun showToastIfDifferentTag()
        fun flipCardToBack(card: Card)
        fun disableEqualCards(firstCard: Card, secondCard: Card)
        fun isGameFinished(listOfCards: List<Card>)
        fun increaseTurns()
        fun goToPointCount()
    }

    interface MainActivityView{
        fun startGame()
        fun showHelp()
    }

    interface MainActivityPresenter{
        fun startGame()
        fun showHelp()
    }
}