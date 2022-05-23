package com.example.metromap.service

import org.springframework.stereotype.Component

@Component
class Floyd(client: EdgeClient) : Shortest {
    final val a = client.getMatrix()
    final val n = a.size
    val prev: Array<IntArray> = Array(n, { IntArray(n, { -1 }) })
    var dist = a

    init {
        floyd()
    }

    //    companion object
    private fun floyd() {
        val inf = 1000000
        val n = dist.size
        for (i in 1 until n)
            for (j in 1 until n) {
                if (dist[i][j] < inf) {
                    prev[i][j] = i
                }
            }

        for (k in 1 until n)
            for (i in 1 until n)
                for (j in 1 until n) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]
                        prev[i][j] = prev[k][j]
                    }
                }
    }


    override fun shortest(start: Int, finish: Int): IntArray {
        val path: ArrayList<Int> = arrayListOf()
        var curr = finish
        while (curr != start) {
            path.add(curr)
            curr = prev[start][curr]
        }
        path.add(start)
        return path.reversed().toIntArray()
    }

}