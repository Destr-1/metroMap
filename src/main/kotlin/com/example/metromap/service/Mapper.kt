package com.example.metromap.service

import com.example.metromap.db.*
import org.springframework.stereotype.Component

@Component
class Mapper(private val repository: StationRepository) {

    //    companion object {
    fun DTOtoStation(stationDTO: StationDTO) =
        Station(id = 0, station = stationDTO.station, color = stationDTO.color, city = stationDTO.city)

    fun DTOtoEdge(edgeDTO: EdgeDTO): Edge {
        val uStationDTO = edgeDTO.uStationDTO
        val vStationDTO = edgeDTO.vStationDTO
        val w = edgeDTO.weight
        val uStation: Station =
            repository.findByStationAndCityAndColor(uStationDTO.station, uStationDTO.city, uStationDTO.color)
        val vStation: Station =
            repository.findByStationAndCityAndColor(vStationDTO.station, vStationDTO.city, vStationDTO.color)
        return Edge(id = 0, u = uStation, v = vStation, weight = w)
    }

    fun DTOtoCity(cityDTO: CityDTO) = City(id = 0, city = cityDTO.city)


}