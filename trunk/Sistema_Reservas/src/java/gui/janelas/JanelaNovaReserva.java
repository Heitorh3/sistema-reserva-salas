/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 *
 * @author 0213101
 */
public class JanelaNovaReserva extends Window{
    Panel principal;
    Panel sala;
    Panel labelResponsavel;
    TextField nomeReserva;
    TextField solicitante;
    NativeSelect NSresponsavel;
    TextField tfDia;
    TextField tfMes;
    TextField aAno;
    NativeSelect NSsala;
    Label numeroSala;
    Label localizacaoSala;
    Label tipoSala;
    ComboBox recsSala;

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


            principal = new Panel();
            HorizontalLayout leiaute = new HorizontalLayout();
            nomeReserva = new TextField("Nome do Evento");
            solicitante = new TextField("Solicitante");
            //neste setValue vai o nome do solicitante logado no sistema
            solicitante.setValue("Manolo");
            NSresponsavel = new NativeSelect("Responsável");
            tfDia = new TextField("Dia");
            tfDia.setValue(Integer.toString(dia));
            tfDia.setReadOnly(true);

            tfMes = new TextField("Mes");
            tfMes.setValue(mes);
            tfMes.setReadOnly(true);

            this.addComponent(nomeReserva);
            this.addComponent(solicitante);
            this.addComponent(NSresponsavel);
            leiaute.addComponent(tfDia);
            leiaute.addComponent(tfMes);
            //leiaute.addComponent(aAno);
            //leiaute.setSizeFull();
            this.addComponent(leiaute);
        

    }


}
