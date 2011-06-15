/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import entidades.Recurso;

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
        bEditar.addListener(new EventoEditarSala());
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


        /*
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
         * 
         */
        
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

    public void desligaCampos()
    {
        numSala.setReadOnly(true);
        localSala.setReadOnly(true);
        capSala.setReadOnly(true);
        tipoSala.setReadOnly(true);
        listaRecursos.setReadOnly(true);   //faz a magica
        listaSalas.setEnabled(true);
        bDeletar.setEnabled(true);
        bNova.setEnabled(true);
        bEditar.setEnabled(true);
        addRec.setEnabled(false);
        delRec.setEnabled(false);
        nomeRec.setReadOnly(true);
        quantRec.setReadOnly(true);
        descrRec.setReadOnly(true);
    }

    public void ligaCampos()
    {
        numSala.setReadOnly(false);
        localSala.setReadOnly(false);
        capSala.setReadOnly(false);
        tipoSala.setReadOnly(false);
        listaRecursos.setReadOnly(false);    //faz a magica
        listaSalas.setEnabled(false);
        bDeletar.setEnabled(false);
        //bNova.setEnabled(false);
        bEditar.setEnabled(false);
        addRec.setEnabled(true);
        delRec.setEnabled(true);
        nomeRec.setReadOnly(false);
        quantRec.setReadOnly(false);
        descrRec.setReadOnly(false);
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

    private class EventoEditarSala implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            //pega a sala que esta selecionada no combobox e devolve
            ligaCampos();
            listaSalas.setEnabled(false);
            bNova.setEnabled(false);
            bEditar.setCaption("Salvar Alterações");
            bEditar.removeListener(this);
            bEditar.addListener(new EventoSalvaSalaAlterada());
            bEditar.setEnabled(true);
        }
    }

    private class EventoRemRecurso implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            Object o = listaRecursos.getValue();            
        }
    }

    private class EventoSalvaSalaAlterada implements Button.ClickListener {

        public void buttonClick(ClickEvent event) {

            bEditar.setCaption("Editar");
            bEditar.removeListener(this);
            bEditar.addListener(new EventoEditarSala());
            desligaCampos();
            
        }
    }

    private class EventoEditarRecurso implements Button.ClickListener {

        public void buttonClick(ClickEvent event) {
            if (listaSalas.getValue() != null) {
                bEditar.setCaption("Salvar");
                bEditar.addListener(new EventoSalvaSalaAlterada());
                System.out.println(listaSalas.getValue());
                ligaCampos();
            }

        }
    }

    private class EventoAddSala implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event)
        {
            desligaCampos();
            bNova.setCaption("Nova Sala");
            bNova.removeListener(this);
            bNova.addListener(new EventoNovaSala());
            //bNova.setEnabled(true);
        }
    }




    private class EventoNovaSala implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event)
        {
            bNova.setCaption("Salvar");
            bNova.removeListener(this);
            bNova.addListener(new EventoAddSala());
            ligaCampos();
        }
    }
}
