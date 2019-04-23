package com.devmasterteam.tasks.repository.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.devmasterteam.tasks.constants.DataBaseConstants

/**
 * Classe para acesso ao banco de dados, deve ser feito a herança uma vez que SQLiteOpenHelper é abstrata.
 * Em qualquer acesso ao banco de dados, é feita a verificação se o banco já existe, caso não exista, o método
 * onCreate é invocado. Uma vez que sua execução termina sem erros, assume-se que o banco foi criado com sucesso.
 * A partir desse ponto, qualquer acesso ao banco de dados com o mesmo número de versão, não existe a chamada
 * aos métodos onCreate & onUpdate. Caso o número da versão mude, então o método onUpgrade é chamado para tratar
 * a lógica necessária para atualização do banco.
 * */
class TaskDataBaseHelper(context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME, null,
    DATABASE_VERSION
) {

    // Usado para criação do banco de dados
    companion object {
        private val DATABASE_VERSION: Int = 1
        private val DATABASE_NAME: String = "Tasks.db"
    }

    // Criação da tabela de usuário
    private val createTableUser = (
            "create table " + DataBaseConstants.USER.TABLE_NAME + " ("
                    + DataBaseConstants.USER.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.USER.COLUMNS.NAME + " text, "
                    + DataBaseConstants.USER.COLUMNS.PASSWORD + " text, "
                    + DataBaseConstants.USER.COLUMNS.EMAIL + " text);")

    // Criação da tabela de categoria
    private val createTableProperty = """
        create table ${DataBaseConstants.PRIORITY.TABLE_NAME}
        (${DataBaseConstants.PRIORITY.COLUMNS.ID} integer primary key,
        ${DataBaseConstants.PRIORITY.COLUMNS.DESCRIPTION} text); """

    // Criação da tabela de tarefas
    private val createTableTask = (
            "create table " + DataBaseConstants.TASK.TABLE_NAME + " ("
                    + DataBaseConstants.TASK.COLUMNS.ID + " integer primary key autoincrement, "
                    + DataBaseConstants.TASK.COLUMNS.USERID + " integer, "
                    + DataBaseConstants.TASK.COLUMNS.PRIORITYID + " integer, "
                    + DataBaseConstants.TASK.COLUMNS.DESCRIPTION + " text, "
                    + DataBaseConstants.TASK.COLUMNS.DUEDATE + " text, "
                    + DataBaseConstants.TASK.COLUMNS.COMPLETE + " integer);")

    // Populando dados de prioridades
    private val inserPriorities = ("INSERT INTO ${DataBaseConstants.PRIORITY.TABLE_NAME}"
            + " values (1, 'Baixa'), (2, 'Média'), (3, 'Alta'), (4, 'Crítica')")

    // Remoção de tabelas
    private val dropTableUser = "DROP TABLE IF EXISTS " + DataBaseConstants.USER.TABLE_NAME
    private val dropTablePriority = "DROP TABLE IF EXISTS " + DataBaseConstants.PRIORITY.TABLE_NAME
    private val dropTableTask = "DROP TABLE IF EXISTS " + DataBaseConstants.TASK.TABLE_NAME

    /**
     * Função que realiza a criação do banco de dados
     * */
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {

        // Faz a criação das tabelas
        sqLiteDatabase.execSQL(createTableUser)
        sqLiteDatabase.execSQL(createTableProperty)
        sqLiteDatabase.execSQL(createTableTask)

        // Faz a inserção das categorias
        sqLiteDatabase.execSQL(inserPriorities)
    }

    /**
     * Função que realiza a atualização do banco de dados
     * */
    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        // Remover todas as tabelas
        // sqLiteDatabase.execSQL(dropTableUser)
        // sqLiteDatabase.execSQL(dropTablePriority)
        // sqLiteDatabase.execSQL(dropTableTask)

        // Fazer a criação novamente
        // onCreate(sqLiteDatabase)

        // Tratamento de versões antigas
        // newVersion -> 3
        /*when (oldVersion){
            1 -> {
                // Lógica para atualizar da versão 1 para a 2 e da 2 para a 3
            }
            2 -> {
                // Lógica para atualizar da versão 2 para a 3
            }
        }*/
    }
}