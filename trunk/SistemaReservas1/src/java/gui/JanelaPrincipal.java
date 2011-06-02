/*
 * JanelaPrincipal.java
 *
 * Created on 11 de Maio de 2011, 09:21
 */
 
package gui;

import classes.Reserva;
import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
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

    private Window mainWindow;

    @Override
    public void init() {
	
        /* INICIALIZACAO DO PRIMEIRO MES QUE APARECERA NA TELA
         * PODERIA COMECAR POR JANEIRO, MAS EH MAIS PRATICO COMECAR
         * MOSTRANDO O MES Q ESTAMOS.
         */
        ArrayList<Reserva> reservas = new ArrayList();  //AQUI VAI TODOS OS EVENTOS Q VIRAO DO BD

        Date data = new Date();


        
        //Calendar calendAtual = new GregorianCalendar();
        //calendAtual.setTime(data);
        //int mesAtual = calendAtual.get(Calendar.MONTH) + 1; //pois comeca do 0, janeiro -> 0
        
        //System.out.println("Mes atual = " + mesAtual);

        //este vetor será o calendário que contera os dias
        //PainelCalendario calendario = new PainelCalendario(reservas,Calendar.MONTH);
        //calendario.setData(data);


        /* INICIO DA INTERFACE */        

        mainWindow = new Window("Sistema de Reserva de Salas");
        

        VerticalLayout mainLayout1 = new VerticalLayout();
        HorizontalLayout mainLayout2 = new HorizontalLayout();

        mainLayout1.addComponent(new PainelBotoes());
        mainLayout2.addComponent(new PainelCalendario(reservas,Calendar.MONTH));
        mainLayout2.addComponent(new PainelDisplayReservas());
        

        setMainWindow(mainWindow);

        mainWindow.addComponent(mainLayout1);
        mainWindow.addComponent(mainLayout2);
        
    }

    

}
