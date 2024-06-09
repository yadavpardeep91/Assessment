package com.pardeep.assisment.data.product.remote.dataholders

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message") var message: String,
    @SerializedName("status") var status : Int
)
