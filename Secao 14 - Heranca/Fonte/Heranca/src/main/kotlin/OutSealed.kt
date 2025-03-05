import sealed.Shape

/**
 * Não é possível fazer a herança de uma classe sealed fora do pacote.
 * Nenhuma outra subclasse pode aparecer fora do módulo e pacote dentro do qual a classe selada é definida.
 * Uma vez que um módulo com uma interface selada é compilado, nenhuma nova implementação pode ser criada.
 * --
 * É útil quando não se quer permitir que novas variações da classe apareçam.
 * Principalmente em caso de pacotes terceiros onde a horança pode ser feita e "bagunçar" a lógica do pacote.
 * --
 * Uma classe sealed é sempre uma classe abstrata, apesar de não possuir o modificador abstract
 * */
// Não funciona
// class OutsideSealed : Shape() {}