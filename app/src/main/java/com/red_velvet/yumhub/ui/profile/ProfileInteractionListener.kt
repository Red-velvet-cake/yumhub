package com.red_velvet.yumhub.ui.profile

interface ProfileInteractionListener {
    fun doOnPersonalInfoClicked()

    fun doOnChatBotClicked()

    fun doOnFavoritesClicked()

    fun doOnHistoryClicked()
    fun doOnReviewFoodClicked()

    fun doOnNutritionalValueClicked()

    fun doOnFoodSuggesterClicked()

    fun doOnLogoutClicked()
}