package com.example.metromap.service

import com.example.metromap.db.Edge
import com.example.metromap.db.EdgeRepository
import org.springframework.stereotype.Component
import java.lang.Integer.max

@Component
class EdgeClient(private val repository: EdgeRepository) {
    val inf = 1000000

    fun getEdgesArray(): ArrayList<Edge> = repository.findAll()

    fun getMatrix(): Array<IntArray> {
        val edgesList = getEdgesArray()
        var n = 0
        for (edge in edgesList) {
            n = max(n, max(edge.u, edge.v))
        }
        val a: Array<IntArray> = Array(n + 1, { IntArray(n + 1, { inf }) })
        for (edge in edgesList) {
            val u = edge.u
            val v = edge.v
            val w = edge.weight
            a[v][u] = w
            a[u][v] = w
        }
        for(i in a.indices)
            a[i][i] = 0
        return a
    }
}