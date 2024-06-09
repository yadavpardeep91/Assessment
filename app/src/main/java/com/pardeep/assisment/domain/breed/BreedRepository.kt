package com.pardeep.assisment.domain.breed

import com.pardeep.assisment.data.product.remote.dataholders.DogResponse
import com.pardeep.assisment.data.common.utils.WrappedResponse
import com.pardeep.assisment.domain.breed.entity.DogEntity
import com.pardeep.assisment.domain.common.base.BaseResult
import kotlinx.coroutines.flow.Flow

interface BreedRepository {

    suspend fun getRandomImage() : Flow<BaseResult<DogEntity, WrappedResponse<DogResponse>>>
}