/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import database.RecintoDAO;
import entidades.Recinto;
import entidades.Reserva;
import java.util.ArrayList;

/**
 *
 * @author 0213101
 */
public class JanelaNovaReserva extends Window{
    
    Label titulo;
    Panel sala;
    Panel labelResponsavel;
    TextField nomeReserva;
    TextField solicitante;
    TextField responsavel;
    TextField tfDia;
    TextField tfMes;
    TextField aAno;
    TextField finalidade;
    //NativeSelect NSsala;
    ComboBox recsSala;
    OptionGroup repeticao;
    Button salvar;
    Button cancelar;
    ComboBox listaSalas;    
    NativeSelect horaInicio;
    NativeSelect minInicio;
    NativeSelect horaFim;
    NativeSelect minFim;
    NativeSelect diaIni;
    NativeSelect mesIni;
    NativeSelect diaFim;
    NativeSelect mesFim;

    RecintoDAO recintoDAO = new RecintoDAO();
    /*
     * A fábrica não tem trabalho megafoda, a gente que torna o trabalho
     * megafoda pra valorizar.
     * - Cabeceia
     */
    public JanelaNovaReserva(int dia, String mes)
    {
        
            this.setModal(true);
            this.setWidth("50%");
            this.setHeight("80%");
            this.center();

            VerticalLayout mainLayout = new VerticalLayout();
            HorizontalLayout leiauteDia = new HorizontalLayout();
            leiauteDia.setSpacing(true);
            HorizontalLayout leiauteIni = new HorizontalLayout();
            leiauteIni.setSpacing(true);
            HorizontalLayout leiauteFim = new HorizontalLayout();
            leiauteFim.setSpacing(true);            

            titulo = new Label();
            titulo.setContentMode(Label.CONTENT_XHTML);
            titulo.setValue("<b> Nova Reserva </b>");

            Label as = new Label("  das  ");
            Label as2 = new Label("  até às  ");
            Label di = new Label("Data Inicial e faixa horária: ");
            Label df = new Label("  às  ");
            //Label ddi = new Label("Data ora Inicial");
            Label ddf = new Label("Data Final");

            nomeReserva = new TextField("Nome do Evento");
            solicitante = new TextField("Solicitante");
            //neste setValue vai o nome do solicitante logado no sistema
            solicitante.setValue("Manolo");
            solicitante.setReadOnly(true);
            responsavel = new TextField("Responsável");
            
            repeticao = new OptionGroup("Repetição");
            repeticao.addItem("Diariamente");
            repeticao.addItem("Semanalmente");
            repeticao.addItem("Quinzenalmente");
            repeticao.addItem("Mensalmente");
            //repeticao.setNullSelectionAllowed(false);
            repeticao.setValue("Diariamente");
            
            horaInicio = new NativeSelect();
            minInicio = new NativeSelect();
            horaFim = new NativeSelect();
            minFim = new NativeSelect();
            diaIni = new NativeSelect();
            mesIni = new NativeSelect();
            diaFim = new NativeSelect();
            mesFim = new NativeSelect();
            
            String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro","Novembro", "Dezembro",
            };
            for (int i = 1; i < 32;i++)
            {
                diaIni.addItem(i);
                diaFim.addItem(i);
            }
            for (int i = 1; i < meses.length;i++)
            {
                mesIni.addItem(meses[i]);
                mesFim.addItem(meses[i]);
            }
            
            String[] horas = {
                "00","01","02","03","04","05","06","07","08","09","10","11","12","13",
                "14","15","16","17","18","19","20","21","22","23"
            };
            for (int i = 0; i < horas.length;i++)
            {
                horaInicio.addItem(horas[i]);
                horaFim.addItem(horas[i]);
            }
            
            diaIni.setValue(dia);
            diaIni.setReadOnly(true);
            diaFim.setValue(dia);
            mesIni.setValue(mes);
            mesIni.setReadOnly(true);
            mesFim.setValue(mes);
            
            minInicio.addItem("00");
            minInicio.addItem("30");
            minFim.addItem("00");
            minFim.addItem("30");

            listaSalas = new ComboBox("Sala a reservar");
            listaSalas.setNullSelectionAllowed(false);
            preencheSalas();
            finalidade = new TextField("Finalidade");
            //TextField tipo = new TextField("Tipo");
            salvar = new Button("Salvar");
            salvar.addListener(new EventoAdicionarReserva());
            cancelar = new Button("Cancelar");
            cancelar.addListener(new Button.ClickListener()
            {
            @Override
                public void buttonClick(ClickEvent event)
                {
                    close();
                }
            });

            mainLayout.setSpacing(true);
            mainLayout.addComponent(titulo);
            mainLayout.addComponent(nomeReserva);
            mainLayout.addComponent(finalidade);
            mainLayout.addComponent(solicitante);
            mainLayout.addComponent(responsavel);
            leiauteDia.addComponent(di);
            leiauteDia.addComponent(diaIni);
            leiauteDia.addComponent(mesIni);
            leiauteDia.addComponent(as);
            leiauteDia.addComponent(horaInicio);
            leiauteDia.addComponent(minInicio);           
            leiauteFim.addComponent(ddf);
            leiauteFim.addComponent(diaFim);
            leiauteFim.addComponent(mesFim);
            leiauteDia.addComponent(as2);
            leiauteDia.addComponent(horaFim);
            leiauteDia.addComponent(minFim);
            mainLayout.addComponent(leiauteDia);
            mainLayout.addComponent(leiauteIni);
            mainLayout.addComponent(repeticao);
            mainLayout.addComponent(leiauteFim);
            mainLayout.addComponent(listaSalas);              
            mainLayout.addComponent(salvar);
            mainLayout.addComponent(cancelar);
            this.addComponent(mainLayout);

    }

    public void preencheSalas()
    {
        ArrayList<Recinto> recs = recintoDAO.pesquisar();
        while (!recs.isEmpty())
        {
            listaSalas.addItem(recs.remove(0));
        }
    }



    private class EventoAdicionarReserva implements Button.ClickListener
    {
        @Override
        public void buttonClick(ClickEvent event)
        {
            Reserva re = new Reserva();
            re.setNomeEvento((String) nomeReserva.getValue());
            re.setFinalidade((String)finalidade.getValue());
            re.setResponsavel((String)responsavel.getValue());
            Object dia = diaIni.getValue();
            Object mes = mesIni.getValue();
            String data = dia.toString() + "/" + mes.toString() + "/2011";
            re.setDataInicioEvento(data);
            System.out.println(re.toString() + "  " + data);

        }
    }


}
