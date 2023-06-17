package com.red_velvet.yumhub.domain.mapper


//fun RecipeInformationResource.toModel(): RecipeInformationEntity {
//    return RecipeInformationEntity(
//        id = this.id.orZero(),
//        image = this.image.orEmpty(),
//        imageType = this.imageType.orEmpty(),
//        instructions = this.instructions.orEmpty(),
//        preparationMinutes = this.preparationMinutes.orZero(),
//        pricePerServing = this.pricePerServing.orZero(),
//        readyInMinutes = this.readyInMinutes.orZero(),
//        servings = this.servings.orZero(),
//        summary = this.summary.orEmpty(),
//        title = this.title.orEmpty(),
//        analyzedInstructions = analyzedInstructions.map { it.toModel() },
//        cheap = this.cheap.orFalse(),
//        cookingMinutes = this.cookingMinutes.orZero(),
//        cuisines = this.cuisines,
//        diets = this.diets,
//        dishTypes = this.dishTypes,
//        glutenFree = this.glutenFree.orFalse(),
//        healthScore = this.healthScore.orZero(),
//        description = this.summary.orEmpty(),
//    )
//}
//
//fun AnalyzedInstructionResource.toModel(): AnalyzedInstructionsEntity {
//    return AnalyzedInstructionsEntity(
//        name = name.orEmpty(),
//        steps = steps.map {
//            it.toModel()
//        }
//    )
//}
//
//fun StepResource.toModel(): StepEntity {
//    return StepEntity(
//        equipment = equipment.map {
//            it.toModel()
//        },
//        length = length.toModel(),
//        number = number.orZero(),
//        step = step.orEmpty()
//    )
//}
//
//fun EquipmentDto.toModel(): Equipment {
//    return Equipment(
//        id = id.orZero(),
//        image = image.orEmpty(),
//        localizedName = localizedName.orEmpty(),
//        name = name.orEmpty()
//    )
//}
//
//fun LengthDto.toModel(): Length {
//    return Length(
//        number = number.orZero(),
//        unit = unit.orEmpty()
//    )
//}
//
//fun ExtendedIngredientResource.toModel(): ExtendedIngredientEntity {
//    return ExtendedIngredientEntity(
//        aisle = aisle.orEmpty(),
//        amount = amount.orZero(),
//        id = id.orZero(),
//        image = "https://spoonacular.com/cdn/ingredients_100x100/$image".orEmpty(),
//        name = name.orEmpty(),
//        unit = unit.orEmpty(),
//        original = name.orEmpty()
//    )
//}