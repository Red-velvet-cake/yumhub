package com.red_velvet.yumhub.domain.mapper

import com.red_velvet.yumhub.data.remote.dtos.recipe.RecipeInformationDto
import com.red_velvet.yumhub.domain.models.recipes.RecipeInformation

fun RecipeInformationDto.toModel(): RecipeInformation {

    return RecipeInformation(
        id = this.id ?: 0,
        image = this.image ?: "",
        imageType = this.imageType ?: "",
        instructions = this.instructions ?: "",
        preparationMinutes = this.preparationMinutes ?: 0,
        pricePerServing = this.pricePerServing ?: 0.0,
        readyInMinutes = this.readyInMinutes ?: 0,
        servings = this.servings ?: 0,
        summary = this.summary ?: "",
        title = this.title ?: "",
        analyzedInstructions = this.analyzedInstructions ?: null,
        cheap = this.cheap ?: null,
        cookingMinutes = this.cookingMinutes ?: 0,
        cuisines = this.cuisines ?: null,
        diets = this.diets ?: null,
        dishTypes = this.dishTypes ?: null,
//        extendedIngredients = this.extendedIngredients ?: null,
        glutenFree = this.glutenFree ?: null,
        healthScore = this.healthScore ?: 0
    )
}