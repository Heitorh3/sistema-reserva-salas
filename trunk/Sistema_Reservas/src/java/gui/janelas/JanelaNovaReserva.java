/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author 0213101
 */
public class JanelaNovaReserva extends Window{
    
    Panel sala;
    Panel labelResponsavel;
    TextField nomeReserva;
    TextField solicitante;
    NativeSelect NSresponsavel;
    TextField tfDia;
    TextField tfMes;
    TextField aAno;
    NativeSelect NSsala;
    Label dataInicial;
    Label dataFinal;
    Label tipoSala;
    ComboBox recsSala;
    Label diaInicial;
    OptionGroup repeticao;
    Button salvar;
    Button cancelar;

    /*
     * A fábrica não tem trabalho megafoda, a gente que torna o trabalho
     * megafoda pra valorizar.
     * - Cabeceia
     */
    public JanelaNovaReserva(int dia, String mes)
    {
        
            this.setModal(true);
            this.setWidth("50%");
            this.setHeight("50%");
            this.center();

            VerticalLayout mainLayout = new VerticalLayout();
            HorizontalLayout leiauteDia = new HorizontalLayout();
            HorizontalLayout leiauteIni = new HorizontalLayout();
            leiauteIni.setSpacing(true);
            HorizontalLayout leiauteFim = new HorizontalLayout();
            leiauteFim.setSpacing(true);            
            
            dataInicial = new Label("Data Inicial:");
            dataFinal = new Label  ("Data Final:");
            nomeReserva = new TextField("Nome do Evento");
            solicitante = new TextField("Solicitante");
            //neste setValue vai o nome do solicitante logado no sistema
            solicitante.setValue("Manolo");
            solicitante.setReadOnly(true);
            NSresponsavel = new NativeSelect("Responsável");
            
            repeticao = new OptionGroup("Repetição");
            repeticao.addItem("Diariamente");
            repeticao.addItem("Semanalmente");
            repeticao.addItem("Quinzenalmente");
            repeticao.addItem("Mensalmente");
            
            NativeSelect horaInicio = new NativeSelect();
            NativeSelect minInicio = new NativeSelect();
            NativeSelect horaFim = new NativeSelect();
            NativeSelect minFim = new NativeSelect();
            NativeSelect diaIni = new NativeSelect();
            NativeSelect mesIni = new NativeSelect();
            NativeSelect diaFim = new NativeSelect();
            NativeSelect mesFim = new NativeSelect();
            
            String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro","Novembro", "Dezembro",
            };
            for (int i = 0; i < 32;i++)
            {
                diaIni.addItem(i);
                diaFim.addItem(i);
            }
            for (int i = 0; i < meses.length;i++)
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
            mesIni.setValue(mes);
            mesIni.setReadOnly(true);
            
            minInicio.addItem("00");
            minInicio.addItem("30");
            minFim.addItem("00");
            minFim.addItem("30");
            
            TextField finalidade = new TextField("Finalidade");
            TextField tipo = new TextField("Tipo");
            salvar = new Button("Salvar");
            cancelar = new Button("Salvar");            
            
            
            mainLayout.setSpacing(true);
            mainLayout.addComponent(nomeReserva);            
            mainLayout.addComponent(solicitante);
            mainLayout.addComponent(NSresponsavel);
            leiauteDia.addComponent(diaIni);
            leiauteDia.addComponent(mesIni);
            //leiauteIni.addComponent(dataInicial);
            leiauteDia.addComponent(horaInicio);
            leiauteDia.addComponent(minInicio);
            //leiauteFim.addComponent(dataFinal);            
            leiauteFim.addComponent(diaFim);
            leiauteFim.addComponent(mesFim);
            leiauteFim.addComponent(horaFim);
            leiauteFim.addComponent(minFim);
            mainLayout.addComponent(leiauteDia);
            mainLayout.addComponent(leiauteIni);
            mainLayout.addComponent(leiauteFim);
            mainLayout.addComponent(finalidade);            
            mainLayout.addComponent(tipo);
            mainLayout.addComponent(repeticao);
            mainLayout.addComponent(salvar);
            mainLayout.addComponent(cancelar);
            this.addComponent(mainLayout);

    }


}
