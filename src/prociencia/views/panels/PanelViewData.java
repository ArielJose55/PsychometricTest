/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia.views.panels;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prociencia.logic.core.daos.OcupacionDao;
import prociencia.logic.core.daos.PersonaDao;
import prociencia.logic.core.daos.TestDao;
import prociencia.logic.core.entities.Persona;
import prociencia.logic.model.ControlModelAdministrador;
import prociencia.logic.sheetexcels.CreatorPersonExcel;
import prociencia.views.componets.FactoryMessage;
import prociencia.views.dialogs.DialogWait;


/**
 *
 * @author Klac
 */
public class PanelViewData extends javax.swing.JPanel {

    private final Persona persona;
    private final ControlModelAdministrador logicaAdministrador;
    private boolean todoBien = true;
    
    public PanelViewData(Persona persona,ControlModelAdministrador logicaAdministrador) {
        this.persona = persona;
        this.logicaAdministrador = logicaAdministrador;
        initComponents();
        obtenerMoreInformation();
   }

    private void obtenerMoreInformation(){
        espere();
        final Runnable run = new Runnable(){
            public void run(){
//                isWaiting(true);
                
                try {
                    persona.setPrueba(new TestDao().getTest(persona.getCodigo()));
                    persona.setOcupacion(new OcupacionDao().getOcupacion(persona.getCodigo()));
                } catch (java.sql.SQLException ex) {
                    java.util.logging.Logger.getLogger(PanelViewData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    todoBien = false;
                }finally{
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException ex1){}
                    updateData();

                }
            }
        };
        new Thread(run).start();
    }

    private void espere(){
        javax.swing.JLabel eti = new javax.swing.JLabel(new javax.swing.ImageIcon(
                getClass().getResource("/prociencia/views/resources/CircleLoadingEspereWrite.gif")
        ));
        jPanelViewPerson.add(eti, java.awt.BorderLayout.CENTER);
////        jPanelData.updateUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButtonViewResultado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRespuestas = new javax.swing.JTextArea();
        jButtonDataPerson = new javax.swing.JButton();
        jPanelData = new javax.swing.JPanel();
        jButtonVolver = new javax.swing.JButton();
        jToggleButtonProcesado = new javax.swing.JToggleButton();
        jPanelViewPerson = new javax.swing.JPanel();
        jButtonGeneraExcel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("DATOS PERSONALES Y RESULTADOS DE LA PRUEBA");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);

        jButtonViewResultado.setBackground(new java.awt.Color(204, 204, 255));
        jButtonViewResultado.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButtonViewResultado.setForeground(new java.awt.Color(102, 102, 102));
        jButtonViewResultado.setText("Resultados");
        jButtonViewResultado.setBorder(jButton1.getBorder());
        jButtonViewResultado.setBorderPainted(false);
        jButtonViewResultado.setFocusPainted(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jTextAreaRespuestas.setEditable(false);
        jTextAreaRespuestas.setColumns(20);
        jTextAreaRespuestas.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jTextAreaRespuestas.setLineWrap(true);
        jTextAreaRespuestas.setRows(20);
        jTextAreaRespuestas.setWrapStyleWord(true);
        jTextAreaRespuestas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jTextAreaRespuestas.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jTextAreaRespuestas.setSelectionColor(new java.awt.Color(153, 255, 204));
        jTextAreaRespuestas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextAreaRespuestasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaRespuestas);

        jButtonDataPerson.setBackground(new java.awt.Color(204, 204, 255));
        jButtonDataPerson.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jButtonDataPerson.setForeground(new java.awt.Color(102, 102, 102));
        jButtonDataPerson.setText("Información personal");
        jButtonDataPerson.setBorder(jButton1.getBorder());
        jButtonDataPerson.setBorderPainted(false);
        jButtonDataPerson.setFocusPainted(false);

