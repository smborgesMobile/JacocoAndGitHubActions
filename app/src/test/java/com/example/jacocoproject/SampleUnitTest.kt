package com.example.jacocoproject

import org.junit.Test
import org.junit.Assert.*


class SampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun countText() {
        val sampleText = TextMethods.countText("banananana")
        assertTrue(sampleText > 4)
    }

    @Test
    fun capitalizeText() {
        val upperCaseText = TextMethods.capitalizeText("banana")
        assertEquals("BANANA", upperCaseText)
    }
}