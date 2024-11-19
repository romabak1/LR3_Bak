
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val matrix = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    val k1 = readLine()!!.toInt()
    val rowIndices = readLine()!!.split(" ").map { it.toInt() - 1 }

    val k2 = readLine()!!.toInt()
    val colIndices = readLine()!!.split(" ").map { it.toInt() - 1 }

    val result = rowIndices.map { rowIndex ->
        colIndices.map { colIndex ->
            matrix[rowIndex][colIndex]
        }
    }

    result.forEach { row ->
        println(row.joinToString(" "))
    }
}