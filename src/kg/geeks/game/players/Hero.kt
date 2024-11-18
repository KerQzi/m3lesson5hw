package kg.geeks.game.players

abstract class Hero(
    name: String,
    health: Int,
    damage: Int,
    val superAbility: Abilities
) : GameEntity(name, health, damage), HavingSuperAbility {

    fun attack (boss:Boss) {
            boss.health -= this.damage
    }
}