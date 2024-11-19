fun main() {
    // Вхідні дані
    val n = readLine()?.toIntOrNull() ?: return
    val points = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return

    if (points.size != n) {
        println("Кількість точок не відповідає заданому числу n")
        return
    }

    // Ініціалізація мінімальних і максимальних значень
    var minDistance = Int.MAX_VALUE
    var maxDistance = Int.MIN_VALUE

    var minPair: Pair<Int, Int>? = null
    var maxPair: Pair<Int, Int>? = null

    // Сортуємо точки для обчислення пар без проміжних точок
    val sortedPoints = points.sorted()

    // Обчислення мінімальної відстані
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val distance = kotlin.math.abs(points[i] - points[j])
            if (distance < minDistance) {
                minDistance = distance
                minPair = Pair(i + 1, j + 1) // Індекси точок (1-based)
            }
        }
    }

    // Обчислення максимальної відстані між точками без інших точок
    for (i in 0 until sortedPoints.size - 1) {
        val distance = kotlin.math.abs(sortedPoints[i] - sortedPoints[i + 1])
        if (distance > maxDistance) {
            maxDistance = distance
            val firstIndex = points.indexOf(sortedPoints[i]) + 1
            val secondIndex = points.indexOf(sortedPoints[i + 1]) + 1
            maxPair = Pair(firstIndex, secondIndex)
        }
    }

    // Виведення результатів
    minPair?.let {
        println("$minDistance ${it.first} ${it.second}")
    }

    maxPair?.let {
        println("$maxDistance ${it.first} ${it.second}")
    }
}
