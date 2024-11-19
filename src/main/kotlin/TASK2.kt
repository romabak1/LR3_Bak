// Клас для фільтрації масиву
class ArrayFilter(private val array: List<Int>) {
    // Властивість для фільтрованих елементів
    val filteredElements: List<Int>
        get() = array.filter { isTwoOrFourDigit(it) }

    // Метод для перевірки, чи є число двозначним або чотиризначним
    private fun isTwoOrFourDigit(number: Int): Boolean {
        val absValue = Math.abs(number)
        return absValue in 10..99 || absValue in 1000..9999
    }

    // Метод для виводу кількості та елементів
    fun printFilteredElements() {
        println(filteredElements.size)
        if (filteredElements.isNotEmpty()) {
            println(filteredElements.joinToString(" "))
        }
    }
}

// Головна функція
fun main() {
    // Зчитування даних
    val n = readLine()?.toIntOrNull() ?: return
    if (n !in 2..99) return // Перевірка обмеження для n

    val array = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return
    if (array.size != n) {
        println("Некоректний розмір масиву")
        return
    }

    // Ініціалізація класу
    val filter = ArrayFilter(array)

    // Виведення результату
    try {
        filter.printFilteredElements()
    } catch (e: Exception) {
        println("Сталася помилка: ${e.message}")
    }
}
