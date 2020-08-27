import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WorldTest {

    lateinit var world: World;

    @BeforeEach
    fun setUp() {
        world = World(10, 10)
        val chunk = Chunk(world, 0, 0, 10, 10)
        fillChunk(chunk) { x, y -> State.ALIVE }
        world.add(chunk)
    }

    @Test
    fun get() {
        val chunk = Chunk(world, 1, 0, 10, 10)
        world.add(chunk)
        chunk.cell(0, 5).state = State.ALIVE

        assertEquals(State.ALIVE, chunk.cell(-1, 0).state)
        assertEquals(State.ALIVE, world.get(0, 0).cell(10, 5).state)
    }

    @Test
    fun add() {
    }

    @Test
    fun chunks() {
        val chunkList = listOf(
            Chunk(world, 0, 0, 10, 10),
            Chunk(world, 1, 0, 10, 10),
            Chunk(world, -1, 0, 10, 10),
            Chunk(world, 0, 1, 10, 10),
            Chunk(world, 0, 1, 10, 10)
        )

        for (chunk in chunkList) {
            world.add(chunk)
        }

        assertEquals(4, world.chunks().count());
    }

    private fun fillChunk(chunk: Chunk, state: (x: Int, y: Int) -> State) {
        for (y in 0 until chunk.height) for (x in 0 until chunk.width) {
            chunk.cell(x, y).state = state(x, y)
        }
    }
}
