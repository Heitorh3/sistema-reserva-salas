/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import database.RecintoDAO;
import database.RecursoDAO;
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
    RecursoDAO recursoDAO = new RecursoDAO();
    RecintoDAO recintoDAO = new RecintoDAO();
    

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
        listaSalas.addListener(new EventoMostraDados());
        
        
        numSala       = new TextField("Número da Sala");        
        //numSala.setReadOnly(true);
        localSala     = new TextField("Local da Sala");
        //localSala.setReadOnly(true);
        capSala       = new TextField("Capacidade");
        //capSala.setReadOnly(true);
        tipoSala      = new TextField("Tipo de Sala");
        //tipoSala.setReadOnly(true);
        
        listaRecursos = new Table();
        listaRecursos.setEditable(true);
        listaRecursos.setSelectable(true);
        listaRecursos.setNullSelectionAllowed(false);
        listaRecursos.addContainerProperty("Nome", String.class, null);
        listaRecursos.addContainerProperty("Quantidade", Integer.class, null);
        listaRecursos.addContainerProperty("Descrição", String.class, null);
        //listaRecursos.setReadOnly(true);


        addRec = new Button("Adicionar");
        addRec.addListener(new EventoAddRecurso());
        //addRec.setEnabled(false);
        //ediRec = new Button("Editar");
        //ediRec.setEnabled(false);
        delRec = new Button("Remover");
        //delRec.setEnabled(false);
        delRec.addListener(new EventoRemRecurso());
        nomeRec = new TextField("Nome:");
        quantRec = new TextField("Quantidade:");
        descrRec = new TextField("Descrição:");
        //nomeRec.setReadOnly(true);
        //quantRec.setReadOnly(true);
        //descrRec.setReadOnly(true);
        

        listaSalas.setWidth("300"); 
        adicionaSalasComboBox();
        desligaCampos();


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
    
    public void limpaCampos()
    {
        numSala.setValue("");
        localSala.setValue("");
        capSala.setValue("");
        tipoSala.setValue("");        
        listaSalas.removeAllItems();
        bDeletar.setEnabled(false);
        //bNova.setEnabled(false);
        bEditar.setEnabled(false);
        addRec.setEnabled(true);
        delRec.setEnabled(true);
        nomeRec.setValue("");        
        quantRec.setValue("");        
        descrRec.setValue("");        
    }
    
    public void adicionaSalasComboBox()
    {
        //recintoDAO = new RecintoDAO();
        ArrayList<Recinto> rs = recintoDAO.pesquisar();
        for (Recinto r : rs)
        {
            listaSalas.addItem(r);
        }
    
    }

    private class EventoAddRecurso implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event) {
            Recurso r = new Recurso();
            listaRecursos.setEnabled(true);            
            int i = listaRecursos.size();
            //System.out.println(i);
            listaRecursos.addItem(new Object[]
            {(String)nomeRec.getValue(), Integer.parseInt((String)quantRec.getValue()), (String)descrRec.getValue()}, ++i);
                
            //System.out.println(            listaRecursos.toString());
            nomeRec.setValue("");
            quantRec.setValue("");
            descrRec.setValue("");
            
        }
    }

    private class EventoEditarSala implements Button.ClickListener
    {
        public void buttonClick(ClickEvent event)
        {
            //pega a sala que esta selecionada no combobox e devolve
            ligaCampos();
            listaRecursos.setEditable(true);
            listaSalas.setEnabled(false);
            bNova.setEnabled(false);
            bEditar.setCaption("Salvar Alterações");
            bEditar.removeListener(this);
            bEditar.addListener(new EventoSalvaSalaAlterada());
            bEditar.setEnabled(true);
            
            Recinto r = (Recinto) listaSalas.getValue();
            numSala.setValue(r.getNumero());
            capSala.setValue(r.getCapacidade());
            localSala.setValue(r.getLocalizacao());
            tipoSala.setValue(r.getTipo());
            
            //RecursoDAO recDAO = new RecursoDAO();
            ArrayList<Recurso> recs = recursoDAO.pesquisar();
            //System.out.println(recs.toString());            
            int i = 0;
            while (!recs.isEmpty())
            {
                Recurso temp = recs.remove(0);
                System.out.println("dentro do while " + temp);
                if (temp.getIdRecinto() == r.getIdRecinto())
                {
                    System.out.println("dentro do if " + temp);
                    listaRecursos.addItem(new Object[]{temp.getNome(),temp.getQuantidade(),temp.getComentarios()}, ++i);
                }
            }
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
            
            //editar todos os recursos primeiro, verificar quais foram retirados e quais foram adicionados e quais foram modificados
            //depois editar a sala
            
            listaSalas.removeListener(new EventoMostraDados());
            
            Recinto r = (Recinto) listaSalas.getValue();
            
            
            recintoDAO.editar(r);
            

            bEditar.setCaption("Editar");
            bEditar.removeListener(this);
            bEditar.addListener(new EventoEditarSala());
            limpaCampos();
            desligaCampos();
            listaSalas.addListener(new EventoMostraDados());
            
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
            Recinto r = new Recinto();
            //if numSala.
            r.setNumero(Integer.parseInt((String)numSala.getValue()));
            r.setLocalizacao((String)localSala.getValue());
            r.setCapacidade(Integer.parseInt((String)capSala.getValue()));
            r.setTipo((String)tipoSala.getValue());
            
            recintoDAO.inserir(r);

            for (Iterator i = listaRecursos.getItemIds().iterator();i.hasNext();)
            {
                int iid = (Integer) i.next();
                Item item = listaRecursos.getItem(iid);                
                Recurso rec = new Recurso();
                Recurso temp = new Recurso();
                rec.setNome((String)item.getItemProperty("Nome").getValue());
                rec.setQuantidade((Integer)item.getItemProperty("Quantidade").getValue());
                rec.setComentarios((String)item.getItemProperty("Descrição").getValue());
                rec.setRecinto(r);
                recursoDAO.inserir(rec);
            }



            desligaCampos();
            bNova.setCaption("Nova Sala");
            bNova.removeListener(this);
            bNova.addListener(new EventoNovaSala());
            listaSalas.removeAllItems();
            listaRecursos.removeAllItems();
            adicionaSalasComboBox();
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
    
    private class EventoMostraDados implements ValueChangeListener
    {
        public void valueChange(ValueChangeEvent event) 
        {
            ligaCampos();
            
            Recinto r = (Recinto) listaSalas.getValue();
            numSala.setValue(r.getNumero());
            capSala.setValue(r.getCapacidade());
            localSala.setValue(r.getLocalizacao());
            tipoSala.setValue(r.getTipo());
            
            //RecursoDAO recDAO = new RecursoDAO();
            ArrayList<Recurso> recs = recursoDAO.pesquisar();
            listaRecursos.removeAllItems();
            int i = 0;
            while (!recs.isEmpty())
            {
                Recurso temp = recs.remove(0);
                System.out.println("dentro do while " + temp);
                if (temp.getIdRecinto() == r.getIdRecinto())
                {
                    System.out.println("dentro do if " + temp);
                    listaRecursos.addItem(new Object[]{temp.getNome(),temp.getQuantidade(),temp.getComentarios()}, ++i);
                }
            }
            desligaCampos();              
            listaRecursos.setEditable(false);
        }        
    }
}
