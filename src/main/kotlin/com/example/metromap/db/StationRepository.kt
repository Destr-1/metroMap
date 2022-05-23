package com.example.metromap.db

import org.springframework.data.repository.CrudRepository

interface StationRepository :CrudRepository<Station, Long> {

    override fun findAll(): ArrayList<Station>

    fun findById(id:Int):Station

    fun findByStationAndCity(station:String, city:String):Station
}