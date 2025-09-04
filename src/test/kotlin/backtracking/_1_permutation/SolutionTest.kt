package backtracking._1_permutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {

    @Test
    fun `n=1`() {
        val nums = listOf(7)
        val expected = listOf(listOf(7))
        assertEquals(expected, permutations(nums))
    }

    @Test
    fun `n=2`() {
        val nums = listOf(1, 2)
        val expected = listOf(
            listOf(1, 2),
            listOf(2, 1),
        )
        assertEquals(expected, permutations(nums))
    }

    @Test
    fun `n=3 in lexicographic order`() {
        val nums = listOf(1, 2, 3)
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1),
        )
        assertEquals(expected, permutations(nums))
    }

    @Test
    fun `unsorted input should still return lexicographic order`() {
        val nums = listOf(3, 1, 2)
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1),
        )
        assertEquals(expected, permutations(nums))
    }

    @Test
    fun `includes negatives and zeros`() {
        val nums = listOf(-1, 0, 1)
        val expected = listOf(
            listOf(-1, 0, 1),
            listOf(-1, 1, 0),
            listOf(0, -1, 1),
            listOf(0, 1, -1),
            listOf(1, -1, 0),
            listOf(1, 0, -1),
        )
        assertEquals(expected, permutations(nums))
    }
}
