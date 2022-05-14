package com.github.calo001.mapy.map

import androidx.fragment.app.FragmentManager
import com.github.calo001.mapy.model.Coordinate
import com.github.calo001.mapy.model.DEFAULT_ZOOM
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapManager(
    private val fragment: Int,
    private val coordinate: Coordinate,
): MapManagerInterface<GoogleMap> , OnMapReadyCallback {
    override fun onMapReady(map: GoogleMap) {
        moveCamera(map)
        addMarker(map)
    }

     override fun moveCamera(map: GoogleMap) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
            LatLng(
                coordinate.lat,
                coordinate.long,
            ),
            DEFAULT_ZOOM
        ))
    }

    override fun addMarker(map: GoogleMap) {
        val options = MarkerOptions()
            .position(LatLng(coordinate.lat, coordinate.long))
            .title(coordinate.title)
            .snippet(coordinate.snippet)

        map.addMarker(options)
    }

    override fun loadMapAsync(supportFragmentManager: FragmentManager) {
        val mapFragment = supportFragmentManager.findFragmentById(fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
}