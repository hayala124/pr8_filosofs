import java.util.concurrent.locks.ReentrantLock

data class Philosopher(val number: String, val left: ReentrantLock, val right: ReentrantLock): Runnable {
    override fun run() {
        EATING()
    }

    fun EATING() {
        var Choice = true
        do {
            if ((1..2).random() == 1) {
                if (right.tryLock()) {
                    println("$number взял вилку слева и обедает.")
                    Choice = false
                } else
                    if (!right.tryLock() && !left.tryLock()) {
                        println("$number размышляет.")
                        Choice = false
                    }
            } else {
                if (left.tryLock()) {
                    println("$number взял вилку справа и обедает.")
                    Choice = false
                } else if (!right.tryLock() && !left.tryLock()) {
                    Choice = false
                    println("$number размышляет.")
                }
            }
        } while (Choice)
    }
}
