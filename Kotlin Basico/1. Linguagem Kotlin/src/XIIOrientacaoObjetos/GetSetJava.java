package XIIOrientacaoObjetos;

public class GetSetJava {

    public int idade;

    private void saudacoes() {
        Pessoa5 pessoa = new Pessoa5(25);

        // Getter e setter definido automaticamente pelo Kotlin
        pessoa.getIdade();
        pessoa.setIdade(26);
    }

}
