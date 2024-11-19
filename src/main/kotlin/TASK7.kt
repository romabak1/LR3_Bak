class CustomSorter(private val array: MutableList<Int>) {
    val sortedArray: List<Int>
        get() = array.sortedWith { a, b ->
            when {
                // Нульові елементи в кінці
                a == 0 -> 1
                b == 0 -> -1

                // Додатне перед від'ємним
                a > 0 && b < 0 -> -1
                a < 0 && b > 0 -> 1

                // Обидва додатні: сортування за зростанням
                a > 0 && b > 0 -> a.compareTo(b)

                // Обидва від'ємні: сортування за спаданням
                a < 0 && b < 0 -> b.compareTo(a)

                else -> 0
            }
        }
}

fun main() {
    // Читання вхідних даних
    val n = readLine()?.toIntOrNull() ?: return
    val array = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toMutableList() ?: return

    // Перевірка відповідності кількості елементів
    if (array.size != n) {
        println("Помилка: кількість елементів не відповідає заданому числу n")
        return
    }

    // Сортування за допомогою CustomSorter
    val sorter = CustomSorter(array)
    println(sorter.sortedArray.joinToString(" "))
}
