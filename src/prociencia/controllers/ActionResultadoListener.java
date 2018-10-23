/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import prociencia.logic.core.entities.Persona;
import prociencia.logic.model.ControlModel;

/**
 *
 * @author Klac
 */
public class ActionResultadoListener implements ActionListener{

    private final Persona estudiante;

    public ActionResultadoListener(Persona row) {
        this.estudiante = row;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        ControlModel.getInstance().getPanelViewResultado().setjLabelNombre(estudiante.getNombres());
//        ControlModel.getInstance().getPanelViewResultado().setjLabelApellidos(estudiante.getApellidos());
//        ControlModel.getInstance().getPanelViewResultado().setjTextArea1((estudiante.getPrueba() == null)?  estudiante.getNombres()+" no realizó la Test":estudiante.getPrueba().getRespuestas());
    }
    
}
