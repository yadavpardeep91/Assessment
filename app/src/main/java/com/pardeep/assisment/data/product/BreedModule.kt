package com.pardeep.assisment.data.product

import com.pardeep.assisment.data.product.remote.api.BreedApi
import com.pardeep.assisment.data.product.repository.BreedRepositoryImp
import com.pardeep.assisment.data.common.module.NetworkModule
import com.pardeep.assisment.domain.breed.BreedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class BreedModule {
    @Singleton
    @Provides
    fun provideBreedApi(retrofit: Retrofit) : BreedApi {
        return retrofit.create(BreedApi::class.java)
    }

    @Singleton
    @Provides
    fun provideBreedRepository(breedApi: BreedApi) : BreedRepository {
        return BreedRepositoryImp(breedApi)
    }
}