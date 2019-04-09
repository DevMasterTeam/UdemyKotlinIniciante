package ui;

import business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    private JPanel rootPanel;
    private JButton buttonCancel;
    private JButton buttonSave;
    private JTextField textName;
    private JTextField textTelephone;
    private JPanel panelInformation;

    private ContactBusiness mContactBusiness;

    public ContactForm() {

        // Business
        mContactBusiness = new ContactBusiness();

        this.setContentPane(rootPanel);
        this.setSize(400, 250);

        // Faz com que a janela seja iniciado no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setVisible(true);

        // Atribui eventos
        this.setEvents();
    }

    /**
     * Atribui eventos aos elementos da interface
     */
    private void setEvents() {

        // Salvar
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = textName.getText();
                String phone = textTelephone.getText();

                try {

                    // Salva contato
                    mContactBusiness.save(name, phone);

                    new MainForm();

                    // Fecha a janela
                    dispose();

                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage(), "Campo obrigatório", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Cancelar
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });

    }
}