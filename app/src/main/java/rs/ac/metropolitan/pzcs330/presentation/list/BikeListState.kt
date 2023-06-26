package rs.ac.metropolitan.pzcs330.presentation.list

import rs.ac.metropolitan.pzcs330.domain.model.Bike

data class BikeListState(
    val isLoading: Boolean = false,
    val bikes: List<Bike> = emptyList(),
    val error: String = "",
    val search_bike: List<Bike> = emptyList(),
    val searchString:String = "",
    val searchTags:String = "",
    val searchIngredients:String = "",
    val searchCount:Int =0
)
