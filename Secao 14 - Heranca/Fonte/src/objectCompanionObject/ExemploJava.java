package objectCompanionObject;

public class ExemploJava {

    // Variáveis estáticas estão no escopo da classe
    public static int valor = 0;

    // Variáveis não estáticas estão no escopo da instância
    private int value = 0;

    public ExemploJava() {
        valor++;
        value++;
    }

    public static void main(String[] args) {
        new ExemploJava();
        new ExemploJava();
        new ExemploJava();
        new ExemploJava();

        ExemploJava ex = new ExemploJava();
        System.out.println("Value: " + ex.value);
        System.out.println("Valor: " + ExemploJava.valor);
    }
}
