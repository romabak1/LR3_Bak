package task3
// Клас для обробки масиву
class ArrayProcessor(private val array: List<Int>) {
    // Властивість для індексу L (перший від'ємний елемент)
    private val indexL: Int?
        get() = array.indexOfFirst { it < 0 }.takeIf { it >= 0 }

    // Властивість для індексу R (останній від'ємний елемент)
    private val indexR: Int?
        get() = array.indexOfLast { it < 0 }.takeIf { it >= 0 }

    // Метод для обчислення суми
    fun calculateSum(): Int {
        // Збереження індексів у локальні змінні
        val l = indexL
        val r = indexR
        return if (l != null && r != null && l < r) {
            array.subList(l, r + 1).sum()
        } else {
            array.sum()
        }
    }
}

// Головна функція
fun main() {
    // Зчитування даних
    val n = readLine()?.toIntOrNull() ?: return
    if (n !in 2..100) return // Перевірка обмежень на кількість елементів

    val array = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return
    if (array.size != n) {
        println("Некоректний розмір масиву")
        return
    }

    // Ініціалізація класу
    val processor = ArrayProcessor(array)

    // Обчислення і вивід результату
    try {
        println(processor.calculateSum())
    } catch (e: Exception) {
        println("Сталася помилка: ${e.message}")
    }
}