        jPanelData.setBackground(getBackground());
        jPanelData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jButtonVolver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonVolver.setForeground(jButton1.getForeground());
        jButtonVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/icon_PreviusMusic32x32.png"))); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.setBorderPainted(false);
        jButtonVolver.setContentAreaFilled(false);
        jButtonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVolver.setFocusPainted(false);
        jButtonVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/icon_PreviusMusicAdvance32x32.png"))); // NOI18N
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jToggleButtonProcesado.setFont(jButtonVolver.getFont());
        jToggleButtonProcesado.setForeground(jButtonVolver.getForeground());
        jToggleButtonProcesado.setBorder(null);
        jToggleButtonProcesado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButtonProcesado.setFocusPainted(false);
        jToggleButtonProcesado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonProcesadoActionPerformed(evt);
            }
        });

        jPanelViewPerson.setBackground(new java.awt.Color(255, 255, 255));
        jPanelViewPerson.setLayout(new java.awt.BorderLayout());

        jButtonGeneraExcel.setBackground(new java.awt.Color(204, 255, 204));
        jButtonGeneraExcel.setFont(jToggleButtonProcesado.getFont());
        jButtonGeneraExcel.setForeground(jToggleButtonProcesado.getForeground());
        jButtonGeneraExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/excel icon.png"))); // NOI18N
        jButtonGeneraExcel.setText("Generar Excel");
        jButtonGeneraExcel.setEnabled(false);
        jButtonGeneraExcel.setFocusPainted(false);
        jButtonGeneraExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeneraExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDataLayout = new javax.swing.GroupLayout(jPanelData);
        jPanelData.setLayout(jPanelDataLayout);
        jPanelDataLayout.setHorizontalGroup(
            jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataLayout.createSequentialGroup()
                .addGroup(jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGeneraExcel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButtonProcesado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanelViewPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDataLayout.setVerticalGroup(
            jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButtonProcesado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGeneraExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelViewPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(204, 204, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonViewResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDataPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDataPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButtonViewResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addGap(11, 11, 11))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextAreaRespuestasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaRespuestasFocusGained
        jTextAreaRespuestas.selectAll();
    }//GEN-LAST:event_jTextAreaRespuestasFocusGained

    private void jToggleButtonProcesadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonProcesadoActionPerformed
        final javax.swing.JToggleButton button = (javax.swing.JToggleButton) evt.getSource();
//        isWaiting(true);
        Runnable run =  new Runnable(){
            public void run(){
                try {
                    new PersonaDao().uptateProcessPerson(persona.getCodigo(), button.isSelected());
                    uptateProcess(button.isSelected());
                    persona.setProcesado(button.isSelected());
                } catch (java.sql.SQLException ex) {
                    javax.swing.JOptionPane.showMessageDialog(button,"operación no pudo se realizada","Error de conexion",javax.swing.JOptionPane.WARNING_MESSAGE);
                }finally{
//                    isWaiting(false);
                }
            }
        };
        new Thread(run).start();
    }//GEN-LAST:event_jToggleButtonProcesadoActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        logicaAdministrador.changedViewAtMode();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonGeneraExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGeneraExcelActionPerformed
        final java.io.File parent;
        try{
            parent = createAndGetFileChooser();
        }catch(Exception ex){
            ex.printStackTrace();
            return;
        }
        final Runnable run = new Runnable(){
            public void run(){
                CreatorPersonExcel creator = new CreatorPersonExcel(persona);
                try {
                    creator.startWriting(parent);
                    FactoryMessage.createMessageInformation(PanelViewData.class, "writeOK");
                } catch (Exception ex) {
                    Logger.getLogger(PanelViewData.class.getName()).log(Level.SEVERE, null, ex);
                    FactoryMessage.createMessageAlert(PanelViewData.class, "writeOFF");
                }
            }
        };
        new Thread(run).start();
    }//GEN-LAST:event_jButtonGeneraExcelActionPerformed

    
    
    public void uptateProcess(boolean select){
        if(select){
            jToggleButtonProcesado.setText("Procesado");
            jToggleButtonProcesado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/Procesado.png")));
            jToggleButtonProcesado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GREEN));
        }else{
            jToggleButtonProcesado.setText("No Procesado");
            jToggleButtonProcesado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/NoProcesado.png")));
            jToggleButtonProcesado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
        }
    }
    
    private void updateData(){
        jPanelViewPerson.removeAll();
        if(todoBien){
            jTextAreaRespuestas.setText(persona.getPrueba().getRespuestas());
            if(!persona.isProcesado()){
                jToggleButtonProcesado.setText("No Procesado");
                jToggleButtonProcesado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/NoProcesado.png")));
                jToggleButtonProcesado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
                jToggleButtonProcesado.setSelected(false);
            }else{
                jToggleButtonProcesado.setText("Procesado");
                jToggleButtonProcesado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/Procesado.png")));
                jToggleButtonProcesado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
                jToggleButtonProcesado.setSelected(true);
            }
            jPanelViewPerson.add(new PanelViewDataPerson(persona),java.awt.BorderLayout.CENTER);
            jPanelViewPerson.updateUI();
            jButtonGeneraExcel.setEnabled(todoBien);
        }else{
            jButtonViewResultado.setText("No Resultados");
            jButtonDataPerson.setText("Error al mostrar la información personal");
            jToggleButtonProcesado.setText("No Resultdo");
            jToggleButtonProcesado.setEnabled(false);
        }
    }

    public java.io.File createAndGetFileChooser() throws Exception {
        
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        if(fileChooser.showSaveDialog(PanelViewData.this) == javax.swing.JFileChooser.APPROVE_OPTION){
            return  fileChooser.getSelectedFile();
        }
        throw new Exception();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDataPerson;
    private javax.swing.JButton jButtonGeneraExcel;
    private javax.swing.JButton jButtonViewResultado;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JPanel jPanelData;
    private javax.swing.JPanel jPanelViewPerson;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaRespuestas;
    private javax.swing.JToggleButton jToggleButtonProcesado;
    // End of variables declaration//GEN-END:variables
}
