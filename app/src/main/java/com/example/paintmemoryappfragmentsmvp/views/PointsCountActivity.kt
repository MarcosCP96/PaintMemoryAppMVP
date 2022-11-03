package com.example.paintmemoryappfragmentsmvp.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.presenters.PointCountPresenter

class PointsCountActivity : AppCompatActivity(), MemoryGameInterface.PointCountView {
    val pointCountPresenter = PointCountPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_points_count)
        val bundle: Bundle? = intent.extras
        val turnCount = bundle?.getInt("turns")
        val pointCountTurnCounterTextView = findViewById<TextView>(R.id.pointsCountTextView)
            .setText("Has tardado: $turnCount turnos")
        val backToMenuButton = findViewById<Button>(R.id.pointsCountBackToMenuButton).setOnClickListener {
            backToMenu()
        }
        val playAgainButton = findViewById<Button>(R.id.playAgainButton).setOnClickListener {
            playAgain()
        }
    }

    override fun backToMenu() {
        startActivity(pointCountPresenter.backToMenuIntent())
    }

    override fun playAgain() {
        startActivity(pointCountPresenter.playAgainIntent())
    }

    override fun goToActivity(intent: Intent) {
        startActivity(intent)
    }
}