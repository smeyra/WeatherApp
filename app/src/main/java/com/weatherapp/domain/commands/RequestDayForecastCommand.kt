package com.weatherapp.domain.commands

import com.weatherapp.domain.dataSource.ForecastProvider
import com.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}