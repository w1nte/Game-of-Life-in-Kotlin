class ChunkLoader {

    private val chunks: ArrayList<Chunk> = ArrayList()

    fun chunk(x: Int, y: Int): Chunk {
        return chunks.get(0)
    }

    fun add(chunk: Chunk) {
         chunks.add(chunk)
    }

    fun chunks(): Iterable<Chunk> {
        return chunks
    }

}
