class Game(private var grid: Chunk) {

    fun run() {
        val loader = ChunkLoader()
        val newGrid = Chunk(loader, grid.x, grid.y, grid.width, grid.height)
        loader.add(newGrid)

        for (y in 0 until grid.height) for (x in 0 until grid.width) {
            val cell = grid.cell(x, y)
            val aliveNeighbours = grid.aliveNeighbours(x, y)

            val newCell = newGrid.cell(x, y)

            newCell.state = State.DEAD

            if (aliveNeighbours == 3 || (aliveNeighbours == 2 && cell.state == State.ALIVE)) {
                newCell.state = State.ALIVE;
            }
        }
        grid = newGrid;
    }

    fun print() {
        grid.print()
    }

}
