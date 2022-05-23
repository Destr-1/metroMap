package com.example.metromap.api

import com.example.metromap.service.MetroService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/metro")
class MetroController(private val service: MetroService) {

    @GetMapping("stations")
    fun getStations() = service.getStations()

    @GetMapping("edges")
    fun getEdges() = service.getEdges()

    @GetMapping("path")
    fun shortestPath(
        @RequestParam from : String,
        @RequestParam to : String
    ) = service.shortestPath(from, to)
}