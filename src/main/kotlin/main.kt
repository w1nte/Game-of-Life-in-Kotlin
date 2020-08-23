

fun main(args: Array<String>) {
    val grid = Grid(50,   20)
    val game = Game(grid)

    for (i in 0..20) {
        println("\\033[H\\033[2J")
        game.print()
        println()
        game.run()
    }
}
