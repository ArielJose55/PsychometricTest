/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia.controllers;

import prociencia.logic.model.ControlModel;
import prociencia.views.panels.PanelRegistroEstudiante;
import prociencia.views.panels.PanelTest;


/**
 *
 * @author Klac
 */
public class ChangedSelectionListener implements javax.swing.event.ChangeListener{
    
    private final ControlModel logica = ControlModel.getInstance();
    
        
    @Override
    public void stateChanged(javax.swing.event.ChangeEvent e) {
        javax.swing.JToggleButton boton = (javax.swing.JToggleButton) e.getSource();
        if(boton.isSelected()){
            logica.getPanelWokr().removeAll();
            logica.waiting();
            cambiarPanel(boton.getText());
        }
    }
    
    private void cambiarPanel(final String comando){
        final Runnable run = new Runnable(){
            public void run(){
                if(comando.compareTo("Formulario de Registro") == 0){
                    logica.establacerPanelActual(new PanelRegistroEstudiante());
                }else if(comando.compareTo("Realizar Test") == 0){
                        logica.establacerPanelActual(new PanelTest());
                }
            }
        };

        Thread hilito=new Thread(run);
        hilito.start();
    }
    
}
