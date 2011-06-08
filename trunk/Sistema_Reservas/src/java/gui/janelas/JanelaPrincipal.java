/*
 * JanelaPrincipal.java
 *
 * Created on 11 de Maio de 2011, 09:21
 */
 
package gui.janelas;

import gui.paineis.PainelBotoes;
import gui.paineis.PainelCalendario;
import entidades.Reserva;
import com.vaadin.Application;
import com.vaadin.ui.*;
import java.util.ArrayList;
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

        PainelBotoes pb = new PainelBotoes(mainWindow);
        PainelCalendario pc = new PainelCalendario(reservas,mainWindow);


        mainLayout1.addComponent(pb);
        mainLayout1.setComponentAlignment(pb, Alignment.TOP_CENTER);
        mainLayout1.addComponent(pc);
        mainLayout1.setComponentAlignment(pc, Alignment.TOP_CENTER);
        mainLayout2.addComponent(mainLayout1);
        //mainLayout2.
        mainLayout2.setComponentAlignment(mainLayout1, Alignment.MIDDLE_CENTER);
        //mainLayout2.addComponent(new PainelDisplayReservas(mainWindow));
        //PainelCalendario pc = new PainelCalendario(reservas,mainWindow);
        //pc.

        setMainWindow(mainWindow);

        //mainWindow.addComponent(mainLayout1);
        mainWindow.addComponent(mainLayout2);
        
    }

    

}
