package com.example.metromap.db

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface EdgeRepository : CrudRepository<Edge, Long> {
    override fun findAll(): ArrayList<Edge>

    @Modifying
    @Query("from Edge e where e.u.city = :city and e.v.city = :city")
    fun findAllByCity(@Param("city") city: String): ArrayList<Edge>

    fun save(edge: Edge): Edge
}