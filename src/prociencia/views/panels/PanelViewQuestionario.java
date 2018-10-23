
package prociencia.views.panels;

import prociencia.logic.core.daos.PersonaDao;
import prociencia.logic.core.daos.WriteWorkConnection;
import prociencia.logic.core.entities.Persona;
import prociencia.logic.core.entities.Pregunta;
import prociencia.logic.core.entities.Test;
import prociencia.logic.core.util.tads.Observador;
import prociencia.logic.core.util.test.LectorQuestionario;
import prociencia.logic.model.ControlModel;

/**
 *
 * @author Klac
 */
public class PanelViewQuestionario extends javax.swing.JPanel{

    private  java.util.List<Pregunta> PREGUNTAS;
    private final java.awt.Font FONT = new java.awt.Font("Tahoma",java.awt.Font.PLAIN,22);
    private final javax.swing.JScrollPane scrollPane;
    
    public PanelViewQuestionario(javax.swing.JScrollPane scrollPane){
        this.scrollPane = scrollPane;
        this.scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        try {
            PREGUNTAS = LectorQuestionario.getPreguntas();
        } catch (Exception ex) {
            PREGUNTAS = new java.util.ArrayList<Pregunta>();
        }
        initComponentes();
    } 
    
    private void initComponentes(){
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        add(createPanelTitle());
        for (int i = 0 ; i < PREGUNTAS.size() ; i++) {
            PanelQuestionario panelQ = new PanelQuestionario(PREGUNTAS.get(i),scrollPane);
            panelQ.setPositionIndex(i+1);
            add(panelQ);
        }
 
        add(createPanelVerifica());
    }
    
    private javax.swing.JPanel createPanelTitle(){
        final ControlModel logica = ControlModel.getInstance();
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridBagLayout());
        javax.swing.JLabel eti = new javax.swing.JLabel(logica.getPersona().getNombreCompleto());
        eti.setFont(FONT.deriveFont(0, 18f));
        java.awt.GridBagConstraints conf = new java.awt.GridBagConstraints();
        conf.gridx = 0;
        conf.gridy = 0;
        conf.insets = new java.awt.Insets(20, 10, 5, 10);
        conf.anchor = java.awt.GridBagConstraints.WEST;
        panel.add(eti,conf);
        
        return panel;
        
    }
    
    private javax.swing.JPanel createPanelVerifica(){
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridBagLayout());
        panel.setPreferredSize(new java.awt.Dimension(20, 120));
        javax.swing.JButton boton = new javax.swing.JButton("Enviar");
        boton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        boton.setBackground(new java.awt.Color(204,204,255));
        boton.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.CYAN, 1));
        boton.setFocusPainted(false);
        boton.setFont(FONT);
        
        java.awt.GridBagConstraints confi = new java.awt.GridBagConstraints();
        confi.ipadx = 100;
        confi.ipady = 26;
        
        boton.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            final java.util.List<Short> lista = new java.util.ArrayList<Short>();
            boolean todoBien = true;
            StringBuilder SB = new StringBuilder();
            short j = 1; 
            for (java.awt.Component compo : PanelViewQuestionario.this.getComponents()) {
                if(compo instanceof PanelQuestionario){
//                    ((PanelQuestionario)compo).azar();
                    int i = ((PanelQuestionario)(compo)).getRespuesta();
                    if(i < 0){
                        ((PanelQuestionario)(compo)).setVerificado(false);
                        todoBien = false;
                        lista.add(j);  
                    }
                    if(i == 1){
                        SB.append("1");
                    }else if(i == 2){
                        SB.append("2");
                    }else{
                        SB.append(3);
                    }
                    j++;
                }
            }
            if(todoBien){
                Persona persona = ControlModel.getInstance().getPersona();
                Test test = new Test();
                test.setRespuestas(SB.toString());
                persona.setPrueba(test);
                if(ControlModel.isWorkConnection()){
                    try {
                        WriteWorkConnection.getInstance().writeStudent(persona);
                            Observador.getInstance().notifyObservers(2);
                            javax.swing.JOptionPane.showMessageDialog(PanelViewQuestionario.this, "Gracias por Realizar el Test");
                        
                        
                    } catch (Exception ex) {
                        javax.swing.JOptionPane.showMessageDialog(PanelViewQuestionario.this,"No Prueba no pudo ser registrada."
                                    + "\nPor intentelo más tarde!","Error de escritura",javax.swing.JOptionPane.WARNING_MESSAGE);
                        java.util.logging.Logger.getLogger(PanelViewQuestionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }else{
                    PersonaDao personaDao = new PersonaDao();
                    try {
                        personaDao.registrarEstudiante(persona);
                        Observador.getInstance().notifyObservers(2);
                        javax.swing.JOptionPane.showMessageDialog(PanelViewQuestionario.this, "Gracias por Realizar el Test");
                    } catch (java.sql.SQLException ex) {
                        javax.swing.JOptionPane.showMessageDialog(null, "<html>"
                                + "<h3>Ooops! conexión no establecida con la base da datos<br/>"
                                + "Por favor, intentelo más tarde.<h3/><p style = 'color = rgb(255,0,0)'>Nota:"
                                + " Si el problema persiste, le recomendamos que trabaje sin conexion a internet</p>"
                                + "</html>","Conexión Fallida",javax.swing.JOptionPane.WARNING_MESSAGE);
                    }
                }
            }else{
                StringBuilder sb = new StringBuilder("Las Siguientes Preguntas NO fueron respondidas:");
                for (short corto : lista) {
                    sb.append("\nPregunta N°:");
                    sb.append(corto);
                }
                javax.swing.JOptionPane.showMessageDialog(PanelViewQuestionario.this, sb.toString(),"Preguntas no respondidas",javax.swing.JOptionPane.WARNING_MESSAGE);
            }
            }});
        panel.add(boton,confi);
        return panel;
    }
}
