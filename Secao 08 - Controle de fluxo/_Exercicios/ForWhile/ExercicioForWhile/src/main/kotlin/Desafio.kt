fun main() {
    val salario = 10000f

    var patAna = 0f
    var patPaula = 0f
    var mes = 1

    do {
        patAna += (salario * 0.05f + salario * 0.05f + patAna * 0.002f)
        patPaula += (salario * 0.05 + patPaula * 0.008).toFloat()
        mes++
    } while (patAna > patPaula)

    println("Paula vai ultrapassar o patrimônio de Ana no mês $mes.")
}