package com.example.paintmemoryappfragmentsmvp.views

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paintmemoryappfragmentsmvp.models.Card
import com.example.paintmemoryappfragmentsmvp.models.DeckOfPairs
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.models.CardAdapter
import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.presenters.GameActivityPresenter
import com.example.paintmemoryappfragmentsmvp.useCase.ShuffleCardsUseCase

class GameActivity : AppCompatActivity(), MemoryGameInterface.GameActivityView {
    private val gameActivityPresenter = GameActivityPresenter(this)
    private var numberOfTurns = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout_game_activity)
//        val deckOfPairs = DeckOfPairs()
        val listOfPlayedCards = mutableListOf<CardNew>()
//        val listOfCards = listOf(
//            Card(),
//            Card(),
//            Card(),
//            Card(),
//            Card(),
//            Card(),
//            Card(),
//            Card()
//        )

//        shuffleCards(listOfCards, deckOfPairs, listOfPlayedCards)
        val listOfCardNew = gameActivityPresenter.getShuffledCards()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = CardAdapter(listOfCardNew) { cardNew -> gameActivityPresenter.flipCard(cardNew, listOfPlayedCards, listOfCardNew) }
        recyclerView.adapter = adapter
    }

    override fun flipCard(card: CardNew) {
        card.imageView?.setImageResource(card.image)
    }

    override fun isListFull(listOfPlayedCards: MutableList<CardNew>): Boolean = gameActivityPresenter.isListFull(listOfPlayedCards)

    override fun showAlertCardRepeated() {
        AlertDialog.Builder(this).setMessage("No puedes usar la misma carta dos veces").show()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun flipCardToBack(card: CardNew) {
        card.imageView?.setImageDrawable(getDrawable(R.drawable.app_icon_small))
    }

//    override fun shuffleCards(
//        listOfCards: List<CardNew>,
//        deckOfPairs: DeckOfPairs,
//        listOfPlayedCards: MutableList<CardNew>
//    ) {
//        gameActivityPresenter.shuffleCards(listOfCards, deckOfPairs, listOfPlayedCards)
//    }

    @SuppressLint("SetTextI18n")
    override fun updateTurns() {
        numberOfTurns++
        val gameActivityTurnText = findViewById<TextView>(R.id.gameActivityTurnTextView)
        gameActivityTurnText.text = "Turn: $numberOfTurns"
    }

    override fun goToActivity(intent: Intent) = startActivity(intent)
}