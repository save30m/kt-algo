package dfs._3_preorder

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
        //        10
        //       /  \
        //      5    20
        //     / \   /
        //    3   7 15
        val tree = Node(
            10,
            left = Node(5, left = Node(3), right = Node(7)),
            right = Node(20, left = Node(15))
        )
        val expected = listOf(10, 5, 3, 7, 20, 15)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `왼쪽 체인만 있는 트리`() {
        // 1 -> 2 -> 3 -> 4 (모두 left)
        val tree = Node(1,
            left = Node(2,
                left = Node(3,
                    left = Node(4)
                )
            )
        )
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `오른쪽 체인만 있는 트리`() {
        // 1 -> 2 -> 3 (모두 right)
        val tree = Node(1,
            right = Node(2,
                right = Node(3)
            )
        )
        val expected = listOf(1, 2, 3)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `빈 트리`() {
        val tree: Node? = null
        val expected = emptyList<Int>()
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `불균형 트리 - 왼쪽에만 자식 일부`() {
        //      8
        //     /
        //    4
        //     \
        //      6
        val tree = Node(8,
            left = Node(4, right = Node(6))
        )
        val expected = listOf(8, 4, 6)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `불균형 트리 - 양쪽 섞임`() {
        //        1
        //       / \
        //      2   3
        //         /
        //        4
        //         \
        //          5
        val tree = Node(1,
            left = Node(2),
            right = Node(3,
                left = Node(4, right = Node(5))
            )
        )
        val expected = listOf(1, 2, 3, 4, 5)
        assertEquals(expected, preorderDfs(tree))
    }
}
