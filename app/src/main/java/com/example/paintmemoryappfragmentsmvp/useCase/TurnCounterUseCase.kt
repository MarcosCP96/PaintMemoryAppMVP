package com.example.paintmemoryappfragmentsmvp.useCase

class TurnCounterUseCase {
    private var turnNumber = 0
    fun increaseTurns() = turnNumber++
    fun getTurns() = turnNumber
}