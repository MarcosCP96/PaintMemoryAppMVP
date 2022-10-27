package com.example.paintmemoryappfragmentsmvp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.paintmemoryappfragmentsmvp.R
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.presenters.MainActivityPresenter

class MainActivity : AppCompatActivity(),MemoryGameInterface.MainActivityView {
    val mainActivityPresenter = MainActivityPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainMenuPlayButton = findViewById<Button>(R.id.mainMenuPlayButton).setOnClickListener {
            startGame()
        }
        val mainMenuHelpButton = findViewById<Button>(R.id.mainMenuHelpButton).setOnClickListener {
            showHelp()
        }
    }

    override fun startGame() {
        mainActivityPresenter.startGame()
    }

    override fun showHelp() {
        mainActivityPresenter.showHelp()
    }
}