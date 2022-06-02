package com.example.metromap.service

import com.example.metromap.db.Edge
import com.example.metromap.db.EdgeRepository
import org.springframework.stereotype.Component
import java.lang.Integer.max

@Component
class EdgeClient(private val repository: EdgeRepository) {
    val inf = 1000000

    fun addEdge(edge:Edge) = repository.save(edge)

    fun getEdges(): ArrayList<Edge> = repository.findAll()
    fun getEdgesArrayByCity(city:String) : ArrayList<Edge> = repository.findAllByCity(city)

    fun getMatrix(city:String): Array<IntArray> {
        val edgesList = getEdgesArrayByCity(city)
        var n = 0
        for (edge in edgesList) {
            n = max(n, max(edge.u.id, edge.v.id))
        }
        val a: Array<IntArray> = Array(n + 1, { IntArray(n + 1, { inf }) })
        for (edge in edgesList) {
            val u = edge.u.id
            val v = edge.v.id
            val w = edge.weight
            a[v][u] = w
            a[u][v] = w
        }
        for(i in a.indices)
            a[i][i] = 0
        return a
    }
}