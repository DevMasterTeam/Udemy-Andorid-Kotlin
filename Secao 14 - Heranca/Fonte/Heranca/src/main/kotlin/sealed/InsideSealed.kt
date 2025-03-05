package sealed

/**
 * É possível fazer a herança de Shape, pois a classe Triangule está dentro do pacote.
 * */
data class Triangule(val side1: Double, val side2: Double, val side3: Double) : Shape()