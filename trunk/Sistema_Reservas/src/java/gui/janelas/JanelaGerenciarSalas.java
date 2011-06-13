/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import entidades.Hibernate;
import entidades.Recinto;
import entidades.Recurso;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 0213101
 */
public class JanelaGerenciarSalas extends Window{
    TextField numSala;
    TextField localSala;
    TextField capSala;
    TextField tipoSala;
    Table listaRecursos;
    ComboBox listaSalas;
    Button bDeletar;
    Button bNova;
    Button bEditar;
    Button addRec;
    //Button ediRec;
    Button delRec;
    Panel pRecs;
    Panel dadosSala;
    TextField nomeRec;
    TextField quantRec;
    TextField descrRec;
    static int indexTabela;

    public JanelaGerenciarSalas()
    {
        this.setHeight("90%");
        this.setWidth("90%");
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
        bNova.addListener(new EventoNovaSala());
        bEditar       = new Button("Editar Sala");
        bEditar.addListener(new EventoEditarRecurso());
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
        
        listaRecursos = new Table();
        listaRecursos.setEditable(true);
        listaRecursos.setSelectable(true);
        listaRecursos.setNullSelectionAllowed(false);
        listaRecursos.addContainerProperty("Nome", String.class, null);
        listaRecursos.addContainerProperty("Quantidade", Integer.class, null);
        listaRecursos.addContainerProperty("Descrição", String.class, null);
        //indexTabela = 1;


        addRec = new Button("Adicionar");
        addRec.addListener(new EventoAddRecurso());
        addRec.setEnabled(false);
        //ediRec = new Button("Editar");
        //ediRec.setEnabled(false);
        delRec = new Button("Remover");
        delRec.setEnabled(false);
        delRec.addListener(new EventoRemRecurso());
        nomeRec = new TextField("Nome:");
        quantRec = new TextField("Quantidade:");
        descrRec = new TextField("Descrição:");
        nomeRec.setReadOnly(true);
        quantRec.setReadOnly(true);
        descrRec.setReadOnly(true);
        listaRecursos.setReadOnly(true);

        listaSalas.setWidth("300"); //??


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
        //leiauteRecs.addComponent(ediRec);
        leiauteRecs.addComponent(delRec);
        pRecs.addComponent(leiauteRecs);
        pRecs.addComponent(nomeRec);
        pRecs.addComponent(quantRec);
        pRecs.addComponent(descrRec);

        leiauteH.addComponent(pRecs);
        this.addComponent(leiauteH);
        this.addComponent(leiauteBotoes);
    }

    public void ligaCampos()
    {

    }

    private class EventoAddRecurso implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            Recurso r = new Recurso();
            
            listaRecursos.addItem(new Object[]
            {(String)nomeRec.getValue(), Integer.parseInt((String)quantRec.getValue()), (String)descrRec.getValue()}, ++indexTabela);
            nomeRec.setValue("");
            quantRec.setValue("");
            descrRec.setValue("");
            
        }
    }

    private class EventoRemRecurso implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            Object o = listaRecursos.getValue();
            o.toString();
        }
    }

    private class EventoSalvaSalaAlterada implements Button.ClickListener {

        public void buttonClick(ClickEvent event) {

            bEditar.setCaption("Editar");
            bEditar.addListener(new EventoEditarRecurso());
            System.out.println(listaSalas.getValue());
        }
    }

    private class EventoEditarRecurso implements Button.ClickListener {

        public void buttonClick(ClickEvent event) {
            if (listaSalas.getValue() != null) {
                bEditar.setCaption("Salvar");
                bEditar.addListener(new EventoSalvaSalaAlterada());
                System.out.println(listaSalas.getValue());
            }

        }
    }

    private class EventoAddSala implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event)
        {
            Hibernate h = new Hibernate();
            h.beginTransaction();
            {
                for (Iterator i = listaRecursos.getItemIds().iterator(); i.hasNext();)
                {
                    int iid = (Integer) i.next();
                    Item item = listaRecursos.getItem(iid);
                    System.out.println(item.toString());



                }

                /*
                ArrayList<Recurso> recs = new ArrayList();
                Recurso r = new Recurso();
                r.setNome((String)nomeRec.getValue());
                r.setQuantidade(Integer.parseInt((String)quantRec.getValue()));
                r.setComentarios((String)descrRec.getValue());
                Recinto re = new Recinto();
                re.setRecursos(null);
                 * 
                 */
            }
            h.endTransaction();
        }
    }




    private class EventoNovaSala implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event)
        {
            bNova.setCaption("Salvar");
            bNova.removeListener(this);
            bNova.addListener(this);
            bEditar.setEnabled(false);
            bDeletar.setEnabled(false);
            numSala.setReadOnly(false);
            localSala.setReadOnly(false);
            capSala.setReadOnly(false);
            tipoSala.setReadOnly(false);
            addRec.setEnabled(true);
            delRec.setEnabled(true);
            nomeRec.setReadOnly(false);
            quantRec.setReadOnly(false);
            descrRec.setReadOnly(false);
            listaRecursos.setReadOnly(false);
        }
    }
}
