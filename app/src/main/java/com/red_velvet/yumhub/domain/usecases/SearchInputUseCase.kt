package com.red_velvet.yumhub.domain.usecases

import javax.inject.Inject

class SearchInputUseCase @Inject constructor(){
    operator fun invoke(searchInput: String): Boolean {
        return searchInput.isNotEmpty()
    }
}