package com.aj.bindablerecyclerview.network.di

import com.aj.bindablerecyclerview.network.ApiException
import com.aj.bindablerecyclerview.network.WEATHER_BASE_URL
import com.aj.bindablerecyclerview.network.WeatherApiService
import com.google.gson.GsonBuilder
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    private fun getOkHttpResponse(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        when (response.code) {
            400 -> throw ApiException.BadRequest()
            401 -> throw ApiException.UnauthorizedRequest()
            403 -> throw ApiException.Forbidden()
            404 -> throw ApiException.ResourceNotFound()
            405 -> throw ApiException.MethodNotAllowed()
            406 -> throw ApiException.NotAcceptable()
            408 -> throw ApiException.RequestTimeout()
            409 -> throw ApiException.NoConnectivityException()
            500 -> throw ApiException.ServerError()
        }
        return response
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val requestInterceptor =
            Interceptor { chain ->
                val url =
                    chain
                        .request()
                        .url
                        .newBuilder()
                        .build()
                val request =
                    chain.request().newBuilder().url(url).build()
                return@Interceptor chain.proceed(request)
            }
        val responseInterceptor = Interceptor { return@Interceptor getOkHttpResponse(it) }

        val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(responseInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesGson():GsonConverterFactory{
        val builder = GsonBuilder().disableHtmlEscaping().create()
        return GsonConverterFactory.create(builder)
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): WeatherApiService {
        return Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(WeatherApiService::class.java)
    }
}