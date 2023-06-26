package rs.ac.metropolitan.pzcs330.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.pzcs330.common.Constants
import rs.ac.metropolitan.pzcs330.common.Resource
import rs.ac.metropolitan.pzcs330.domain.use_case.get_bike.GetBikeUseCase
import rs.ac.metropolitan.pzcs330.domain.use_case.get_bikes.GetBikesUseCase
import rs.ac.metropolitan.pzcs330.presentation.list.BikeListState
import javax.inject.Inject

@HiltViewModel
class BikeDetailViewModel @Inject constructor(
    private val getBikeUseCase: GetBikeUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(BikeDetailState())
    val state: State<BikeDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_BIKE_ID)?.let { bikeId ->
            getBike(bikeId.toInt())
        }
    }

    private fun getBike(bikeId: Int) {
        getBikeUseCase(bikeId).onEach { result ->
            when (result){
                is Resource.Success -> {
                    _state.value = BikeDetailState(bike = result.data)
                }
                is Resource.Error -> {
                    _state.value = BikeDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = BikeDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}