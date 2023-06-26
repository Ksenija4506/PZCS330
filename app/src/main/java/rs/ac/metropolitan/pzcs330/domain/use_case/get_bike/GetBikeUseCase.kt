package rs.ac.metropolitan.pzcs330.domain.use_case.get_bike

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.ac.metropolitan.pzcs330.common.Resource
import rs.ac.metropolitan.pzcs330.data.remote.dto.toBikeDetails
import rs.ac.metropolitan.pzcs330.domain.model.Bike
import rs.ac.metropolitan.pzcs330.domain.model.BikeDetails
import rs.ac.metropolitan.pzcs330.domain.repository.BikeRepository
import java.io.IOException
import javax.inject.Inject

class GetBikeUseCase @Inject constructor(
    private val repository: BikeRepository
){
    operator fun invoke(bikeId : Int) : Flow<Resource<BikeDetails>> = flow {
        try{
            emit(Resource.Loading<BikeDetails>())
            val bike = repository.getBikeById(bikeId).toBikeDetails()
            emit(Resource.Success<BikeDetails>(bike))
        } catch (e: HttpException){
            emit(Resource.Error<BikeDetails>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit((Resource.Error<BikeDetails>("Could not reach server. Check your internet connection.")))
        }
    }
}