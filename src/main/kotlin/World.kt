class World(
    val chunkWidth: Int,
    val chunkHeight: Int
) {

    private val chunks: HashMap<Int, HashMap<Int, Chunk>> = HashMap()


    fun get(x: Int, y: Int): Chunk {
        return if (chunks.containsKey(y) && chunks[y]?.containsKey(x)!!) {
            chunks[y]?.get(x)!!
        } else {
            val newChunk = Chunk(this, x, y, chunkWidth, chunkHeight)
            add(newChunk)
            get(x, y)
        }
    }

    fun add(chunk: Chunk) {
        assert(chunk.width == chunkWidth && chunk.height == chunkHeight)

        if (chunks.containsKey(chunk.y)) {
            chunks[chunk.y]?.put(chunk.x, chunk)
        } else {
            val map: HashMap<Int, Chunk> = HashMap()
            map[chunk.x] = chunk
            chunks[chunk.y] = map
        }
    }

    fun chunks(): Iterable<Chunk> {
        return chunks.flatMap { (_, values) -> values.map { it.value } }
    }

}
