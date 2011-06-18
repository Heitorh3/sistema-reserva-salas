/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.janelas;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author Vinicius
 */
public class JanelaGerenciarUsuarios extends Window {
    TextField nome;
    TextField email;
    TextField telefone;
    TextField cargo;
    TextField login;
    TextField senha1;
    TextField senha2;
    CheckBox admin;
    VerticalLayout leiaute;
    
    public JanelaGerenciarUsuarios()
    {
        nome = new TextField("Nome");
        
    }
    
}
