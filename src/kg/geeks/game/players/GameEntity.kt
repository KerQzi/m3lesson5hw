package kg.geeks.game.players

import kg.geeks.game.logic.*

abstract class GameEntity(
    val name: String,
    var health: Int,
    var damage: Int
) {
        override fun toString(): String {
            if (this.health <= 0) {
                return "$name ☠\uFE0FDEAD☠\uFE0F"
            } else {
                return "$name health: $health damage: $damage"
            }
    }
}

