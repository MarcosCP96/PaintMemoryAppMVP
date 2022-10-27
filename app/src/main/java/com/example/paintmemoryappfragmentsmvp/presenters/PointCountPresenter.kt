package com.example.paintmemoryappfragmentsmvp.presenters

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import com.example.paintmemoryappfragmentsmvp.views.PointsCountActivity

class PointCountPresenter(val pointsCountActivity: PointsCountActivity): MemoryGameInterface.PointCountPresenter {
    override fun backToMenu() {
        val backToMenuIntent = Intent(pointsCountActivity, MainActivity::class.java)
        pointsCountActivity.startActivity(backToMenuIntent)
    }

    override fun playAgain() {
        val playAgainIntent = Intent(pointsCountActivity, GameActivity::class.java)
        pointsCountActivity.startActivity(playAgainIntent)
    }
}