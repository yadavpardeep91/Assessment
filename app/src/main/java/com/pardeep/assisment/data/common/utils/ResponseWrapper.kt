package com.pardeep.assisment.data.common.utils

import com.google.gson.annotations.SerializedName


data class WrappedResponse<T> (
    var code: Int,
    @SerializedName("message") var message : String,
    @SerializedName("status") var status : Boolean,
    @SerializedName("errors") var errors : List<String>? = null,
    @SerializedName("data") var data : T? = null
)