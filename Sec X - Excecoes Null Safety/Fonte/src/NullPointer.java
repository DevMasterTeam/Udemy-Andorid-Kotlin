public class NullPointer {
    public static void main(String[] args) {
        // Variável declara, mas ainda sem valor
        String str = null;

        // Acesso a uma variável sem valor atribuído - NullPointerException
        System.out.println("Tamanho: " + str.length());
    }
}
