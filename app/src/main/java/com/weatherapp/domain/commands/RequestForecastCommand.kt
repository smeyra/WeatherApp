package com.weatherapp.domain.commands

import com.weatherapp.domain.dataSource.ForecastProvider
import com.weatherapp.domain.model.ForecastList



class RequestForecastCommand(private val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()):
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}