package com.example.metromap.db

import javax.persistence.*

@Table(name = "edges")
@Entity
@SequenceGenerator(allocationSize = 1, name="edge_seq", sequenceName = "edge_seq")
data class Edge (
    @Id
    @GeneratedValue(generator = "edge_seq")
    @Column(name="id")
    var id: Int,

//    @Column(name = "u")
//    var u:Int,
    @ManyToOne
    @JoinColumn(name= "u")
    var u : Station,

//    @Column(name = "v")
//    var v:Int,
    @ManyToOne
    @JoinColumn(name="v")
    var v : Station,

    @Column(name = "weight")
    var weight : Int


//    @Column(name = "city")
//    var city:String
)
