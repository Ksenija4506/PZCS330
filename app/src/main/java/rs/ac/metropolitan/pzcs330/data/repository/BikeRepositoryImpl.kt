package rs.ac.metropolitan.pzcs330.data.repository

import rs.ac.metropolitan.pzcs330.data.remote.BikeApi
import rs.ac.metropolitan.pzcs330.data.remote.dto.BikeDto
import rs.ac.metropolitan.pzcs330.domain.repository.BikeRepository
import javax.inject.Inject

class BikeRepositoryImpl @Inject constructor(
    private val api : BikeApi
) : BikeRepository {

    override suspend fun getBikes(): List<BikeDto> {
        return api.getBikes()
    }

    override suspend fun getBikeById(bikeId: Int): BikeDto {
        return api.getBikeById(bikeId)
    }

}