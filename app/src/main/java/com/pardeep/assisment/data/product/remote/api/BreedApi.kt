package com.pardeep.assisment.data.product.remote.api

import com.pardeep.assisment.data.product.remote.dataholders.DogResponse
import com.pardeep.assisment.data.common.utils.WrappedResponse
import retrofit2.Response
import retrofit2.http.GET

interface BreedApi {
    @GET("breeds/image/random")
    fun getRandomBreedImage(): Response<WrappedResponse<DogResponse>>

}