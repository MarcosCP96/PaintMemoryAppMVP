package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.lang.Exception

internal class IdTagEqualUseCaseTest {

    @Test
    fun execute() {
        val idTagEqualUseCase = IdTagEqualUseCase()
        val list = mutableListOf(CardNew(1,1), CardNew(2,1))
        assertEquals(true, idTagEqualUseCase.execute(list))
    }

    @Test
    fun execute2() {
        val idTagEqualUseCase = IdTagEqualUseCase()
        val list = mutableListOf(CardNew(1,1), CardNew(2,2))
        assertEquals(false, idTagEqualUseCase.execute(list))
    }

    @Test
    fun execute3() {
        val idTagEqualUseCase = IdTagEqualUseCase()
        val list = mutableListOf(CardNew(1,1), CardNew(1,1))
        assertEquals(false, idTagEqualUseCase.execute(list))
    }

    @Test
    fun execute4() {
        val idTagEqualUseCase = IdTagEqualUseCase()
        val list = mutableListOf(CardNew(1,1))
        val expected = assertThrows(Exception::class.java, {idTagEqualUseCase.execute(list)})
        assertEquals("Solo puedes usar dos cartas",expected.message)
    }
}