package com.example.metromap.db

import javax.persistence.*

@Table(name = "cities")
@Entity
@SequenceGenerator(allocationSize = 1, name="city_seq", sequenceName = "city_seq")
data class City (
    @Id
    @GeneratedValue(generator = "city_seq")
    @Column(name="id")
    var id: Int,

    @Column(name = "city")
    var city: String,
)