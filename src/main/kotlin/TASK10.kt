fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val snakeArray = Array(n) { IntArray(m) }
    var current = n * m

    for (i in 0 until n) {
        if (i % 2 == 0) {
            // Заповнення зліва направо
            for (j in m - 1 downTo 0) {
                snakeArray[i][j] = current--
            }
        } else {
            // Заповнення справа наліво
            for (j in 0 until m) {
                snakeArray[i][j] = current--
            }
        }
    }

    // Виведення результату
    snakeArray.forEach { row ->
        println(row.joinToString(" "))
    }
}
