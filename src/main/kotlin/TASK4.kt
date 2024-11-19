package task4

class ArrayManipulator(private var array: MutableList<Int>) {

    fun performOperations(operations: List<String>): List<Int> {
        operations.forEach { operation ->
            val parts = operation.split(" ")
            val opCode = parts[0].toInt()

            when (opCode) {
                1 -> { // Видалення елемента
                    val index = parts[1].toInt() - 1
                    try {
                        array.removeAt(index)
                    } catch (e: IndexOutOfBoundsException) {
                        println("Неправильний індекс для видалення: $index")
                    }
                }
                2 -> { // Вставка елемента
                    val index = parts[1].toInt() - 1
                    val value = parts[2].toInt()
                    if (index in 0..array.size) {
                        array.add(index, value)
                    } else {
                        println("Неправильний індекс для вставки: $index")
                    }
                }
                3 -> { // Обмін елементів
                    val index1 = parts[1].toInt() - 1
                    val index2 = parts[2].toInt() - 1
                    if (index1 in array.indices && index2 in array.indices) {
                        array[index1] = array[index2].also { array[index2] = array[index1] }
                    } else {
                        println("Неправильні індекси для обміну: $index1, $index2")
                    }
                }
                else -> println("Невідома операція: $opCode")
            }
        }
        return array
    }
}

fun main() {
    // Читання вхідних даних
    val n = readLine()?.toIntOrNull() ?: return
    val initialArray = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toMutableList() ?: return
    val k = readLine()?.toIntOrNull() ?: return
    val operations = mutableListOf<String>()

    repeat(k) {
        readLine()?.let { operations.add(it) }
    }

    // Виконання операцій
    val manipulator = ArrayManipulator(initialArray)
    val result = manipulator.performOperations(operations)

    // Виведення результату
    println(result.joinToString(" "))
}
