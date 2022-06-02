package com.example.metromap.db

import javax.persistence.*

@Table(name = "stations")
@Entity
@SequenceGenerator(allocationSize = 1, name="station_seq", sequenceName = "station_seq")
data class Station (
    @Id
    @GeneratedValue(generator = "station_seq")
    @Column(name="id")
    var id: Int,

    @Column(name = "station")
    var station: String,

    @Column(name = "color")
    var color:Int,

    @Column(name = "city")
    var city:String
)