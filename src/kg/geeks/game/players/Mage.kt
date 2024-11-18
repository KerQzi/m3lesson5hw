package kg.geeks.game.players

import kg.geeks.game.logic.Game.random
import kotlin.random.nextInt

class Mage(name: String, health: Int, damage: Int) : Hero(name, health, damage, Abilities.MAGE) {
    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        var boostDamagePoints = random.nextInt(5..15)

        for (hero in heroes) {
            if (hero.health > 0 && hero != this){
                hero.damage +=boostDamagePoints
                println("Mage boost ${hero.name}`s damage to $boostDamagePoints")
            }
        }
    }
}