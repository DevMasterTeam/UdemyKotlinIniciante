package entity

/**
 * Entidade de Contato
 * Os dados poderiam ser trafegados como atributos nos métodos.
 *
 * Porém, é aconselhado que existe uma entidade que englobe os dados e facilite o tráfego da informação.
 *
 * Uma classe que é usada para trafegar os dados e não necessita de métodos é fortíssima candidata
 * para ser criada como data class.
 * */
data class ContactEntity(var name: String, var phone: String)