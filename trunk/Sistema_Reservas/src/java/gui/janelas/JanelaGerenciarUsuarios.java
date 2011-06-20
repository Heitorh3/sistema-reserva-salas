/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.janelas;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import database.PessoaDAO;
import entidades.Pessoa;
import java.util.ArrayList;

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
    PasswordField senha1;
    PasswordField senha2;
    CheckBox admin;
    CheckBox bloquear;
    FormLayout leiaute;
    Button addUser;
    Button editar;
    Button excluir;
    Label titulo;
    ComboBox users;
    PessoaDAO pessoaDAO = new PessoaDAO();
    
    public JanelaGerenciarUsuarios()
    {
        this.center();
        this.setWidth("40%");
        this.setHeight("80%");
        this.setModal(true);
        
        users = new ComboBox("Usuários");
        preencheCB();
        users.setImmediate(true);
        users.addListener(new EventoMostraDados());
        users.setNullSelectionAllowed(false);
        
        
        leiaute = new FormLayout();
        leiaute.setSpacing(true);
        
        titulo = new Label("Gerenciar Usuários");
        nome = new TextField("Nome");        
        email = new TextField("E-Mail");
        telefone = new TextField("Telefone");
        cargo = new TextField("Cargo");
        login = new TextField("Login");
        senha1 = new PasswordField("Senha");        
        senha2 = new PasswordField("Confirme a senha");
        admin = new CheckBox("Administrador? ");
        bloquear = new CheckBox("Bloqueado? ");
        
        addUser = new Button("Adicionar Usuário");
        addUser.addListener(new EventoNovoUsuario());
        
        editar = new Button("Editar Usuário");
        editar.addListener(new EventoEditarUsuario());
        
        excluir = new Button("Excluir Usuário");
        excluir.addListener(new EventoExclusao());
        
        
        desligaCampos();
        
        leiaute.addComponent(titulo);
        leiaute.addComponent(users);
        leiaute.addComponent(nome);
        leiaute.addComponent(email);
        leiaute.addComponent(telefone);
        leiaute.addComponent(cargo);
        leiaute.addComponent(login);
        leiaute.addComponent(senha1);
        leiaute.addComponent(senha2);
        leiaute.addComponent(admin);
        bloquear.setVisible(false);
        leiaute.addComponent(bloquear);        
        leiaute.addComponent(addUser);
        leiaute.addComponent(editar);
        leiaute.addComponent(excluir);
        
        this.addComponent(leiaute);
        
        
    }

    private void desligaCampos()
    {
        titulo.setReadOnly(true);
        nome.setReadOnly(true);
        email.setReadOnly(true);
        telefone.setReadOnly(true);
        cargo.setReadOnly(true);
        login.setReadOnly(true);
        senha1.setReadOnly(true);
        senha2.setReadOnly(true);
        admin.setReadOnly(true);
        //users.setEnabled(true);
        
    }
    private void ligaCampos()
    {
        titulo.setReadOnly(false);
        nome.setReadOnly(false);
        email.setReadOnly(false);
        telefone.setReadOnly(false);
        cargo.setReadOnly(false);
        login.setReadOnly(false);
        senha1.setReadOnly(false);
        senha2.setReadOnly(false);
        admin.setReadOnly(false);
        //users.setEnabled(false);
    }
    
    private void limpaCampos()
    {
        ligaCampos();
        nome.setValue("");
        email.setValue("");
        telefone.setValue("");
        cargo.setValue("");
        login.setValue("");
        senha1.setValue("");
        senha2.setValue("");
        admin.setValue(false);
        desligaCampos();
    }
    
    private void preencheCB() {
        ArrayList<Pessoa> arr = new ArrayList();
        arr = pessoaDAO.pesquisar();
        while (!arr.isEmpty())
        {
            Pessoa p = arr.remove(0);
            users.addItem(p);
        }
    }
    
    private class EventoMostraDados implements ValueChangeListener
    {

        public void valueChange(ValueChangeEvent event) {
            if (users.isEnabled())
            {
                Pessoa p = (Pessoa) users.getValue();
                ligaCampos();
                nome.setValue(p.getNomePessoa());
                email.setValue(p.getEmail());
                email.setWidth(new Float(7.0), UNITS_CM);
                telefone.setValue(p.getTelefone());
                cargo.setValue(p.getCargo());
                login.setValue(p.getLogin());
                senha1.setValue(p.getSenha());
                senha2.setValue(p.getSenha());
                admin.setValue(p.isAdmin());            
                desligaCampos();
            }            
        }
        
    }
    
    private class EventoNovoUsuario implements Button.ClickListener
    {

        public void buttonClick(ClickEvent event) {
            users.setEnabled(false);
            limpaCampos();
            ligaCampos();
            addUser.removeListener(this);
            addUser.addListener(new EventoAddUser());
            editar.setEnabled(false);
            excluir.setEnabled(false);
            addUser.setCaption("Salvar Usuário");
            
        }
    }
    
    private class EventoAddUser implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            if (senha1.getValue().equals(senha2.getValue()))
            {
                Pessoa p = new Pessoa();
                p.setNomePessoa((String)nome.getValue());
                p.setEmail((String)email.getValue());
                p.setTelefone((String)telefone.getValue());
                p.setCargo((String)cargo.getValue());
                p.setLogin((String)login.getValue());
                p.setSenha((String)senha1.getValue());
                if (admin.getValue().equals(Boolean.TRUE))  p.setAdmin(true);  else p.setAdmin(false);
                p.setBloqueado(false);
                pessoaDAO.inserir(p);

                addUser.setCaption("Adicionar Usuário");
                addUser.removeListener(this);
                addUser.addListener(new EventoNovoUsuario());
                editar.setEnabled(true);
                excluir.setEnabled(true);
                limpaCampos();
                desligaCampos();
                users.removeAllItems();            
                preencheCB();
                users.setEnabled(true);
            }
            else getWindow().showNotification("Senha não confere! Entre com a mesma senha nos dois campos de senha!");
        }        
    }
    
    private class EventoEditarUsuario implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            if (users.getValue() != null)
            {
                users.setEnabled(false);
                excluir.setEnabled(false);
                addUser.setEnabled(false);
                editar.removeListener(this);
                editar.setCaption("Salvar alterações");
                editar.addListener(new EventoAlteraUser());
                ligaCampos();
                bloquear.setVisible(true);
            }
        }
    }
    
    private class EventoAlteraUser implements Button.ClickListener
    {

        public void buttonClick(ClickEvent event) {            
            Pessoa p = (Pessoa) users.getValue();            
            p.setNomePessoa((String)nome.getValue());
            p.setEmail((String)email.getValue());
            p.setTelefone((String)telefone.getValue());
            p.setCargo((String)cargo.getValue());
            p.setLogin((String)login.getValue());
            p.setSenha((String)senha1.getValue());
            if (admin.getValue().equals(Boolean.TRUE))  p.setAdmin(true);  else p.setAdmin(false);
            if (bloquear.getValue().equals(Boolean.TRUE))  p.setBloqueado(true);  else p.setBloqueado(false);
            p.setBloqueado(false);
            pessoaDAO.editar(p);
            
            editar.setCaption("Editar Usuário");
            editar.removeListener(this);
            editar.addListener(new EventoEditarUsuario());
            addUser.setEnabled(true);
            excluir.setEnabled(true);
            limpaCampos();
            desligaCampos();
            users.removeAllItems();            
            preencheCB();
            users.setEnabled(true);
        }
        
    }
    
    private class EventoExclusao implements Button.ClickListener
    {

        public void buttonClick(ClickEvent event) {
            users.setEnabled(false);
            excluir.setCaption("Clique para confirmar exclusão.");
            excluir.removeListener(this);
            excluir.addListener(new EventoExcluirUsuario());
            editar.setEnabled(false);
            addUser.setEnabled(false);            
        }
    }
    
    private class EventoExcluirUsuario implements Button.ClickListener
    {

        public void buttonClick(ClickEvent event) {
            Pessoa p = (Pessoa) users.getValue();
            pessoaDAO.excluir(p);
            excluir.removeListener(this);
            excluir.addListener(new EventoExclusao());
            addUser.setEnabled(true);
            excluir.setCaption("Excluir Usuário");
            editar.setEnabled(true);
            users.removeAllItems();            
            preencheCB();
            users.setEnabled(true);            
        }
        
    }
    
}
