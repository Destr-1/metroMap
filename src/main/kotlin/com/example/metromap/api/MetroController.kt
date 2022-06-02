package com.example.metromap.api

import com.example.metromap.db.CityDTO
import com.example.metromap.db.EdgeDTO
import com.example.metromap.db.StationDTO
import com.example.metromap.service.MetroService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/metro")
class MetroController(private val service: MetroService) {

    @GetMapping("stations")
    fun getStations() = service.getStations()

    @GetMapping("edges")
    fun getEdges() = service.getEdges()

    @GetMapping("/cities")
    fun getCities() = service.getCities()

    @GetMapping("/{city}")
    fun getInfo(
        @PathVariable("city") city: String,
        @RequestParam("from") from: String,
        @RequestParam("fromColor") fromColor: Int,
        @RequestParam("to") to: String,
        @RequestParam("toColor") toColor: Int,
    ): Array<String> = service.shortestPath(from, fromColor, to, toColor, city)

    @PostMapping("/add-station")
    fun addStation(
        @RequestBody stationDTO: StationDTO
    ) = service.addStation(stationDTO)

    @PostMapping("/add-edge")
    fun addStation(
        @RequestBody edgeDTO: EdgeDTO
    ) = service.addEdge(edgeDTO)

    @PostMapping("/add-city")
    fun addCity(
        @RequestBody cityDTO: CityDTO
    ) = service.addCity(cityDTO)
}