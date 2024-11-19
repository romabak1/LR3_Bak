fun main() {
    // Читання одного символу
    val input = readLine()

    // Перевірка, чи введено лише один символ
    if (input == null || input.length != 1) {
        println("Помилка: введіть одну англійську літеру")
        return
    }

    val char = input[0]

    // Перевірка, чи символ є англійською літерою
    if (char !in 'A'..'Z' && char !in 'a'..'z') {
        println("Помилка: введіть англійську літеру")
        return
    }

    // Зміна регістру
    val result = if (char.isUpperCase()) char.lowercaseChar() else char.uppercaseChar()

    // Виведення результату
    println(result)
}
