package rs.ac.metropolitan.pzcs330.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import rs.ac.metropolitan.pzcs330.data.remote.dto.BikeDto
import rs.ac.metropolitan.pzcs330.domain.model.BikeDetails


interface BikeApi {

    @GET("/bike")
    suspend fun getBikes() : List<BikeDto>

    @GET("/bike/{bikeId}")
    suspend fun getBikeById(@Path("bikeId") bikeId : Int) : BikeDto
}