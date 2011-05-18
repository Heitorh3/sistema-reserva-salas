/*
 * JanelaPrincipal.java
 *
 * Created on 11 de Maio de 2011, 09:21
 */
 
package gui;

import classes.Reserva;
import com.vaadin.Application;
import com.vaadin.ui.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/** 
 *
 * @author 0213101
 * @version 
 */

public class JanelaPrincipal extends Application {

    @Override
    public void init() {
	
        /* INICIALIZACAO DO PRIMEIRO MES QUE APARECERA NA TELA
         * PODERIA COMECAR POR JANEIRO, MAS EH MAIS PRATICO COMECAR
         * MOSTRANDO O MES Q ESTAMOS.
         */
        ArrayList<Reserva> reservas = new ArrayList();  //AQUI VAI TODOS OS EVENTOS Q VIRAO DO BD

        Date data = new Date();
        Calendar calendAtual = new GregorianCalendar();
        calendAtual.setTime(data);
        int mesAtual = calendAtual.get(Calendar.MONTH);

        //este vetor será o calendário que contera os dias
        Calendario calendario = new Calendario(reservas,mesAtual);


        /* INICIO DA INTERFACE */
        Window mainWindow = new Window("Sistema de Reserva de Salas");
        Label lInicio = new Label("<b>Sistema de Reserva de Salas 2011</b>",Label.CONTENT_XHTML);
        Button botaoNovaReserva = new Button();
        botaoNovaReserva.setCaption("Nova Reserva");
        Button botaoConsulta = new Button();
        botaoConsulta.setCaption("Consultar Salas");

        setMainWindow(mainWindow);

        HorizontalLayout layoutLateral = new HorizontalLayout();
        VerticalLayout layoutVert = new VerticalLayout();
        layoutVert.addComponent(lInicio);
        layoutLateral.addComponent(botaoNovaReserva);
        layoutLateral.addComponent(botaoConsulta);
        //layoutLateral.setComponentAlignment(lInicio, Alignment.MIDDLE_CENTER);


        //JanelaLogin janelaLogin = new JanelaLogin();




        mainWindow.addComponent(layoutVert);
        mainWindow.addComponent(layoutLateral);
        //mainWindow.addWindow(janelaLogin);
        
        
        
        

        


        
    }

}
