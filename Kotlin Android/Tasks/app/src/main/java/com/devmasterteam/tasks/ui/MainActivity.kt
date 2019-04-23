package com.devmasterteam.tasks.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.devmasterteam.tasks.R
import android.content.Intent
import com.devmasterteam.tasks.constants.TaskConstants
import com.devmasterteam.tasks.infra.SecurityPreferences
import java.util.*
import android.widget.TextView
import com.devmasterteam.tasks.business.PriorityBusiness
import com.devmasterteam.tasks.repository.cache.PriorityCacheConstants
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private lateinit var mPriorityBusiness: PriorityBusiness

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        // setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        // Inicializa variáveis
        mSecurityPreferences = SecurityPreferences(this)
        mPriorityBusiness = PriorityBusiness(this)

        // Incia a fragment padrão
        startDefaultFragment()

        // Inicializa cache
        loadPriorityCache()

        // Formata data
        formatDate()

        // Formata boas-vindas
        formatUserName()
    }

    /**
     * Quando o botão de voltar é pressionado
     * */
    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    /**
     * Tratamento de clicks no menu Navigation
     * */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment: Fragment? = null
        val id = item.itemId

        // Faz o tratamento do click do menu
        when (item.itemId) {
            R.id.navNext -> fragment = TaskListFragment.newInstance(TaskConstants.TASKFILTER.TODO)
            R.id.navDone -> fragment = TaskListFragment.newInstance(TaskConstants.TASKFILTER.DONE)
            R.id.navLogout -> {
                handleLogout()
                return true
            }
        }

        // Insere fragment substituindo qualquer existente
        val fragmentManager = supportFragmentManager
        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.frameContent, fragment).commit()
        }

        // Fecha o menu
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    /**
     * Inicializa a primeira fragment (listagem de tarefas)
     * */
    private fun startDefaultFragment() {

        // Inicializa fragment
        val fragment: Fragment = TaskListFragment.newInstance(TaskConstants.TASKFILTER.TODO)

        // Insere fragment substituindo qualquer existente
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frameContent, fragment).commit()
    }

    /**
     * Formata a data Toolbar
     */
    private fun formatDate() {
        val c = Calendar.getInstance()

        val days = arrayOf("Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado")
        val months = arrayOf("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novemembro", "Dezembro")

        val str = "${days[c.get(Calendar.DAY_OF_WEEK) - 1]}, ${c.get(Calendar.DAY_OF_MONTH)} de ${months[c.get(Calendar.MONTH)]}"
        textDateDescription.text = str
    }

    /**
     * Formata boas-vindas
     */
    private fun formatUserName() {
        val str = "Olá, ${mSecurityPreferences.getStoredString(TaskConstants.KEY.USER_NAME)}!"
        textHello.text = str

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        val header = navigationView.getHeaderView(0)

        val name = header.findViewById<TextView>(R.id.textName)
        val email = header.findViewById<TextView>(R.id.textEmail)
        name.text = mSecurityPreferences.getStoredString(TaskConstants.KEY.USER_NAME)
        email.text = mSecurityPreferences.getStoredString(TaskConstants.KEY.USER_EMAIL)
    }

    /**
     * Faz logout do usuário
     */
    private fun handleLogout() {

        // Limpa os valores armazenados para acesso rápido
        mSecurityPreferences.removeStoredString(TaskConstants.KEY.USER_ID)
        mSecurityPreferences.removeStoredString(TaskConstants.KEY.USER_NAME)
        mSecurityPreferences.removeStoredString(TaskConstants.KEY.USER_EMAIL)

        // Inicia login novamente
        startActivity(Intent(this, LoginActivity::class.java))

        // Impede que seja possível voltar
        finish()

    }

    /**
     * Atualiza o número de tarefas
     */
    fun updateTaskCount(size: Int, completedSize: Int) {

        // Primeira maneira
        textTaskCount.text = if (size == 0) {
            getString(R.string.nenhuma_tarefa)
        } else if (size == 1) {
            getString(R.string.uma_tarefa)
        } else {
            "$size ${getString(R.string.tarefas)}"
        }

        // Segunda maneira
        textTaskDoneCount.text = when (completedSize) {
            0 -> getString(R.string.nenhuma_completa)
            1 -> getString(R.string.uma_completa)
            else -> "$completedSize ${getString(R.string.completas)}"
        }
    }

    /**
     * Carrega cache de prioridades
     * */
    private fun loadPriorityCache() {
        PriorityCacheConstants.setCache(mPriorityBusiness.getList())
    }

    // Funções responsáveis pelo menu superior direito
    // Comentadas para deixar como estudo
    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu. this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        return if (id == R.id.actionLogout) {

            true
        } else {
            super.onOptionsItemSelected(item)
        }

    }
    */

}