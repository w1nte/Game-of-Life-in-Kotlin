
fun main(args: Array<String>) {
    val game = Game()
    val startWorld = World()

    for (y in -1..1) for (x in -1..1) {
        val chunk = Chunk(startWorld, x, y, 128, 64)
        startWorld.add(chunk)
        if (y == 0 && x == 0) {
            for (i in 0 until chunk.height) for (j in 0 until chunk.width) {
                chunk.cell(j, i).state = State.rand()
            }
        }
    }

    var nextWorld = game.next(startWorld)
    for (i in 0..10000) {
        nextWorld.get(1, 0).print()
        println()
        nextWorld = game.next(nextWorld)
        Thread.sleep(100)
    }
}
