/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.formularios;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 *
 * @author 0213101
 */
public class FormGerenciaSalas extends Window{
    TextField numSala;
    TextField localSala;
    TextField capSala;
    TextField tipoSala;
    ListSelect listaRecursos;
    ComboBox listaSalas;

    public FormGerenciaSalas()
    {
        this.setHeight("70%");
        this.setWidth("70%");
        this.center();
        this.setModal(true);

        HorizontalLayout leiauteH = new HorizontalLayout();

        listaSalas = new ComboBox("Sala presentes no sistema");
        numSala = new TextField("Número da Sala");
        localSala = new TextField("Local da Sala");
        capSala = new TextField("Capacidade");
        tipoSala = new TextField("Tipo de Sala");
        listaRecursos = new ListSelect("Lista de Recursos");

        leiauteH.setSpacing(true);
        
        this.addComponent(listaSalas);

        leiauteH.addComponent(numSala);
        leiauteH.addComponent(localSala);        
        this.addComponent(leiauteH);

        this.addComponent(capSala);
        this.addComponent(tipoSala);
        
        this.addComponent(listaRecursos);
    }

}
