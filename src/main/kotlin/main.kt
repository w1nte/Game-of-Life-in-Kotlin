
fun main(args: Array<String>) {
    val loader = ChunkLoader()
    val chunk = Chunk(loader, 0, 0, 80, 30)
    loader.add(chunk)
    val game = Game(chunk)

    for (i in 0..10000) {
        game.print()
        println()
        game.run()
        Thread.sleep(30)
    }
}
