package com.example.metromap.service

import org.springframework.stereotype.Component

@Component
class Floyd(client: EdgeClient, cityClient: CityClient) : Shortest {
    private final val d = cityClient.getCities().map{it.city}
    private final val a = d.associateWith { client.getMatrix(it) }

    //        client.getMatrix()
    private final val n = a.size
    var prev: Array<IntArray> = Array(n, { IntArray(n, { -1 }) })
    val prevMap : MutableMap<String, Array<IntArray>> = mutableMapOf()
    var distMap = a.toMutableMap()
    var dist : Array<IntArray> = Array(n) { IntArray(n) }

    init {
        for(item in a.keys){
            dist = distMap[item]!!
            prev = Array(n, { IntArray(n, { -1 }) })
            floyd()
            distMap[item] = dist
            prevMap[item] = prev
        }
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


    override fun shortest(start: Int, finish: Int, city: String): IntArray {
        val path: ArrayList<Int> = arrayListOf()
        var curr = finish
        val prev = prevMap[city]!!
        while (curr != start) {
            path.add(curr)
            curr = prev[start][curr]
        }
        path.add(start)
        return path.reversed().toIntArray()
    }

}