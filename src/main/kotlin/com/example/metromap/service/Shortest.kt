package com.example.metromap.service


interface Shortest {
    fun shortest(start: Int, finish: Int): IntArray

}