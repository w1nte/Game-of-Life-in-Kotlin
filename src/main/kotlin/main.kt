

fun main(args: Array<String>) {
    val loader = ChunkLoader()
    val chunk = Chunk(loader, 0, 0, 10, 10)
    loader.add(chunk)
    val game = Game(chunk)

    for (i in 0..200) {
        //println("\\033[H\\033[2J")
        game.print()
        println()
        game.run()
    }
}
