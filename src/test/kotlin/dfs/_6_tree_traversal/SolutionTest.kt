package dfs._6_tree_traversal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class Node(
    val value: Int,
    val children: List<Node> = emptyList()
)

class SolutionTest {

    @Test
    fun `샘플 트리`() {
        val tree = Node(
            1,
            children = listOf(
                Node(2),
                Node(3, children = listOf(Node(5), Node(6))),
                Node(4)
            )
        )
        val expected = listOf(1, 2, 3, 5, 6, 4)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `단일 노드`() {
        val tree = Node(1)
        val expected = listOf(1)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `빈 트리`() {
        val tree: Node? = null
        val expected = emptyList<Int>()
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `균형 잡힌 2계층 트리`() {
        val tree = Node(
            10,
            children = listOf(
                Node(20),
                Node(30),
                Node(40)
            )
        )
        val expected = listOf(10, 20, 30, 40)
        assertEquals(expected, preorderDfs(tree))
    }

    @Test
    fun `깊은 트리`() {
        // 1 -> 2 -> 3 -> 4 (체인)
        val tree = Node(
            1,
            children = listOf(
                Node(2, children = listOf(
                    Node(3, children = listOf(
                        Node(4)
                    ))
                ))
            )
        )
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, preorderDfs(tree))
    }
}
