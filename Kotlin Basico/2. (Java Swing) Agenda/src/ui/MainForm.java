package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JTable tableContacts;
    private JButton buttonNewContact;
    private JLabel labelContactsCount;
    private JButton buttonRemoveContact;

    private ContactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";

    public MainForm() {

        // Business
        mContactBusiness = new ContactBusiness();

        this.setContentPane(rootPanel);
        this.setSize(500, 250);

        // Faz com que a janela seja iniciado no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Atribui eventos
        this.setEvents();

        // Carrega os contatos
        this.loadContacts();
    }

    /**
     * Atribui eventos aos elementos da interface
     */
    private void setEvents() {
        this.buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Inicializa o formulário de contato
                new ContactForm();

                // Fecha o MainForm
                dispose();

            }
        });

        this.tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {

                    // Obtém o valor da linha que foi clicada
                    if (tableContacts.getSelectedRow() != -1) {
                        mName = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        mPhone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }

                }
            }
        });

        this.buttonRemoveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    // Faz a remoção
                    mContactBusiness.remove(mName, mPhone);

                    // Limpa as variáveis que marcam contato selecionado
                    mName = "";
                    mPhone = "";

                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage(), "Erro ao remover", JOptionPane.ERROR_MESSAGE);
                } finally {

                    // Atualiza a listagem de contatos
                    loadContacts();

                }
            }
        });
    }

    /**
     * Carrega os contatos
     * */
    private void loadContacts() {
        List<ContactEntity> contactList = this.mContactBusiness.getList();

        // Java Swing - Cria o modelo que será usado na tabela
        String[] columnNames = {"Nome", "Telefone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (ContactEntity entity : contactList) {
            Object[] o = new Object[2];
            o[0] = entity.getName();
            o[1] = entity.getPhone();

            model.addRow(o);
        }

        // Atribui os valores preenchidos à tabela
        this.tableContacts.clearSelection();
        this.tableContacts.setModel(model);

        // Atualiza total de contatos
        labelContactsCount.setText(mContactBusiness.getContactCountDescription());
    }
}
