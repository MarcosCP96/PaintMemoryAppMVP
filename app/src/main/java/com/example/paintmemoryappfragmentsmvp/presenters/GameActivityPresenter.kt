package com.example.paintmemoryappfragmentsmvp.presenters

import android.content.Intent
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.example.paintmemoryapp.models.Card
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import org.w3c.dom.Text

class GameActivityPresenter(gameActivity: GameActivity): MemoryGameInterface.GameActivityPresenter {
    val presenterGameActivity = gameActivity

    override fun flipCard(card: Card) {
        card.imageView.setImageDrawable(getDrawable(presenterGameActivity, card.drawable))
    }

    override fun backToMenu() {
        presenterGameActivity.startActivity(Intent(presenterGameActivity, MainActivity::class.java))
    }

    override fun isListFull(listOfPlayedCards: MutableList<Card>):Boolean {
        return listOfPlayedCards.size == 2
    }

    override fun areCardsIdDifferent(
        listOfCards: List<Card>,
        listOfPlayedCards: MutableList<Card>
    ) {
        increaseTurns()
        if (listOfPlayedCards[0].imageView.id == listOfPlayedCards[1].imageView.id){
            showAlertCardRepeated()
            listOfPlayedCards.forEach {
                    card -> flipCardToBack(card)
            }
            listOfPlayedCards.clear()
        } else {
            areCardsTagEqual(listOfCards, listOfPlayedCards)
        }
    }

    override fun showAlertCardRepeated() {
        presenterGameActivity.showAlertCardRepeated()
    }

    override fun areCardsTagEqual(
        listOfCards: List<Card>,
        listOfPlayedCards: MutableList<Card>
    ) {
        if (listOfPlayedCards[0].tag == listOfPlayedCards[1].tag){
            showToastIfEqualTag()
            disableEqualCards(listOfPlayedCards[0], listOfPlayedCards[1])
            listOfPlayedCards.clear()
        } else {
            showToastIfDifferentTag()
            listOfPlayedCards.forEach {
                    card -> flipCardToBack(card)
            }
            listOfPlayedCards.clear()
        }
        isGameFinished(listOfCards)
    }

    override fun showToastIfEqualTag() {
        presenterGameActivity.showToastIfEqualTag()
    }

    override fun showToastIfDifferentTag() {
        presenterGameActivity.showToastIfDifferentTag()
    }

    override fun flipCardToBack(card: Card) {
        presenterGameActivity.flipCardToBack(card)
    }

    override fun disableEqualCards(firstCard: Card, secondCard: Card) {
        firstCard.imageView.isEnabled = false
        secondCard.imageView.isEnabled = false
    }

    override fun isGameFinished(listOfCards: List<Card>) {
        var disabledCards = 0
        listOfCards.forEach { card ->
            if (!card.imageView.isEnabled) {
                disabledCards++
                if (disabledCards == listOfCards.size) goToPointCount()
            }
        }
    }

    override fun increaseTurns() {
        presenterGameActivity.increaseTurns()
    }

    override fun goToPointCount() {
        presenterGameActivity.goToPointCount()
    }
}