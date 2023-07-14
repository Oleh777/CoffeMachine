class CoffeeMachine3(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var coffee: Int = 120,
    private var cups: Int = 9,
    private var money: Int = 550
) {
    private fun currentIngredients() {
        println("""The coffee machine has:
        |$water ml of water
        |$milk ml of milk
        |$coffee g of coffee beans
        |$cups disposable cups
        |${'$'}$money of money""".trimMargin())
    }

    fun action() {
        println("Write action (buy, fill, take, remaining, exit):")
        loop@ do {
            val str = readln()
            println()
            when (str) {
                "buy" -> {
                    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                    when (readln()) {
                        "1" -> {
                            when {
                                water  >= 250 && coffee >= 16 && cups >= 1 -> {
                                    println("I have enough resources, making you a coffee!")
                                    water -= 250
                                    coffee -= 16
                                    cups -= 1
                                    money += 4
                                }
                                water < 250 -> println("Sorry, not enough water!")
                                coffee < 16 -> println("Sorry, not enough coffee beans!")
                                cups < 1 -> println("Sorry, not enough disposable cups!")
                            }
                        }

                        "2" -> {
                            when {
                                water  >= 350 && milk >= 75 && coffee >= 20 && cups >= 1 -> {
                                    println("I have enough resources, making you a coffee!")
                                    water -= 350
                                    milk -= 75
                                    coffee -= 20
                                    cups -= 1
                                    money += 7
                                }
                                water < 350 -> println("Sorry, not enough water!")
                                milk < 75 -> println("Sorry, not enough milk!")
                                coffee < 20 -> println("Sorry, not enough coffee beans!")
                                cups < 1 -> println("Sorry, not enough disposable cups!")
                            }
                        }

                        "3" -> {
                            when {
                                water  >= 200 && milk >= 100 && coffee >= 12 && cups >= 1 -> {
                                    println("I have enough resources, making you a coffee!")
                                    water -= 200
                                    milk -= 100
                                    coffee -= 12
                                    cups -= 1
                                    money += 6
                                }
                                water < 350 -> println("Sorry, not enough water!")
                                milk < 75 -> println("Sorry, not enough milk!")
                                coffee < 20 -> println("Sorry, not enough coffee beans!")
                                cups < 1 -> println("Sorry, not enough disposable cups!")
                            }
                        }
                        "back" -> continue@loop
                        else -> println("unknown number of coffee")
                    }
                    println()
                    println("Write action (buy, fill, take, remaining, exit):")
                }

                "fill" -> {
                    println("Write how many ml of water you want to add:")
                    val addWater = readln().toInt()
                    println("Write how many ml of milk you want to add:")
                    val addMilk = readln().toInt()
                    println("Write how many ml of coffee beans you want to add:")
                    val addCoffee = readln().toInt()
                    println("Write how many disposable cups you want to add:")
                    val addCups = readln().toInt()
                    water += addWater
                    milk += addMilk
                    coffee += addCoffee
                    cups += addCups
                    println()
                    println("Write action (buy, fill, take, remaining, exit):")
                }

                "take" -> {
                    println("I gave you \$$money")
                    money -= money
                    println()
                    println("Write action (buy, fill, take, remaining, exit):")
                }
                "remaining" -> {
                    currentIngredients()
                    println()
                    println("Write action (buy, fill, take, remaining, exit):")
                }
                "exit" -> return

                else -> println("unknown command")
            }
        }  while (str!= "exit")
    }
}

fun main() {
    val coffeeMachine3 = CoffeeMachine3()
    coffeeMachine3.action()
}