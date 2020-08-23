data class Cell(var state: State) {
    override fun toString(): String {
        return state.repr.toString()
    }
}
