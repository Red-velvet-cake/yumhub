package com.red_velvet.yumhub.data.repositories

import com.red_velvet.yumhub.data.local.entities.CategoryLocalModel

interface LocalDataSource {
    suspend fun getCategories(): List<CategoryLocalModel>
}