package com.example.android.basicweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jan1 = Weather("Jan",
            1,
            "Mostly sunny",
            "45°F",
            "25% precip.",
            "60°F",
            "Mostly sunny with a chance of sporadic showers in the evening")

        val jan2 = Weather("Jan",
            2,
            "Light Showers",
            "48°F",
            "60% precip.",
            "62°F",
            "Light showers in the morning")

        val jan3 = Weather("Jan",
            3,
            "Mostly cloudy",
            "42°F",
            "10% precip.",
            "58°F",
            "AM cloud cover with chance of sun in the afternoon")

        val jan4 = Weather("Jan",
            4,
            "Moderate clouds",
            "37°F",
            "0% precip.",
            "48°F",
            "Morning sun giving way to heavier cloud cover")

        val jan5 = Weather("Jan",
            5,
            "Moderate clouds",
            "34°F",
            "10% precip.",
            "48°F",
            "Morning sun and cloud cover expect cooler temperatures in the evening")

        val jan6 = Weather("Jan",
            6,
            "Light Showers",
            "35°F",
            "70% precip.",
            "52°F",
            "Morning clouds with sporadic light showers")

        val jan7 = Weather("Jan",
            7,
            "Moderate Showers",
            "42°F",
            "80% precip.",
            "59°F",
            "Rain will continue through the day with periodic breaks in the AM")

        val jan8 = Weather("Jan",
            8,
            "Heavy Showers",
            "44°F",
            "100% precip.",
            "58°F",
            "Heavy rain will continue through the day")

        val jan9 = Weather("Jan",
            9,
            "Heavy Showers",
            "38°F",
            "100% precip.",
            "52°F",
            "Heavy rain will continue through the day")

        val jan10 = Weather("Jan",
            10,
            "Mostly sunny",
            "38°F",
            "20% precip.",
            "52°F",
            "Chance of showers in AM with clear skies in the afternoon")

        val jan11 = Weather("Jan",
            11,
            "Moderate clouds",
            "45°F",
            "30% precip.",
            "64°F",
            "Moderate cloud cover throughout the day with small chance of light showers")

        val jan12 = Weather("Jan",
            12,
            "Sunny",
            "52°F",
            "0% precip.",
            "68°F",
            "Sunny with chance of increasing clouds in the evening")

        val jan13 = Weather("Jan",
            13,
            "Mostly sunny",
            "54°F",
            "0% precip.",
            "69°F",
            "Sunny with moderate cloud cover")

        val jan14 = Weather("Jan",
            14,
            "Mostly sunny",
            "49°F",
            "0% precip.",
            "70°F",
            "Mostly sunny with temperature dropping in the evening")

        val weathers: List<Weather> = listOf(jan1, jan2, jan3, jan4, jan5, jan6, jan7, jan8, jan9, jan10, jan11, jan12, jan13, jan14)

        val weatherListRV = findViewById<RecyclerView>(R.id.rv_weather_list)
        val layoutManager = LinearLayoutManager(this)
        val coordinatorLayout = findViewById<CoordinatorLayout>(R.id.coordinator_layout)
        weatherListRV.layoutManager = layoutManager
        weatherListRV.setHasFixedSize(true)

        fun onListItemClick(position: Int, weather: Weather) {
            Snackbar.make(
                coordinatorLayout,
                "${weather.message}",
                Snackbar.LENGTH_LONG
            ).show()
        }

        val adapter = WeatherAdapter(weathers) { position, weather -> onListItemClick(position, weather) }
        weatherListRV.adapter = adapter

        weatherListRV.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                layoutManager.orientation
            )
        )
    }
}