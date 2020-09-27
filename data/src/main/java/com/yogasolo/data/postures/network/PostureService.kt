package com.yogasolo.data.postures.network

import com.yogasolo.data.postures.network.model.ApiPosture
import retrofit2.Call
import retrofit2.http.GET

interface PostureService {

    companion object {
        private const val GET_POSTURES = "Slyrand/mobile-coding-challenge/postures"
    }

    @GET(GET_POSTURES)
    fun getPostures(
    ): Call<List<ApiPosture>>
}