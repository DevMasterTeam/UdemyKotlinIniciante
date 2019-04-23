package XIIOrientacaoObjetos

/**
 * Caso exista alguma lógica dentro do getter e setter de cada propriedade, é possível definir explicitamente
 * No caso abaixo, o uso da propriedade causa uma chamada recursiva, dessa maneira, para usar o atributo
 * dentro do getter e setter existe a palavra reservada field.
 * */
class Pessoa6(val anoNascimento: Int) {

    var nome: String = ""
        get() {

            // Acesso a propriedade diretamente causa recursão
            // println("Meu valor é $nome")
            // return nome

            // Maneira correta
            println("Meu valor é $field")
            return field

        }
        set(value) {
            if (value == "") {
                println("Toda pessoa deve ter um nome.")
            } else {

                // Acesso a propriedade diretamente causa recursão
                // nome = value

                // Maneira correta
                field = value
            }
        }

}