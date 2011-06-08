/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

/**
 *
 * @author 0213101
 */
public class PainelPesquisarResponsavel extends Panel{

    public PainelPesquisarResponsavel() {
        Table resultados = new Table("Resultados");
        resultados.addContainerProperty("Nome", String.class, null);
        resultados.addContainerProperty("E-mail", String.class, null);
        resultados.addContainerProperty("Telefone", String.class, null);
        resultados.addContainerProperty("Cargo", String.class, null);





        FormLayout leiaute = new FormLayout();
        Button pesquisar = new Button("Pesquisar");

        TextField sala = new TextField("Sala");
        leiaute.addComponent(sala);
        leiaute.addComponent(pesquisar);        
        this.addComponent(leiaute);
        this.addComponent(resultados);
    }


}
