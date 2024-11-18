package kg.geeks.game.players

class Medic(name: String, health: Int, damage: Int) : Hero(name, health, damage, Abilities.MEDIC) {
    private val healPoints: Int = 15

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        for (hero in heroes){
            if (hero.health > 0 && this != hero) {
                hero.health += healPoints
                println("${this.name} heal $healPoints to ${hero.name}")
            }
        }
    }
}