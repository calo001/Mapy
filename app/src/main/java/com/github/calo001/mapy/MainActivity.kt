package com.github.calo001.mapy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.calo001.mapy.map.MapManager
import com.github.calo001.mapy.model.Coordinate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MapManager(
            fragment = R.id.map,
            coordinate = Coordinate(
                title = "México",
                snippet = "Viva México!",
                lat = 23.5540767,
                long = -102.6205,),
        ).loadMapAsync(supportFragmentManager)
    }
}