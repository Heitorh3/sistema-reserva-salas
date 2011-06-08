/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.formularios;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import entidades.Recinto;
import java.util.ArrayList;

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
    Button bDeletar;
    Button bNova;
    Button bEditar;
    Button addRec;
    Button ediRec;
    Button delRec;
    Panel pRecs;
    Panel dadosSala;
    TextField nomeRec;
    TextField quantRec;
    TextField descrRec;

    public FormGerenciaSalas()
    {
        Recinto r = new Recinto();
        r.setNumero(200);
        r.setLocalizacao("Térreo");
        r.setCapacidade(30);
        r.setTipo("laboratório");
        r.setRecursos(new ArrayList());




        this.setHeight("70%");
        this.setWidth("70%");
        this.center();
        this.setModal(true);

        FormLayout leiauteForm = new FormLayout();
        leiauteForm.setSpacing(true);
        HorizontalLayout leiauteH = new HorizontalLayout();
        leiauteH.setSpacing(true);
        HorizontalLayout leiauteBotoes = new HorizontalLayout();
        HorizontalLayout leiauteRecs = new HorizontalLayout();
        pRecs = new Panel("Lista de Recursos");
        dadosSala = new Panel("Dados Sala");

        bDeletar      = new Button("Excluir Sala");
        bNova         = new Button("Nova Sala");
        bEditar       = new Button("Editar Sala");
        listaSalas    = new ComboBox("Sala presentes no sistema");
        listaSalas.setImmediate(true);
        listaSalas.setNullSelectionAllowed(false);

        
        
        numSala       = new TextField("Número da Sala");        
        numSala.setReadOnly(true);
        localSala     = new TextField("Local da Sala");
        localSala.setReadOnly(true);
        capSala       = new TextField("Capacidade");
        capSala.setReadOnly(true);
        tipoSala      = new TextField("Tipo de Sala");
        tipoSala.setReadOnly(true);
        listaRecursos = new ListSelect();
        addRec = new Button("Adicionar");
        addRec.addListener(new EventoAddRecurso());
        ediRec = new Button("Editar");
        delRec = new Button("Remover");
        nomeRec = new TextField("Nome:");
        quantRec = new TextField("Quantidade:");
        descrRec = new TextField("Descrição:");

        listaSalas.setWidth("300"); //??
        listaSalas.addItem(r);

        listaSalas.addListener(new Listener() {

            @Override
            public void componentEvent(Event event) {
                Recinto r = (Recinto) listaSalas.getValue();
                numSala.setReadOnly(false);
                numSala.setValue(r.getNumero());
                numSala.setReadOnly(true);
                localSala.setReadOnly(false);
                localSala.setValue(r.getLocalizacao());
                localSala.setReadOnly(true);
                capSala.setReadOnly(false);
                capSala.setValue(r.getCapacidade());
                capSala.setReadOnly(true);
                tipoSala.setReadOnly(false);
                tipoSala.setValue(r.getTipo());
                tipoSala.setReadOnly(true);
            }
        });
        
        leiauteBotoes.addComponent(bNova);
        leiauteBotoes.addComponent(bEditar);
        leiauteBotoes.addComponent(bDeletar);
        leiauteH.addComponent(listaSalas);


        leiauteForm.addComponent(numSala);
        leiauteForm.addComponent(localSala);
        

        leiauteForm.addComponent(capSala);
        leiauteForm.addComponent(tipoSala);
        
        leiauteH.addComponent(leiauteForm);
        leiauteRecs.addComponent(listaRecursos);
        leiauteRecs.addComponent(addRec);
        leiauteRecs.addComponent(ediRec);
        leiauteRecs.addComponent(delRec);
        pRecs.addComponent(leiauteRecs);
        pRecs.addComponent(nomeRec);
        pRecs.addComponent(quantRec);
        pRecs.addComponent(descrRec);

        leiauteH.addComponent(pRecs);
        this.addComponent(leiauteH);
        this.addComponent(leiauteBotoes);
    }

    private class EventoAddRecurso implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            String prep = ""+quantRec.getValue() + "   " + nomeRec.getValue() ;
            listaRecursos.addItem(prep);
        }
    }

    private class EventoRemRecurso implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            listaRecursos.getValue();
        }
    }

}
