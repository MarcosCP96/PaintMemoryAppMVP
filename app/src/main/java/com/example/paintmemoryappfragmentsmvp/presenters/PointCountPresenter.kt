package com.example.paintmemoryappfragmentsmvp.presenters

import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import com.example.paintmemoryappfragmentsmvp.views.PointsCountActivity

class PointCountPresenter(private val pointsCountActivity: PointsCountActivity): MemoryGameInterface.PointCountPresenter {

    override fun backToMenuIntent(): Intent  = Intent(pointsCountActivity, MainActivity::class.java)

    override fun playAgainIntent(): Intent = Intent(pointsCountActivity, GameActivity::class.java)
}