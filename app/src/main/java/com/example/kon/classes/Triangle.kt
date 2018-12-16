package com.example.kon.classes


class Triangle(val a: Int, val b: Int, val c: Int, val x: Int = 0, val y: Int = 0) {
    fun s(): Double {
        return Math.sqrt(p()/2 * (p()/2 - a) * (p()/2 - b) * (p()/2 - c))
    }
    fun p(): Double {
        return (a + b + c).toDouble()
    }
}