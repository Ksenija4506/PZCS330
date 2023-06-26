package rs.ac.metropolitan.pzcs330.domain.repository

import rs.ac.metropolitan.pzcs330.data.remote.dto.BikeDto

interface BikeRepository {

    suspend fun  getBikes() : List<BikeDto>

    suspend fun getBikeById(bikeId : Int) : BikeDto

}