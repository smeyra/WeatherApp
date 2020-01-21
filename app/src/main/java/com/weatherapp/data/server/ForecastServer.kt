package com.weatherapp.data.server

import com.weatherapp.data.db.ForecastDb
import com.weatherapp.domain.dataSource.ForecastDataSource
import com.weatherapp.domain.model.ForecastList
import java.lang.UnsupportedOperationException

class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()): ForecastDataSource {

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

}