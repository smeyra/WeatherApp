package com.weatherapp.domain.dataSource

import com.weatherapp.domain.model.Forecast
import com.weatherapp.domain.model.ForecastList

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}