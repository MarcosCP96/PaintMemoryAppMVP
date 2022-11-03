package com.example.paintmemoryappfragmentsmvp.presenters

import android.app.AlertDialog
import android.content.Intent
import com.example.paintmemoryappfragmentsmvp.views.GameActivity
import com.example.paintmemoryappfragmentsmvp.views.MainActivity
import com.example.paintmemoryappfragmentsmvp.interfaces.MemoryGameInterface

class MainActivityPresenter(mainActivity: MainActivity):MemoryGameInterface.MainActivityPresenter {
    val presenterMainActivity = mainActivity

    override fun startGame() {
        presenterMainActivity.startActivity(Intent(presenterMainActivity, GameActivity::class.java))
    }
}