open class Grid(val width: Int, val height: Int) {
    companion object {
        val OUTSIDE = Cell(State.VOID)
    }

    private val grid: Array<Array<Cell>> = Array(height) { Array(width) { Cell(State.DEAD) } }


    open fun cell(x: Int, y: Int): Cell {
        if (x in 0 until width && y in 0 until height) {
            return grid[y][x]
        } else {
            return OUTSIDE;
        }
    }

    fun neighbours(x: Int, y: Int): List<Cell> {
        assert(x in 0 until width && y in 0 until height)

        val neighbours: ArrayList<Cell> = ArrayList()
        for (xn in -1..1) for (yn in -1..1) {
            if (xn == 0 && yn == 0) continue
            cell(x + xn, y + yn).let { neighbours.add(it) }
        }

        return neighbours
    }

    fun aliveNeighbours(x: Int, y: Int): Int {
        val cells = neighbours(x, y)
        var i = 0;

        for (cell in cells) {
            if (cell.state == State.ALIVE) {
                i++
            }
        }
        return i;
    }

    fun print() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                print(grid[y][x])
            }
            println()
        }
    }
}
