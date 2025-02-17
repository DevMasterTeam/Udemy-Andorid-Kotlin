/**
 * do while é um laço de repetição executado enquanto a condição é verdadeira.
 * Extremamente parecido com 'while', porém o corpo do 'do while' é executado sempre no mínimo uma vez,
 * já que não existe condição para que entre no corpo, a condição só acontece no final.
 */
fun main() {
    var indiceDoWhile = 1
    do {
        print("$indiceDoWhile ")
        indiceDoWhile++
    } while (indiceDoWhile < 0)
}