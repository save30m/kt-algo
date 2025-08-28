package dfs._1_search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun `샘플 케이스`() {
        val n = 4
        val edges = listOf(1 to 2, 1 to 3, 1 to 4, 2 to 4, 3 to 4)
        val start = 1
        val expected = listOf(1, 2, 4, 3)
        assertEquals(expected, dfsOrder(n, edges, start))
    }

    @Test
    fun `연결 요소가 분리된 경우`() {
        val n = 5
        val edges = listOf(1 to 2, 2 to 3, 4 to 5)
        val start = 4
        val expected = listOf(4, 5) // 1-2-3 컴포넌트는 방문하지 않음
        assertEquals(expected, dfsOrder(n, edges, start))
    }

    @Test
    fun `단일 노드`() {
        val n = 1
        val edges = emptyList<Pair<Int, Int>>()
        val start = 1
        val expected = listOf(1)
        assertEquals(expected, dfsOrder(n, edges, start))
    }

    @Test
    fun `이웃 정렬 규칙 확인`() {
        val n = 5
        val edges = listOf(1 to 3, 1 to 2, 1 to 5, 2 to 4)
        val start = 1
        val expected = listOf(1, 2, 4, 3, 5)
        assertEquals(expected, dfsOrder(n, edges, start))
    }

    @Test
    fun `중복 간선과 자기 루프가 있어도 무시되도록 구현해보세요`() {
        val n = 4
        val edges = listOf(1 to 2, 2 to 1, 1 to 1, 2 to 3, 3 to 4, 2 to 3) // 중복, 자기 루프 포함
        val start = 1
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, dfsOrder(n, edges, start))
    }
}