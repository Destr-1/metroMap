package com.example.metromap.db

import org.springframework.data.repository.CrudRepository

interface CityRepository :CrudRepository<City, Long> {
    override fun findAll(): ArrayList<City>

    fun save(city: City): City

}