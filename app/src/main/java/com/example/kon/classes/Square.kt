package com.example.kon.classes

class Square(val x1: Int = 0, val y1: Int = 0, val x2: Int = 0, val y2: Int = 0, val a: Int = 0, val b: Int = 0, val x: Int = 0, val y: Int = 0) {
    fun s(): Double {
        if(a + b > 0)
            return (a * b).toDouble()
        return Math.abs(x1 - x2).toDouble() * Math.abs(y1 - y2)
    }

    fun p(): Double {
        if(a + b > 0)
            return 2.0 * (a + b)

        return 2.0 * (Math.abs(x1 - x2) + Math.abs(y1 - y2))
    }
}