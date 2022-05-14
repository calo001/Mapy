package com.github.calo001.mapy.map

import androidx.fragment.app.FragmentManager

interface MapManagerInterface <M> {
    fun addMarker(map: M)
    fun moveCamera(map: M)
    fun loadMapAsync(supportFragmentManager: FragmentManager)
}