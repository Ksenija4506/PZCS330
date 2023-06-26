package rs.ac.metropolitan.pzcs330.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.pzcs330.common.Resource
import rs.ac.metropolitan.pzcs330.domain.use_case.get_bike.GetBikeUseCase
import rs.ac.metropolitan.pzcs330.domain.use_case.get_bikes.GetBikesUseCase
import javax.inject.Inject

@HiltViewModel
class BikeListViewModel @Inject constructor(
    private val getBikesUseCase: GetBikesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(BikeListState())
    val state: State<BikeListState> = _state

    init {
        getBikes()
    }

    private fun getBikes() {
        getBikesUseCase().onEach { result ->
            when (result){
                is Resource.Success -> {
                    _state.value = BikeListState(bikes = result.data ?: emptyList())
                }
                    is Resource.Error -> {
                        _state.value = BikeListState(error = result.message ?: "An unexpected error occurred")
                    }
                        is Resource.Loading -> {
                            _state.value = BikeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}