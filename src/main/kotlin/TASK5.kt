class ShakerSort(private var array: IntArray) {

    private val printState: () -> Unit = {
        println(array.joinToString(" "))
    }

    fun sort() {
        var swapped: Boolean
        var start = 0
        var end = array.size - 1

        do {
            swapped = false

            for (i in start until end) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1)
                    swapped = true
                }
            }
            end--

            if (!swapped) break


            for (i in end downTo start + 1) {
                if (array[i] < array[i - 1]) {
                    swap(i, i - 1)
                    swapped = true
                }
            }
            start++
            printState()

        } while (swapped)
        printState()
    }

    private fun swap(i: Int, j: Int) {
        try {
            array[i] = array[j].also { array[j] = array[i] }
        } catch (e: Exception) {
            println("Error swapping elements: ${e.message}")
        }
    }
}

fun main() {
    val n = readLine()?.toIntOrNull() ?: return
    val elements = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray() ?: return

    if (elements.size != n) return

    ShakerSort(elements).sort()
}