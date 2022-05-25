package com.example.metromap.db

data class EdgeDTO(
    val uStationDTO: StationDTO,
    val vStationDTO: StationDTO,
    val weight: Int
)
