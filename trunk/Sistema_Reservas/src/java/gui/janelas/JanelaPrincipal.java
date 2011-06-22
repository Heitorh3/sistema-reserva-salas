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

        mainWindow = new Window("Sistema de Reserva de Salas");
        

        VerticalLayout mainLayout1 = new VerticalLayout();
        HorizontalLayout mainLayout2 = new HorizontalLayout();

        PainelBotoes pb = new PainelBotoes();
        PainelCalendario pc = new PainelCalendario();


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
