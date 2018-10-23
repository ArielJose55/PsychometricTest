/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia.controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JToggleButton;

/**
 *
 * @author Klac
 */
public class MouseMoveListener extends MouseAdapter{

    private Color colorOriginal;
    
    @Override
    public void mouseEntered(MouseEvent e) {
        JToggleButton component = (JToggleButton) e.getComponent();
        if(component.isSelected()){
            component.setBackground(colorOriginal);
            return;
        }
        colorOriginal = component.getBackground();
        component.setBackground(new Color(244,244,255));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JToggleButton component = (JToggleButton) e.getComponent();
        if(component.isSelected()){
            component.setBackground(colorOriginal);
            return;
        }
        component.setBackground(colorOriginal);
    }
}
