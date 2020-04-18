package com.devfk.ma.screeningapp.data.Model


import com.google.gson.annotations.SerializedName

data class Guest(
    val ad: Ad,
    val `data`: List<DataGuest>,
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)