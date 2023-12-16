import java.util.concurrent.locks.ReentrantLock

fun main() {
    print("Укажите числом количество философов за круглым столом\nВведите количество философов положиетльным числом: ")
    val countPhilosopher = Count().countPhilosopher
    val name = Array(countPhilosopher) {""}
    for (i in 0 until countPhilosopher){
        print("Имя философа ${i+1}: ")
        name[i] = readln()
    }
    println("Результаты: ")
    val Fork = List(countPhilosopher) { ReentrantLock() }

    val philosophers = List(countPhilosopher) { i -> Philosopher(
            name[i], Fork[i], Fork[(i + 1) % Fork.size]
        )
    }
    philosophers.forEach { Thread(it).start() }
}

