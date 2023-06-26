package rs.ac.metropolitan.pzcs330.domain.use_case.get_bikes

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.ac.metropolitan.pzcs330.common.Resource
import rs.ac.metropolitan.pzcs330.data.remote.dto.toBike
import rs.ac.metropolitan.pzcs330.domain.model.Bike
import rs.ac.metropolitan.pzcs330.domain.repository.BikeRepository
import java.io.IOException
import javax.inject.Inject

class GetBikesUseCase @Inject constructor(
    private val repository: BikeRepository
){

    operator fun invoke() : Flow<Resource<List<Bike>>> = flow {
        try{
            emit(Resource.Loading<List<Bike>>())
            val bikes = repository.getBikes().map { it.toBike() }
            emit(Resource.Success<List<Bike>>(bikes))
        } catch (e: HttpException){
            emit(Resource.Error<List<Bike>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit((Resource.Error<List<Bike>>("Could not reach server. Check your internet connection.")))
        }
    }
}