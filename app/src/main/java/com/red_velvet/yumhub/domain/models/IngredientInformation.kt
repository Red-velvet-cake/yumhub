package com.red_velvet.yumhub.domain.models

data class IngredientInformation(
    val id:Int?,
    val name :String?,
    val image:String?,
    val categoryPath:List<String>?,
    val nutrition:Nutrition?

)

data class Nutrition(
   val nutrients : List<Nutrients>?,
   val properties: List<Properties>?,
   val weightPerServing:WeightPerServing
)

data class  Nutrients(
    val amount:Double?,
    val percentOfDailyNeeds:Double?,
    val name :String?,
    val unit:String?,
)

data class  Properties(
    val amount:Double?,
    val name :String?,
    val unit:String?,
)

data class WeightPerServing(
    val amount:Double?,
    val unit:String?,
)