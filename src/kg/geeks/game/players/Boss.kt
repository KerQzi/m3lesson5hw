package kg.geeks.game.players

import kg.geeks.game.logic.*

class Boss (name: String, health: Int, damage: Int) : GameEntity(name, health, damage){
    var defence: Abilities? = null

    fun chooseDefence() {
        val variants = Abilities.values()
        val randomIndex = Game.random.nextInt(variants.size)
        this.defence = variants[randomIndex]
    }

    fun attack(heroes: Array<Hero>){
        for (hero in heroes){
            if (hero.health > 0) {
                hero.health -= this.damage
            }
        }
    }

    override fun toString(): String {
        return "BOSS ${super.toString()} defence: $defence"
    }
}