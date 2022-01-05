package getterSetter;

public class GetSetJava {
    public int idade;

    private void saudacoes() {
        Person pessoa = new Person(25);

        // Getter e setter definido automaticamente pelo Kotlin
        pessoa.getIdade();
        pessoa.setIdade(26);
    }
}
