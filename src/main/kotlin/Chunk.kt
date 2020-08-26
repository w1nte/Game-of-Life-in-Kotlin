class Chunk(
    val world: World,
    val x: Int,
    val y: Int,
    width: Int,
    height: Int
) : Grid(width, height) {

    override fun cell(x: Int, y: Int): Cell {
        return if (x in 0 until width && y in 0 until height) {
            super.cell(x, y)
        } else {
            resolveCell(x, y)
        }
    }

    private fun resolveCell(x: Int, y: Int): Cell {
        val chunk = resolveChunk(x, y)
        var cellX = x % width
        var cellY = y % height

        cellX += if (cellX < 0) width else (if (cellX >= width) -width else 0)
        cellY += if (cellY < 0) height else (if (cellY >= height) -height else 0)

        return chunk.cell(cellX, cellY)
    }

    private fun resolveChunk(x: Int, y: Int): Chunk {
        val chunkX = if (x < 0) -1 else (if (x >= width) 1 else 0)
        val chunkY = if (y < 0) -1 else (if (y >= height) 1 else 0)

        return world.get(chunkX, chunkY)
    }
}
