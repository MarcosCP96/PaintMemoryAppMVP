package com.example.paintmemoryappfragmentsmvp.interfaces

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.models.CardNew

interface MemoryGameInterface {

    interface MainActivityPresenter{
        fun startGame()
    }

    interface GameActivityView{
        fun showAlertCardRepeated()
        fun updateTurns()
        fun getTurns(): Int
        fun goToPointCount()
        fun updateCardAdapter(listOfCards: List<CardNew>)
    }

    interface GameActivityPresenter{
        fun initGame()
        fun getShuffledCards(): List<CardNew>
        fun flipCard(card: CardNew)
        fun showAlertCardRepeated()
    }

    interface PointCountPresenter{
        fun backToMenuIntent(): Intent
        fun playAgainIntent(): Intent
    }
}