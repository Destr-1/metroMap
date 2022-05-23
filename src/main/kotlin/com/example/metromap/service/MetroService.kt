package com.example.metromap.service

import org.springframework.stereotype.Service

@Service
class MetroService(
    private val stationClient: StationClient,
    private val edgeClient: EdgeClient,
    private val floyd: Floyd
) {

    fun getStations() = stationClient.getStationArray()

    fun getEdges() = edgeClient.getEdgesArray()

    fun shortestPath(from: String, to: String): Array<String> {
        val start: Int = stationClient.getStation(from).id
        val finish: Int = stationClient.getStation(to).id
        val dist = floyd.dist
        val pathInt = floyd.shortest(start, finish)
        val n = pathInt.size
        val pathString: ArrayList<String> = ArrayList()
        val pathColor: ArrayList<Int> = ArrayList()
        val stations = getStations()
        for (i in pathInt) {
            for (station in stations) {
                if (station.id == i) {
                    pathString.add(station.station)
                    pathColor.add(station.color)
                    break
                }
            }
        }
        val pS: ArrayList<String> = ArrayList()
        pS.add(pathString[0])
        var currentColor = pathColor[0]
        var i = 0
        var curr = 0
        while (i < n) {
//            var currentStation: String = pathString[i]
            while (i < n && pathColor[i] == currentColor) {
                i++
            }
            if (pathString[i - 1] != pathString[curr]) {
                var s ="станций"
                if(i-1-curr ==1)
                    s="станцию"
                if(i-1-curr in 2..4)
                    s = "станции"
                pS.add("ехать ${i - curr - 1} $s в течение ${dist[pathInt[i - 1]][pathInt[curr]]} минут до станции")
                pS.add(pathString[i - 1])
            }
            if (i < n) {

                pS.add("Переход в течение ${dist[pathInt[i - 1]][pathInt[i]]} минут на станцию")

                pS.add(pathString[i])
                currentColor = pathColor[i]
                curr = i
            }
        }
        var s="минут"
        val time = dist[start][finish]
        if( time % 10 == 1 && time != 11)
            s = "минута"
        if(time % 10 in 2..4 && time !in 12..14)
            s = "минуты"
        pS.add(0, "Общее время поездки: ${dist[start][finish]} $s")
        pS.add(1, "Маршрут:")
        return pS.toTypedArray()
    }

}