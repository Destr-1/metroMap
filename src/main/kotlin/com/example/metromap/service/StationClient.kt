package com.example.metromap.service

import com.example.metromap.db.Station
import com.example.metromap.db.StationDTO
import com.example.metromap.db.StationRepository
import org.springframework.stereotype.Component

@Component
class StationClient(private val repository: StationRepository) {
    fun getStations() = repository.findAll()
    fun getStationByID(id: Int) = repository.findById(id)

    fun getStation(station: String, color: Int, city: String) =
        repository.findByStationAndCityAndColor(station = station, city = city, color = color)

    fun addStation(station: Station) = repository.save(station)


}