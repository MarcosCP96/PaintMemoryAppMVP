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
        fun showAlertCardRepeated()
        fun updateTurns()
        fun getTurns(): Int
        fun goToActivity(intent: Intent)
        fun backToMenu()
        fun goToPointCount()
        fun updateCardAdapter(listOfCards: List<CardNew>)
    }

    interface GameActivityPresenter{
        fun initGame()
        fun getShuffledCards(): List<CardNew>
        fun flipCard(card: CardNew)
        fun showAlertCardRepeated()
        fun updateTurns()
    }

    interface MainActivityView{
        fun startGame()
        fun showHelp()
    }

    interface MainActivityPresenter{
        fun startGame()
    }
}