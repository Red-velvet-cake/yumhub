package com.red_velvet.yumhub.ui.profile

interface ProfileInteractionListener {
    fun doOnSettingsClicked()

    fun doOnChatBotClicked()

    fun doOnFavoritesClicked()

    fun doOnHistoryClicked()

    fun doOnNutritionalValueClicked()

    fun doOnFoodSuggesterClicked()

    fun doOnMealTestClicked()
}