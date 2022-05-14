package com.github.calo001.mapy.map

import androidx.fragment.app.FragmentManager
import com.github.calo001.mapy.model.Coordinate
import com.github.calo001.mapy.model.DEFAULT_ZOOM
import com.huawei.hms.maps.CameraUpdateFactory
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.OnMapReadyCallback
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.MarkerOptions

class MapManager(
    private val fragment: Int,
    private val coordinate: Coordinate,
): MapManagerInterface<HuaweiMap>, OnMapReadyCallback {
    override fun onMapReady(map: HuaweiMap) {
        moveCamera(map)
        addMarker(map)
    }

    override fun addMarker(map: HuaweiMap) {
        val options = MarkerOptions()
            .position(LatLng(coordinate.lat, coordinate.long))
            .title(coordinate.title)
            .snippet(coordinate.snippet)

        map.addMarker(options)
    }

    override fun moveCamera(map: HuaweiMap) {
        map.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    coordinate.lat,
                    coordinate.long,
                ),
                DEFAULT_ZOOM
            )
        )
    }

    override fun loadMapAsync(supportFragmentManager: FragmentManager) {
        val mapFragment = supportFragmentManager.findFragmentById(fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
}