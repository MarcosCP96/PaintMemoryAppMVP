package com.example.paintmemoryappfragmentsmvp.useCase

import com.example.paintmemoryappfragmentsmvp.models.CardNew
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class IdTagEqualUseCaseTest {

    @Test
    fun execute() {
        val idTagEqualUseCase: IdTagEqualUseCase = mock()
        val idTagEqualUseCase2 = IdTagEqualUseCase()
        val list = mutableListOf(CardNew(1,1), CardNew(2,1))
        idTagEqualUseCase.execute(list)
        verify(idTagEqualUseCase).execute(list)
        assertEquals(true, idTagEqualUseCase2.execute(list))
    }
}