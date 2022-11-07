package com.example.paintmemoryappfragmentsmvp.interfaces

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.models.CardNew

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
        fun isListFull(listOfPlayedCards: MutableList<CardNew>): Boolean
        fun showAlertCardRepeated()
        fun updateTurns()
        fun getTurns(): Int
        fun goToActivity(intent: Intent)
        fun updateCardAdapter(listOfCards: List<CardNew>)
    }

    interface GameActivityPresenter{
        fun initGame()
        fun getShuffledCards(): List<CardNew>
        fun flipCard(card: CardNew)
        fun backToMenu()
        fun isListFull(listOfPlayedCards: MutableList<CardNew>): Boolean
        fun areCardsIdDifferent(listOfCards: List<CardNew>,
                                 listOfPlayedCards: MutableList<CardNew>)
        fun showAlertCardRepeated()
        fun areCardsDrawableEqual(listOfCards: List<CardNew>,
                                  listOfPlayedCards: MutableList<CardNew>)
        fun flipCardToBack(card: CardNew)
        fun disableEqualCards(firstCard: CardNew,
                              secondCard: CardNew)
        fun isGameFinished(listOfCards: List<CardNew>)
        fun goToPointCount()
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