/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import database.PessoaDAO;
import entidades.Pessoa;
import entidades.Singleton;
import java.util.ArrayList;


/**
 *
 * @author 0213101
 */
public class PainelLogin extends Panel {

    TextField usuario;
    TextField senha;
    Button logar;
    PessoaDAO pessoaDAO = new PessoaDAO();
    public static Pessoa pessoaLogada;

    public PainelLogin() {
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
            ArrayList<Pessoa> pessoas = pessoaDAO.pesquisar();
            for (Pessoa p : pessoas)
            {
                //System.out.println(p.toStringReal());
                if ((p.getLogin().equals(usuario.getValue())) && (p.getSenha().equals(senha.getValue())))
                {
                    getWindow().showNotification("Logado.");
                    Singleton logado = Singleton.getInstance();
                    logado.setPessoa(p);
                }
                else getWindow().showNotification("Falha no Login.");
            }
            
            setVisible(false);
        }

    }
}
