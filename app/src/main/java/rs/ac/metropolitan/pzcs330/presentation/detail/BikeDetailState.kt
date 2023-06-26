package rs.ac.metropolitan.pzcs330.presentation.detail

import rs.ac.metropolitan.pzcs330.domain.model.Bike
import rs.ac.metropolitan.pzcs330.domain.model.BikeDetails

data class BikeDetailState(
    val isLoading: Boolean = false,
    val bike: BikeDetails? = null,
    val error: String = "",
    val search_bike: List<Bike> = emptyList(),
    val searchString:String = "",
    val searchTags:String = "",
    val searchIngredients:String = "",
    val searchCount:Int =0
)
