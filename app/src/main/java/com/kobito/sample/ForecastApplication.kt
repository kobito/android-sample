package com.kobito.sample

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import com.kobito.sample.data.db.ForecastDatabase
import com.kobito.sample.data.network.ApixuWeatherApiService
import com.kobito.sample.data.network.ConnectivityInterceptor
import com.kobito.sample.data.network.ConnectivityInterceptorImpl
import com.kobito.sample.data.network.WeatherNetworkDataSource
import com.kobito.sample.data.network.WeatherNetworkDataSourceImpl
import com.kobito.sample.data.provider.LocationProvider
import com.kobito.sample.data.provider.LocationProviderImpl
import com.kobito.sample.data.provider.UnitProvider
import com.kobito.sample.data.provider.UnitProviderImpl
import com.kobito.sample.data.repository.ForecastRepository
import com.kobito.sample.data.repository.ForecastRepositoryImpl
import com.kobito.sample.ui.weather.current.CurrentWeatherViewModelFactory
import com.kobito.sample.ui.weather.future.detail.FutureDetailWeatherViewModelFactory
import com.kobito.sample.ui.weather.future.list.FutureListWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.factory
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import org.threeten.bp.LocalDate

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().futureWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton {
            ForecastRepositoryImpl(
                instance(),
                instance(),
                instance(),
                instance(),
                instance()
            )
        }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
        bind() from factory { detailDate: LocalDate ->
            FutureDetailWeatherViewModelFactory(
                detailDate,
                instance(),
                instance())
        }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}