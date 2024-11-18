package kg.geeks.game.logic

import kg.geeks.game.players.*
import java.nio.file.Watchable
import kotlin.random.Random

object Game {
    val random = Random
    private var roundNumber = 0

    fun startGame(){
        val boss = Boss("Dragon", 400, 50)
        val warrior = Warrior("Arthur", 200, 15)
        val mage = Mage("Merlin", 150, 20)
        val medic = Medic("Healer", 130, 5)

        val heroes = arrayOf(warrior, mage, medic)

        showStatistics(boss, heroes)
        while (!isGameOver(boss, heroes)){
            playRound(boss, heroes)
        }
    }

    private fun playRound(boss : Boss, heroes: Array<Hero>) {
        boss.chooseDefence()
        boss.attack(heroes)
        for (hero in heroes) {
            if (hero.health > 0 && boss.health > 0 && hero.superAbility != boss.defence) {
                hero.attack(boss)
                hero.applySuperPower(boss, heroes)
            }
        }
        roundNumber++
        showStatistics(boss, heroes)
    }

    private fun isGameOver(boss: Boss, heroes: Array<Hero>): Boolean {
        if (boss.health <= 0) {
            println("Heroes won!!!")
            return true
        }

        val allHeroesDead: Boolean = heroes.all { it.health <= 0 }

        if (allHeroesDead) {
            println("Boss won!!!")
            return true
        }

        return false
    }

    private fun showStatistics(boss: Boss, heroes: Array<Hero>) {
        println("ROUND $roundNumber ----------------------------")
        println(boss)
        for (hero in heroes) {
            println(hero)
        }
    }
}