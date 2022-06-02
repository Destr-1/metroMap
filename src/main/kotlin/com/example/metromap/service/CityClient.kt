package com.example.metromap.service

import com.example.metromap.db.City
import com.example.metromap.db.CityRepository
import org.springframework.stereotype.Component

@Component
class CityClient(private val repository: CityRepository) {

    fun getCities() : ArrayList<City> = repository.findAll()

    fun addCity(city: City) = repository.save(city)
}