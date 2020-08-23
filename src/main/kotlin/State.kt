import kotlin.random.Random

enum class State(val repr: Char) {
    VOID(' '),
    ALIVE('█'),
    DEAD('░');

    companion object {
        fun rand(): State {
            return arrayOf(ALIVE, DEAD)[Random.nextInt(2)];
        }
    }
}
