package com.example.metromap.service

import com.example.metromap.db.StationRepository
import org.springframework.stereotype.Component

@Component
class StationClient(private val repository: StationRepository) {
    fun getStationArray() = repository.findAll()
    fun getStationByID(id:Int) = repository.findById(id)
//    fun getStationByCity(city: String) = repository.findByCity(city)

    fun getStation(station:String, city : String) = repository.findByStationAndCity(station, city)

}