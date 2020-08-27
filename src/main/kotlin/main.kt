
fun main(args: Array<String>) {
    val game = Game()
    val startWorld = World(50, 120)

    for (y in -1..1) for (x in -1..1) {
        val chunk = Chunk(startWorld, x, y, 50, 120)
        startWorld.add(chunk)
        if (y == 0 && x == 0) {
            for (i in 0 until chunk.height) for (j in 0 until chunk.width) {
                chunk.cell(j, i).state = State.rand()
            }
        }
    }

    var nextWorld = game.next(startWorld)
    for (i in 0..100) {
        nextWorld.get(1, 0).print()
        println()
        nextWorld = game.next(nextWorld)
        Thread.sleep(100)
    }
}
