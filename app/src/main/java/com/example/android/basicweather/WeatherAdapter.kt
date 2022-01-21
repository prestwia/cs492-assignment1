package com.example.android.basicweather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter (val weathers: List<Weather>, private val onItemClicked: (position: Int, weather: Weather) -> Unit) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun getItemCount() = this.weathers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)

        return ViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.weathers[position])
    }



    inner class ViewHolder(view: View, private val onItemClicked: (position: Int, weather: Weather) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val monthTV: TextView = view.findViewById(R.id.weather_month)
        private val dayTV: TextView = view.findViewById(R.id.weather_day)
        private val textTV: TextView = view.findViewById(R.id.weather_text)
        private val lowTV: TextView = view.findViewById(R.id.daily_low)
        private val precipitationTV: TextView = view.findViewById(R.id.precip_percent)
        private val highTV: TextView = view.findViewById(R.id.daily_high)

        fun bind(weather: Weather) {
            this.monthTV.text = weather.month
            this.dayTV.text = weather.day.toString()
            this.textTV.text = weather.text
            this.lowTV.text = weather.low
            this.precipitationTV.text = weather.precipitation
            this.highTV.text = weather.high
        }

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            val weather = weathers[position]
            onItemClicked(position, weather)
            }
        }

}