/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

/**
 *
 * @author 0213101
 */
public class FormLogin extends Panel {

    TextField usuario;
    TextField senha;
    Button logar;

    public FormLogin() {
        usuario = new TextField("Usuário");
        senha = new TextField("Senha");
        logar = new Button("Logar");
        logar.addListener(new EventoLogar());

        usuario.setRequired(true);
        senha.setRequired(true);
        senha.setSecret(true);

        this.addComponent(usuario);
        this.addComponent(senha);
        this.addComponent(logar);

    }

    private class EventoLogar implements Button.ClickListener
    {

        public void buttonClick(ClickEvent event) {
            System.out.println("logou");
            setVisible(false);
        }

    }
}
