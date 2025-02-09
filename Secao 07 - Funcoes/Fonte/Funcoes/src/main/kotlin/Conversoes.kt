fun conversaoPorMetodos() {
    val a: Byte = 0
    val b: Short = 5
    val c: Int = 10
    val d: Long = 15L
    val e: Float = 20F
    val f: Double = 25.0

    println(a.toString())
    println(b.toString())
    println(c.toString())
    println(d.toString())
    println(e.toString())
    println(f.toString())

    println(a.toByte())
    println(a.toShort())
    println(a.toInt())
    println(a.toLong())
    println(a.toFloat())
    println(a.toDouble())

    println(b.toByte())
    println(b.toShort())
    println(b.toInt())
    println(b.toLong())
    println(b.toFloat())
    println(b.toDouble())

    println(c.toByte())
    println(c.toShort())
    println(c.toInt())
    println(c.toLong())
    println(c.toFloat())
    println(c.toDouble())

    println(d.toByte())
    println(d.toShort())
    println(d.toInt())
    println(d.toLong())
    println(d.toFloat())
    println(d.toDouble())

    println(e.toInt().toByte())
    println(e.toInt().toShort())
    println(e.toInt())
    println(e.toLong())
    println(e.toFloat())
    println(e.toDouble())

    println(f.toInt().toByte())
    println(f.toInt().toShort())
    println(f.toInt())
    println(f.toLong())
    println(f.toFloat())
    println(f.toDouble())

    val str = "123"
    println(str.toByte())
    println(str.toShort())
    println(str.toInt())
    println(str.toLong())
    println(str.toFloat())
    println(str.toDouble())
    println("false".toBoolean())
}

fun main() {
    conversaoPorMetodos()
}