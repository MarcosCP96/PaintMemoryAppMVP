package com.example.paintmemoryappfragmentsmvp.views

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.paintmemoryapp.models.Card
import com.example.paintmemoryapp.models.DeckOfPairs
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.presenters.GameActivityPresenter

class GameActivity : AppCompatActivity(), MemoryGameInterface.GameActivityView {
    val gameActivityPresenter = GameActivityPresenter(this)
    var numberOfTurns = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val gameActivityBackToMenuButton = findViewById<Button>(R.id.gameActivityBackToMenuButton).setOnClickListener {
            backToMenu()
        }
        val deckOfPairs = DeckOfPairs()
        val listOfPlayedCards = mutableListOf<Card>()
        var counter = 0
        val gameActivityTurnCounterTextView = findViewById<TextView>(R.id.gameActivityTurnTextView)
            .setText("Turno: $numberOfTurns")
        val listOfCards = listOf(
            Card(findViewById(R.id.gameCard1)),
            Card(findViewById(R.id.gameCard2)),
            Card(findViewById(R.id.gameCard3)),
            Card(findViewById(R.id.gameCard4)),
            Card(findViewById(R.id.gameCard5)),
            Card(findViewById(R.id.gameCard6)),
            Card(findViewById(R.id.gameCard7)),
            Card(findViewById(R.id.gameCard8))
        )
        listOfCards.forEach { card ->
            card.drawable = deckOfPairs.listOfDrawablesTagPairsShuffledHardMode[counter].first
            card.tag = deckOfPairs.listOfDrawablesTagPairsShuffledHardMode[counter].second
            counter++
        }
        listOfCards.forEach { card ->
            card.imageView.setOnClickListener {
                flipCard(card)
                listOfPlayedCards.add(card)
                if (isListFull(listOfPlayedCards)) areCardsIdDifferent(listOfCards, listOfPlayedCards)
            }
        }
    }

    override fun flipCard(card: Card) {
        gameActivityPresenter.flipCard(card)
    }

    override fun backToMenu() {
        gameActivityPresenter.backToMenu()
    }

    override fun isListFull(listOfPlayedCards: MutableList<Card>): Boolean {
       return gameActivityPresenter.isListFull(listOfPlayedCards)
    }

    override fun areCardsIdDifferent(
        listOfCards: List<Card>,
        listOfPlayedCards: MutableList<Card>
    ) {
        gameActivityPresenter.areCardsIdDifferent(listOfCards, listOfPlayedCards)
    }

    override fun showAlertCardRepeated() {
        AlertDialog.Builder(this).setMessage("No puedes usar la misma carta dos veces").show()
    }

    override fun showToastIfEqualTag() {
//        Toast.makeText(this,"Son iguales", Toast.LENGTH_SHORT).show()
    }

    override fun showToastIfDifferentTag() {
//        Toast.makeText(this,"Son diferentes", Toast.LENGTH_SHORT).show()
    }

    override fun flipCardToBack(card: Card) {
        card.imageView.setImageDrawable(getDrawable(card.card_back))
    }

    override fun increaseTurns() {
        numberOfTurns++
        val gameActivityBackToMenuButton = findViewById<TextView>(R.id.gameActivityTurnTextView).setText("Turno: $numberOfTurns")
    }

    override fun goToPointCount() {
        val toPointCountIntent = Intent(this, PointsCountActivity::class.java)
            .putExtra("turns", numberOfTurns)
        startActivity(toPointCountIntent)
    }
}