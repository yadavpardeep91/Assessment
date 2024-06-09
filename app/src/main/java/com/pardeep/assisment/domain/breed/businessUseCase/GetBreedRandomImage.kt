package com.pardeep.assisment.domain.breed.businessUseCase

import com.pardeep.assisment.data.product.remote.dataholders.DogResponse
import com.pardeep.assisment.data.common.utils.WrappedResponse
import com.pardeep.assisment.domain.breed.BreedRepository
import com.pardeep.assisment.domain.common.base.BaseResult
import com.pardeep.assisment.domain.breed.entity.DogEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBreedRandomImage @Inject constructor(private val breedRepository: BreedRepository) {
    suspend fun invoke() : Flow<BaseResult<DogEntity, WrappedResponse<DogResponse>>> {
        return breedRepository.getRandomImage()
    }


}