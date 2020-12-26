package karate_chop

import com.code_kata.karate_chop.KarateChop.Companion.iteratorChop
import org.junit.Test
import kotlin.test.assertEquals

class KarateChopTest {
    @Test
    fun testIteratorChop() {
        chop(::iteratorChop)
    }

    /**
     * refer a chop function passed as argument and execute that
     */
    private fun chop(chopFunction: (Int, List<Int>) -> Int) {
        assertEquals(-1, chopFunction(3, listOf()))
        assertEquals(-1, chopFunction(3, listOf(1)))
        assertEquals(0,  chopFunction(1, listOf(1)))

        assertEquals(0,  chopFunction(1, listOf(1, 3, 5)))
        assertEquals(1,  chopFunction(3, listOf(1, 3, 5)))
        assertEquals(2,  chopFunction(5, listOf(1, 3, 5)))
        assertEquals(-1, chopFunction(0, listOf(1, 3, 5)))
        assertEquals(-1, chopFunction(2, listOf(1, 3, 5)))
        assertEquals(-1, chopFunction(4, listOf(1, 3, 5)))
        assertEquals(-1, chopFunction(6, listOf(1, 3, 5)))

        assertEquals(0,  chopFunction(1, listOf(1, 3, 5, 7)))
        assertEquals(1,  chopFunction(3, listOf(1, 3, 5, 7)))
        assertEquals(3,  chopFunction(7, listOf(1, 3, 5, 7)))
        assertEquals(2,  chopFunction(5, listOf(1, 3, 5, 7)))
        assertEquals(-1, chopFunction(0, listOf(1, 3, 5, 7)))
        assertEquals(-1, chopFunction(2, listOf(1, 3, 5, 7)))
        assertEquals(-1, chopFunction(8, listOf(1, 3, 5, 7)))
        assertEquals(-1, chopFunction(4, listOf(1, 3, 5, 7)))
        assertEquals(-1, chopFunction(6, listOf(1, 3, 5, 7)))
    }
}