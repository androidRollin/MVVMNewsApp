package com.androiddevs.mvvmnewsapp.ui.api

import com.androiddevs.mvvmnewsapp.ui.models.NewsResponse
import com.androiddevs.mvvmnewsapp.ui.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    //url part that we want to get something from
    //
    @GET("v2/top-headlines")
    //funct to great a breaking news, asynchronously
    //coroutines
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "ph",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    //funct to great a breaking news, asynchronously
    //coroutines
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>

}