package com.example.metromap.service


interface Shortest {
    fun shortest(start: Int, finish: Int, city:String): IntArray

}