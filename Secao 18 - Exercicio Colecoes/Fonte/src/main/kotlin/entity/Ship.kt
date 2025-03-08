package entity

import utils.ShipType

data class Ship(
    val name: String,
    val cargoCapacity: Double,
    val type: ShipType,
    val fuelCapacity: Double
)