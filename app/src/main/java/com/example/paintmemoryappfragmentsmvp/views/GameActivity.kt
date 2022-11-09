package com.example.paintmemoryappfragmentsmvp.views

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.models.CardAdapter
import com.example.paintmemoryappfragmentsmvp.models.CardNew
import com.example.paintmemoryappfragmentsmvp.presenters.GameActivityPresenter
import com.example.paintmemoryappfragmentsmvp.useCase.TurnCounterUseCase

class GameActivity : AppCompatActivity(), MemoryGameInterface.GameActivityView {
    private val gameActivityPresenter = GameActivityPresenter(this)
    private var turnCounterUseCase = TurnCounterUseCase()
    private var numberOfTurns = turnCounterUseCase.getTurns()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table_layout_game_activity)
        gameActivityPresenter.initGame()
        val listOfCardNew = gameActivityPresenter.getShuffledCards()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = CardAdapter() { cardNew -> gameActivityPresenter.flipCard(cardNew) }
        adapter.updateCards(listOfCardNew)
        recyclerView.adapter = adapter
    }

    private fun goToActivity(intent: Intent) = startActivity(intent)

    private fun backToMenu() {
        goToActivity(backToMenuIntent())
    }

    private fun backToMenuIntent(): Intent = Intent(this, MainActivity::class.java)

    private fun pointCountIntent(): Intent = Intent(this, PointsCountActivity::class.java)
            .putExtra("turns", getTurns())

    override fun showAlertCardRepeated() {
        AlertDialog.Builder(this).setMessage("No puedes usar la misma carta dos veces").show()
    }

    @SuppressLint("SetTextI18n")
    override fun updateTurns() {
        val gameActivityTurnText = findViewById<TextView>(R.id.gameActivityTurnTextView)
        turnCounterUseCase.increaseTurns()
        gameActivityTurnText.text = "Turn: $numberOfTurns"
    }

    override fun getTurns() = turnCounterUseCase.getTurns()

    override fun updateCardAdapter(listOfCards: List<CardNew>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = recyclerView.adapter as CardAdapter
        adapter.updateCards(listOfCards)
    }

    override fun goToPointCount() {
        goToActivity(pointCountIntent())
    }
}