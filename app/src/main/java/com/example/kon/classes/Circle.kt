package com.example.kon.classes


class Circle(val r: Int, val x: Int = 0, val y: Int = 0) {
    fun s(): Double {
        return Math.PI * r * r
    }
    fun p(): Double {
        return 2 * Math.PI * r
    }

}