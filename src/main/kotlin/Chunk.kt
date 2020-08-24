class Chunk(
        val loader: ChunkLoader,
        val x: Int,
        val y: Int,
        width: Int,
        height: Int
) : Grid(width, height) {

    override fun cell(x: Int, y: Int): Cell {
        if (x in 0 until width && y in 0 until height) {
            return super.cell(x, y)
        } else {
            return resolveCell(x, y)
        }
    }

    private fun resolveCell(x: Int, y: Int): Cell {
        val chunk = resolveChunk(x, y)
        var cellX = x % width
        var cellY = y % height

        if (cellX < 0) {
            cellX += width
        } else if (cellX > width) {
            cellX -= width
        }
        if (cellY < 0) {
            cellY += height
        } else if (cellY >= height) {
            cellY -= height
        }

        return chunk.cell(cellX, cellY)
    }

    private fun resolveChunk(x: Int, y: Int): Chunk {
        var chunkX = 0
        var chunkY = 0

        if (x < 0) {
            chunkX -= 1
        } else if (x >= width) {
            chunkX += 1
        }
        if (y < 0) {
            chunkY -= 1
        } else if (y >= height) {
            chunkY += 1
        }

        return loader.chunk(chunkX, chunkY)
    }
}
