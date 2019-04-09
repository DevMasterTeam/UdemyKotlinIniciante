package repository

import entity.ContactEntity

/**
 * Na arquitetura da aplicação, a camada Repository lida com dados da aplicação
 * */
class ContactRepository private constructor() {

    companion object {

        // Inicializa lista vazia de contatos
        private val contactList = mutableListOf<ContactEntity>()

        /**
         * Faz a criação de um novo contato
         * */
        fun save(contact: ContactEntity) {
            contactList.add(contact)
        }

        /**
         * Faz a remoção do contato
         * */
        fun delete(name: String, phone: String) {

            // Busca lista de contatos
            val list = getList()

            // Encontra o contato na lista
            var index = -1
            for (item in list.withIndex()) {
                if (item.value.name == name && item.value.phone == phone) {
                    index = item.index
                }
            }

            // Faz a remoção
            contactList.removeAt(index)
        }

        /**
         * Retorna todos os contatos
         * */
        fun getList(): List<ContactEntity> {
            return contactList
        }

    }

}