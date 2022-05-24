package com.example.metromap.api

import com.example.metromap.service.MetroService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/metro")
class MetroController(private val service: MetroService) {

    @GetMapping("stations")
    fun getStations() = service.getStations()

    @GetMapping("edges")
    fun getEdges() = service.getEdges()

//    @GetMapping("path")
//    fun shortestPath(
//        @RequestParam from : String,
//        @RequestParam to : String
//    ) = service.shortestPath(from, to)

//    @GetMapping("{city}")
//    fun setCity(@PathVariable city:String) = service.setCity(city)

    @GetMapping("/{city}")
    fun getInfo(
        @PathVariable("city") city: String,
        @RequestParam("from") from: String,
        @RequestParam("to") to: String
    ): Array<String> = service.shortestPath(from, to, city)
}