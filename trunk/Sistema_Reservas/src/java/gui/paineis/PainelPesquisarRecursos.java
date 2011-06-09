/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

/**
 *
 * @author 0213101
 */
public class PainelPesquisarRecursos extends Panel{

    public PainelPesquisarRecursos() {
        Table resultados = new Table("Resultados");
        resultados.addContainerProperty("Nome", String.class, null);
        resultados.addContainerProperty("Qauntidade", Integer.class, null);
        resultados.addContainerProperty("Descrição", String.class, null);

        FormLayout leiaute = new FormLayout();
        Button pesquisar = new Button("Pesquisar");

        TextField sala = new TextField("Sala Reservada");
        leiaute.addComponent(sala);
        leiaute.addComponent(pesquisar);
        HorizontalLayout leiH = new HorizontalLayout();
        leiH.setSpacing(true);

        leiH.addComponent(leiaute);
        leiH.addComponent(resultados);


        this.addComponent(leiH);
    }
    //retornar responsavel das reservas q tem sala do numero do sala.getValue()
    //select pessoa p from reservas r where Sala.getNumero() = sala.getValue()



}
