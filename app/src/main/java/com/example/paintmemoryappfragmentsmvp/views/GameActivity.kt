package com.example.paintmemoryappfragmentsmvp.views

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paintmemoryapp.models.Card
import com.example.paintmemoryapp.models.DeckOfPairs
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.models.CardAdapter
import com.example.paintmemoryappfragmentsmvp.presenters.GameActivityPresenter
import org.w3c.dom.Text

class GameActivity : AppCompatActivity(), MemoryGameInterface.GameActivityView {
    val gameActivityPresenter = GameActivityPresenter(this)
    var numberOfTurns = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout_game_activity)
        val deckOfPairs = DeckOfPairs()
        val listOfPlayedCards = mutableListOf<Card>()
        var counter = 0
        val listOfCards = listOf(
            Card(),
            Card(),
            Card(),
            Card(),
            Card(),
            Card(),
            Card(),
            Card()
        )
        shuffleCards(listOfCards, deckOfPairs, listOfPlayedCards)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = CardAdapter(listOfCards) { card -> gameActivityPresenter.flipCard(card, listOfPlayedCards, listOfCards) }
        recyclerView.adapter = adapter
    }

    override fun flipCard(card: Card, listOfPlayedCards: MutableList<Card>) {
        card.imageView?.setImageResource(card.drawable)
    }

    override fun isListFull(listOfPlayedCards: MutableList<Card>): Boolean = gameActivityPresenter.isListFull(listOfPlayedCards)

    override fun showAlertCardRepeated() {
        AlertDialog.Builder(this).setMessage("No puedes usar la misma carta dos veces").show()
    }

    override fun flipCardToBack(card: Card) {
        card.imageView?.setImageDrawable(getDrawable(R.drawable.app_icon_small))
    }

    override fun shuffleCards(
        listOfCards: List<Card>,
        deckOfPairs: DeckOfPairs,
        listOfPlayedCards: MutableList<Card>
    ) {
        gameActivityPresenter.shuffleCards(listOfCards, deckOfPairs, listOfPlayedCards)
    }

    override fun updateTurns() {
        numberOfTurns++
        val gameActivityBackToMenuButton = findViewById<TextView>(R.id.gameActivityTurnTextView).setText("Turno: $numberOfTurns")
    }

    override fun goToActivity(intent: Intent) = startActivity(intent)
}