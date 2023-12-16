class Count {
    var countPhilosopher = 0
    init {
        var actual = false
        do {
            try {
                countPhilosopher = readln().toInt()
                actual = true
            } catch (e: NumberFormatException) {
                println("Ошибка ввода! Введите число")
            }
        } while (!actual)
    }
}