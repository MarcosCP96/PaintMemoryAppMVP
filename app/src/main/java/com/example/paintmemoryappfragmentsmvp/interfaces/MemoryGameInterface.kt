package com.example.paintmemoryappfragmentsmvp.interfaces

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.models.Card
import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.models.DeckOfPairs

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
        fun flipCard(card: CardNew)
        fun isListFull(listOfPlayedCards: MutableList<CardNew>): Boolean
        fun showAlertCardRepeated()
        fun flipCardToBack(card: CardNew)
//        fun shuffleCards(listOfCards: List<CardNew>,
//                         deckOfPairs: DeckOfPairs,
//                         listOfPlayedCards: MutableList<CardNew>)
        fun updateTurns()
        fun goToActivity(intent: Intent)
    }

    interface GameActivityPresenter{
        fun getShuffledCards(): List<CardNew>
        fun flipCard(card: CardNew,
                     listOfPlayedCards: MutableList<CardNew>,
                     listOfCards: List<CardNew>)
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
//        fun shuffleCards(listOfCards: List<CardNew>,
//                         deckOfPairs: DeckOfPairs,
//                         listOfPlayedCards: MutableList<CardNew>)
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