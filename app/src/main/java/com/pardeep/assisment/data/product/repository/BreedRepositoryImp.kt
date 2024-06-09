package com.pardeep.assisment.data.product.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pardeep.assisment.data.product.remote.api.BreedApi
import com.pardeep.assisment.data.product.remote.dataholders.DogResponse
import com.pardeep.assisment.data.common.utils.WrappedResponse
import com.pardeep.assisment.domain.breed.BreedRepository
import com.pardeep.assisment.domain.breed.entity.DogEntity
import com.pardeep.assisment.domain.common.base.BaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BreedRepositoryImp @Inject constructor(private var breedApi: BreedApi) : BreedRepository {


    override suspend fun getRandomImage(): Flow<BaseResult<DogEntity, WrappedResponse<DogResponse>>>{
        return flow {

            val response = breedApi.getRandomBreedImage()
            if(response.isSuccessful){
                val body = response.body()!!
                val dogEntity = DogEntity(message = body.data?.message!!, status = body.data?.status!!)
                emit(BaseResult.Success(dogEntity))
            }else{
                val type = object : TypeToken<WrappedResponse<DogResponse>>(){}.type
                val err = Gson().fromJson<WrappedResponse<DogResponse>>(response.errorBody()!!.charStream(), type)!!
                err.code = response.code()
                emit(BaseResult.Error(err))
            }
        }
    }
}