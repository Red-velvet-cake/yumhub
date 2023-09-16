package com.red_velvet.yumhub.remote.resources.recipe

import com.google.gson.annotations.SerializedName

data class RecipesByRangeOfCaloriesResource(
 @SerializedName("id")
 val id: Int? = 0,
 @SerializedName("title")
 val title : String? = "",
 @SerializedName("image")
 val image: String? = "",
 @SerializedName("imageType")
 val imageType : String? = "",
 @SerializedName("calories")
 val calories: Double?= 0.0,
 @SerializedName("protein")
 val protein : String? = "",
 @SerializedName("fat")
 val fat: String? = "",
 @SerializedName("carbs")
 val carbs : String? = ""
)