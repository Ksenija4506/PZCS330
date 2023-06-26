package rs.ac.metropolitan.pzcs330.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.ac.metropolitan.pzcs330.common.Constants
import rs.ac.metropolitan.pzcs330.data.remote.BikeApi
import rs.ac.metropolitan.pzcs330.data.repository.BikeRepositoryImpl
import rs.ac.metropolitan.pzcs330.domain.repository.BikeRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBikeApi() : BikeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
            .create(BikeApi::class.java)
    }

    @Provides
    @Singleton
    fun providedBikeRepository(api: BikeApi): BikeRepository {
        return BikeRepositoryImpl(api)
    }
}