class Game {

    fun next(world: World): World {
        val nextWorld = World(world.chunkWidth, world.chunkHeight)

        for (chunk in world.chunks()) {
            val newChunk = Chunk(nextWorld, chunk.x, chunk.y, chunk.width, chunk.height)

            for (y in 0 until chunk.height) for (x in 0 until chunk.width) {
                val cell = chunk.cell(x, y)
                val aliveNeighbours = chunk.aliveNeighbours(x, y)

                val newCell = newChunk.cell(x, y)

                newCell.state = State.DEAD
                if (aliveNeighbours == 3 || (aliveNeighbours == 2 && cell.state == State.ALIVE)) {
                    newCell.state = State.ALIVE;
                }
            }

            nextWorld.add(newChunk)
        }

        return nextWorld
    }

}
