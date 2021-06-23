package com.randy.bajp2.models.repository.remote

import com.google.gson.annotations.SerializedName

data class ItemResponse (
    @SerializedName("results")
    val results: List<ItemList>
)