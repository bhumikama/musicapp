package com.ltts.musicplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {



    @Headers("X-RapidAPI-Key: fd27c42283msha19aaee05c11b77p17d3d6jsn57c548abbe25",
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getAllData(@Query("q")query: String ) : Call<MyData>


}