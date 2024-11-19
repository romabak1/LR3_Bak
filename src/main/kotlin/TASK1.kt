// Клас для роботи з масивом
class ArrayProcessor(private val array: List<Int>) {
    // Властивість для обчислення k (абсолютне значення першого елемента масиву)
    val k: Int
        get() = array.firstOrNull()?.let { Math.abs(it) } ?: 0 // Якщо масив порожній, повертаємо 0

    // Метод для виведення масиву k разів
    fun printArrayKTimes() {
        repeat(k) {
            println(array.joinToString(" "))
        }
    }
}

// Головна функція
fun main() {
    // Зчитування даних
    val n = readLine()?.toIntOrNull() ?: 0 // Кількість елементів
    val inputArray = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: emptyList()

    // Перевірка, чи коректний розмір масиву
    if (inputArray.size != n) {
        println("Некоректні дані")
        return
    }

    // Ініціалізація процесора масиву
    val processor = ArrayProcessor(inputArray)

    // Виведення результату
    try {
        processor.printArrayKTimes()
    } catch (e: Exception) {
        println("Сталася помилка: ${e.message}")
    }
}
