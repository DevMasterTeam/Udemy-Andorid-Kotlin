fun main() {
}

fun ex1() {
    for (i in 1..50) {
        print("$i ")
    }
}

fun ex2() {
    for (i in 50 downTo 1) {
        print("$i ")
    }
}

fun ex3() {
    for (i in 1..50) {
        if (i % 5 == 0) {
            continue
        }
        print("$i ")
    }
}

fun ex4() {
    var soma = 0
    for (i in 1..500) {
        soma += i
    }
    println("Soma: $soma")
}

fun ex5 (n: Int) {
    for (i in 1..n) {
        for (j in 1..i) {
            print("#")
        }
        println()
    }
}

fun ex5While(n: Int) {
    var str = ""
    var contador = 1
    var i = 0
    var j = 0

    while (i < n) {
        i++
        while (j < contador) {
            str += "#"
            j++
        }
        contador++
        str += "\n"
        j = 0
    }

    println(str)
}