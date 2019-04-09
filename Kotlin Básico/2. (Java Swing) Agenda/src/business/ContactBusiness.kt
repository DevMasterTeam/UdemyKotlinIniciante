package business

import entity.ContactEntity
import repository.ContactRepository
import java.lang.Exception

/**
 * Na arquitetura da aplicação, a camada Business lida com toda a lógica de negócio necessária
 * */
class ContactBusiness {

    /**
     * Faz as validações de negócio
     * Útil para criar um novo contato, tanto quanto atualizar um existente
     * */
    private fun validate(name: String, phone: String) {
        if (name == "") {
            throw Exception("Nome obrigatório.")
        }

        if (phone == "") {
            throw Exception("Telefone obrigatório.")
        }
    }

    /**
     * Faz a validação antes de remover um usuário
     * */
    private fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É necessário selecionar um contato antes de remover.")
        }
    }

    /**
     * Faz a criação de um novo usuário
     * */
    fun save(name: String, phone: String) {

        // Faz a validação antes de prosseguir
        validate(name, phone)

        // Cria a entidade
        val contact = ContactEntity(name, phone)
        ContactRepository.save(contact)

    }

    /**
     * Faz a remoção de um usuário
     * */
    fun remove(name: String, phone: String) {

        // Validação
        validateDelete(name, phone)
        ContactRepository.delete(name, phone)
    }

    /**
     * Carrega lista de contatos
     * */
    fun getList(): List<ContactEntity> {
        return ContactRepository.getList()
    }

    /**
     * Retorna o texto usado na descrição da quantidade de contatos
     * */
    fun getContactCountDescription(): String {
        val lst = ContactRepository.getList()
        return when {
            lst.isEmpty() -> "Nenhum contato"
            lst.size == 1 -> "1 Contato"
            else -> "${lst.size} Contatos"
        }
    }

}