package kg.geeks.game.players

import kg.geeks.game.logic.Game.random

class Warrior(name: String, health: Int, damage: Int) : Hero(name, health, damage, Abilities.WARRIOR) {
    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val coefficient = random.nextInt(2, 6)
        boss.health -= coefficient * this.damage
        println("Warrior ${this.name} hit critically with damage ${coefficient * this.damage}")

    }
}