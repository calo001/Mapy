package com.github.calo001.mapy.model

const val DEFAULT_ZOOM = 4f

data class Coordinate(
    val lat: Double,
    val long: Double,
    val title: String,
    val snippet: String,
)