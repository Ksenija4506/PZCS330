package rs.ac.metropolitan.pzcs330.presentation

sealed class Screen (val route: String) {
    object BikeListScreen: Screen("bike_list_screen")
    object BikeDetailScreen: Screen("bike_details_screen")
}
