package com.red_velvet.yumhub.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.red_velvet.yumhub.remote.resources.recipe.RecipeInformationResource
import com.red_velvet.yumhub.repositories.datasources.RemoteDataSource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RecipePagingSource @Inject constructor(
    private val service: RemoteDataSource,
    private val query: String,
    private val sort: String?,
    private val sortDirection: String?
) : PagingSource<Int, RecipeInformationResource>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeInformationResource> {
        val position = params.key ?: 0
        return try {
            val data = service.searchRecipe(
                query = query,
                number = position,
                offset = params.loadSize,
                sort = sort,
                sortDirection = sortDirection
            )
            val recipeInfoList = data.results ?: emptyList()
            LoadResult.Page(
                data = recipeInfoList,
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (recipeInfoList.isEmpty()) null else position + data.number!!
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RecipeInformationResource>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}