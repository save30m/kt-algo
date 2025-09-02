package dfs._4_inorder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null,
)

class SolutionTest {

    @Test
    fun `샘플 트리`() {
        val tree = Node(
            10,
            left = Node(5, left = Node(3), right = Node(7)),
            right = Node(20, left = Node(15))
        )
        val expected = listOf(3, 5, 7, 10, 15, 20)
        assertEquals(expected, inorderDfs(tree))
    }

    @Test
    fun `왼쪽 체인만 있는 트리`() {
        val tree = Node(4,
            left = Node(3,
                left = Node(2,
                    left = Node(1)
                )
            )
        )
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, inorderDfs(tree))
    }

    @Test
    fun `오른쪽 체인만 있는 트리`() {
        val tree = Node(1,
            right = Node(2,
                right = Node(3,
                    right = Node(4)
                )
            )
        )
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, inorderDfs(tree))
    }

    @Test
    fun `빈 트리`() {
        val tree: Node? = null
        val expected = emptyList<Int>()
        assertEquals(expected, inorderDfs(tree))
    }

    @Test
    fun `불균형 트리`() {
        //      8
        //     /
        //    4
        //     \
        //      6
        val tree = Node(8,
            left = Node(4, right = Node(6))
        )
        val expected = listOf(4, 6, 8)
        assertEquals(expected, inorderDfs(tree))
    }
}
