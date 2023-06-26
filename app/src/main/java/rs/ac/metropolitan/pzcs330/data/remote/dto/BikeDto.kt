package rs.ac.metropolitan.pzcs330.data.remote.dto

import rs.ac.metropolitan.pzcs330.domain.model.Bike
import rs.ac.metropolitan.pzcs330.domain.model.BikeDetails

data class BikeDto(
    val battery: String,
    val brand: String,
    val id: Int,
    val name: String,
    val speed: String,
    val year: Int
)
fun BikeDto.toBike() : Bike {
    return Bike(
        battery = battery,
        brand = brand,
        id = id,
        name = name,
        speed = speed,
        year = year
    )
}

fun BikeDto.toBikeDetails() : BikeDetails {
    return BikeDetails(
        battery = battery,
        brand = brand,
        id = id,
        name = name,
        speed = speed,
        year = year
    )
}