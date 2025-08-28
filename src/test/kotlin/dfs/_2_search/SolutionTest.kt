package dfs._2_search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null,
)

class DfsTreeTest {

    @Test
    fun `샘플 트리`() {
        val tree = Node(1,
            left = Node(2),
            right = Node(3,
                left = Node(4),
                right = Node(5)
            )
        )

        val expected = listOf(1, 2, 3, 4, 5)
        assertEquals(expected, dfsTree(tree))
    }

    @Test
    fun `왼쪽만 있는 트리`() {
        val tree = Node(1,
            left = Node(2,
                left = Node(3)
            )
        )

        val expected = listOf(1, 2, 3)
        assertEquals(expected, dfsTree(tree))
    }

    @Test
    fun `오른쪽만 있는 트리`() {
        val tree = Node(1,
            right = Node(2,
                right = Node(3)
            )
        )

        val expected = listOf(1, 2, 3)
        assertEquals(expected, dfsTree(tree))
    }

    @Test
    fun `빈 트리`() {
        val tree: Node? = null
        val expected = emptyList<Int>()

        assertEquals(expected, dfsTree(tree))
    }

    @Test
    fun `왼쪽과 오른쪽이 섞인 비균형 트리`() {
        val tree = Node(10,
            left = Node(5,
                right = Node(7)
            ),
            right = Node(20,
                left = Node(15)
            )
        )
        // 전위 순회: 현재 → 왼쪽 → 오른쪽
        val expected = listOf(10, 5, 7, 20, 15)
        assertEquals(expected, dfsTree(tree))
    }

    @Test
    fun `깊은 트리`() {
        // 1 -> 2 -> 3 -> 4 -> 5 (전부 왼쪽)
        val tree = Node(1,
            left = Node(2,
                left = Node(3,
                    left = Node(4,
                        left = Node(5)
                    )
                )
            )
        )
        val expected = listOf(1, 2, 3, 4, 5)
        assertEquals(expected, dfsTree(tree))
    }
}
