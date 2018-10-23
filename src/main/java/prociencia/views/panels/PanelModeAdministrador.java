
package prociencia.views.panels;

import java.util.logging.Level;
import java.util.logging.Logger;
import prociencia.logic.core.daos.PersonaDao;
import prociencia.logic.core.entities.Ocupacion;
import prociencia.logic.core.entities.OcupacionEnum;
import prociencia.logic.core.entities.Persona;
import prociencia.logic.core.entities.Test;
import prociencia.logic.core.util.tads.ComboBoxModelTad;
import prociencia.logic.core.util.tads.TableModelData;
import prociencia.logic.model.ControlModel;
import prociencia.logic.model.ControlModelAdministrador;
import prociencia.logic.sheetexcels.WriterExcel;
import prociencia.views.componets.FactoryMessage;
import prociencia.views.componets.table.FactoryColumnModel;
import prociencia.views.componets.list.FactoryCellListRenderer;

 
public class PanelModeAdministrador extends javax.swing.JPanel {

    private final ControlModelAdministrador logicaAdministrador = ControlModel.getInstance().getControlModelAdministrador();
    private String lastSearch;
    
    public PanelModeAdministrador() {
        initComponents();
        logicaAdministrador.setPanelCenter(jPanelCenter);
        logicaAdministrador.setPanelViewTable(jScrollPane1);
    }

    private void setWaiting(int process , boolean espere){
        if(process == 0){
            if(espere){
                jLabelProcessExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/728_48x48.gif")));
            }else{
                jLabelProcessExcel.setIcon(null);
            }
        }else{
            if(espere){
                jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/728_48x48.gif")));
            }else{
                jLabelDelete.setIcon(null);
            }
        }
    }
    
    public ComboBoxModelTad getComboxBoxModelTad(){
        return ((ComboBoxModelTad)jComboBoxFecha.getModel());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelNort = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterName = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanelWest = new javax.swing.JPanel();
        jButtonTitleFilter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonGenerarInforme = new javax.swing.JButton();
        jLabelProcessExcel = new javax.swing.JLabel();
        jComboBoxOcupacion = new javax.swing.JComboBox();
        jComboBoxFecha = new javax.swing.JComboBox();
        jLabelCountStudent = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jLabelDelete = new javax.swing.JLabel();
        jPanelCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));
        setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        jPanelNort.setBackground(getBackground());
        jPanelNort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNortMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/Magnifier.png"))); // NOI18N

        jTextFieldFilterName.setFont(getFont());
        jTextFieldFilterName.setForeground(getForeground());
        jTextFieldFilterName.setText("Buscar por nombres");
        jTextFieldFilterName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextFieldFilterName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFilterNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFilterNameFocusLost(evt);
            }
        });
        jTextFieldFilterName.addKeyListener(new PJKeyAdapter());

        jCheckBox1.setBackground(getBackground());
        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jCheckBox1.setForeground(jTextFieldFilterName.getForeground());
        jCheckBox1.setText("Mostrar No Procesados");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.setFocusPainted(false);
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelNortLayout = new javax.swing.GroupLayout(jPanelNort);
        jPanelNort.setLayout(jPanelNortLayout);
        jPanelNortLayout.setHorizontalGroup(
            jPanelNortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNortLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelNortLayout.setVerticalGroup(
            jPanelNortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNortLayout.createSequentialGroup()
                .addGroup(jPanelNortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanelNort, gridBagConstraints);

        jPanelWest.setBackground(getBackground());
        jPanelWest.setMaximumSize(new java.awt.Dimension(300, 32767));
        jPanelWest.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanelWest.setPreferredSize(new java.awt.Dimension(300, 434));

        jButtonTitleFilter.setBackground(new java.awt.Color(204, 255, 204));
        jButtonTitleFilter.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jButtonTitleFilter.setForeground(new java.awt.Color(102, 153, 255));
        jButtonTitleFilter.setText("FILTROS");
        jButtonTitleFilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonTitleFilter.setBorderPainted(false);
        jButtonTitleFilter.setFocusPainted(false);

        jButton2.setBackground(jButtonTitleFilter.getBackground());
        jButton2.setFont(jButtonTitleFilter.getFont());
        jButton2.setForeground(jButtonTitleFilter.getForeground());
        jButton2.setText("OPERACIONES");
        jButton2.setBorder(jButtonTitleFilter.getBorder());
        jButton2.setBorderPainted(jButtonTitleFilter.isBorderPainted());
        jButton2.setFocusPainted(jButtonTitleFilter.isFocusPainted());

        jButtonGenerarInforme.setBackground(new java.awt.Color(204, 204, 255));
        jButtonGenerarInforme.setFont(new java.awt.Font("Arial", 0, 17)); // NOI18N
        jButtonGenerarInforme.setForeground(new java.awt.Color(102, 102, 102));
        jButtonGenerarInforme.setText("Generar Informe");
        jButtonGenerarInforme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        jButtonGenerarInforme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGenerarInforme.setFocusPainted(false);
        jButtonGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarInformeActionPerformed(evt);
            }
        });

        jComboBoxOcupacion.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jComboBoxOcupacion.setForeground(new java.awt.Color(102, 102, 102));
        jComboBoxOcupacion.setModel(new ComboBoxModelTad(0));
        jComboBoxOcupacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBoxOcupacion.setRenderer(FactoryCellListRenderer.createListCellRenderer());
        jComboBoxOcupacion.setSelectedIndex(0);
        jComboBoxOcupacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOcupacionItemStateChanged(evt);
            }
        });

        jComboBoxFecha.setFont(jComboBoxOcupacion.getFont());
        jComboBoxFecha.setForeground(jComboBoxOcupacion.getForeground());
        jComboBoxFecha.setModel(new ComboBoxModelTad(1));
        jComboBoxFecha.setBorder(jComboBoxOcupacion.getBorder());
        jComboBoxFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxFecha.setLightWeightPopupEnabled(false);
        jComboBoxFecha.setRenderer(FactoryCellListRenderer.createListCellRenderer());
        jComboBoxFecha.setSelectedIndex(0);
        jComboBoxFecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxFechaItemStateChanged(evt);
            }
        });

        jLabelCountStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCountStudent.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jButtonDelete.setBackground(new java.awt.Color(255, 204, 204));
        jButtonDelete.setFont(jButtonGenerarInforme.getFont());
        jButtonDelete.setForeground(jButtonGenerarInforme.getForeground());
        jButtonDelete.setText("Eliminar");
        jButtonDelete.setBorder(jButtonGenerarInforme.getBorder());
        jButtonDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelWestLayout = new javax.swing.GroupLayout(jPanelWest);
        jPanelWest.setLayout(jPanelWestLayout);
        jPanelWestLayout.setHorizontalGroup(
            jPanelWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelWestLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jButtonTitleFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelCountStudent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelWestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxOcupacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelWestLayout.createSequentialGroup()
                        .addGroup(jPanelWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelWestLayout.createSequentialGroup()
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelWestLayout.createSequentialGroup()
                                .addComponent(jButtonGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelProcessExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelWestLayout.setVerticalGroup(
            jPanelWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWestLayout.createSequentialGroup()
                .addComponent(jButtonTitleFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGenerarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProcessExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabelCountStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 1.0;
        add(jPanelWest, gridBagConstraints);

        jPanelCenter.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(ControlModel.getInstance().getTableModel());
        jTable1.setFillsViewportHeight(true);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(230, 240, 245));
        jTable1.setRowSorter(logicaAdministrador.getTableRowSorter());
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" registro(s)");
        jTable1.setColumnModel(FactoryColumnModel.createModelColumnTableMain());
        jTable1.setShowGrid(false);

        jPanelCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanelCenter, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON1 && evt.getClickCount() == 2){


             int i = jTable1.getSelectedRow();
             if( jTable1.getSelectedRowCount() == 1 && i >= 0 ){
                 i = ((javax.swing.table.TableRowSorter)jTable1.getRowSorter()).convertRowIndexToModel(i);
               changedModeAtView(((TableModelData)jTable1.getModel()).getPersona(i));
//                 changedModeAtView(createPerson());
             }

        }else if(evt.getButton() == java.awt.event.MouseEvent.BUTTON3 && evt.getClickCount() == 1){
            createPopupMenu().show(jTable1, evt.getX(), evt.getY());
        }else if(evt.getButton() == java.awt.event.MouseEvent.BUTTON1 && evt.getClickCount() == 1){
            int i = jTable1.getSelectedRow();
            if(i >= 0){
                if(!jButtonGenerarInforme.isEnabled()){
                    jButtonGenerarInforme.setEnabled(i >= 0);
//                    jButtonDeleteRow.setEnabled(i >= 0);
                }
            }else{
                if(jButtonGenerarInforme.isEnabled()){
                    jButtonGenerarInforme.setEnabled(i >= 0);
//                    jButtonDeleteRow.setEnabled(i >= 0);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarInformeActionPerformed
       final java.io.File file;
        try{
           checkTableSelectionEmply(true);
           file = createAndGetFileChooser();
       }catch(RuntimeException ex){
           java.awt.Toolkit.getDefaultToolkit().beep();
           try{checkTableSelectionEmply(false);}catch(RuntimeException ex2){}
           return;
       }
       Runnable run = new Runnable(){
            @Override
            public void run(){
                
              int option = javax.swing.JOptionPane.showConfirmDialog(PanelModeAdministrador.this, "¿Marcar todos los registros seleccionados como procesados?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION, 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, null);
              setWaiting(0,true);
              try {
                    java.util.List<Persona> list = getListFromModel();
                    new WriterExcel(file,list,option == javax.swing.JOptionPane.YES_OPTION).startWriting();
                    if(option == javax.swing.JOptionPane.YES_OPTION){
                        for(Persona person : list){
                            person.setProcesado(Boolean.TRUE);
                        }
                        ((TableModelData)jTable1.getModel()).fireTableDataChanged();
                    }
              } catch (Exception ex) {
                    Logger.getLogger(PanelModeAdministrador.class.getName()).log(Level.SEVERE, null, ex);
              }finally{
                    setWaiting(0,false);
                    try{checkTableSelectionEmply(false);}catch(RuntimeException ex){}
              }  
            }
        };
        new Thread(run).start();
    }//GEN-LAST:event_jButtonGenerarInformeActionPerformed

    private void jPanelNortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNortMouseClicked
        if(evt.getButton() == java.awt.event.MouseEvent.BUTTON1){
            jTextFieldFilterName.requestFocus();
            jTextFieldFilterName.setCaretPosition(0);
        }
    }//GEN-LAST:event_jPanelNortMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        logicaAdministrador.setFilterProcess(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED);
        logicaAdministrador.startFiltering();
        jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" registro(s)");
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jComboBoxOcupacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOcupacionItemStateChanged
        if(evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
            logicaAdministrador.setFilterOcupation((jComboBoxOcupacion.getSelectedItem().toString().compareTo("Seleccione una Ocupación") == 0)?
                    null:jComboBoxOcupacion.getSelectedItem().toString());
            logicaAdministrador.startFiltering();
            jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" registro(s)");
        }
    }//GEN-LAST:event_jComboBoxOcupacionItemStateChanged

    private void jComboBoxFechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxFechaItemStateChanged
        if(evt.getStateChange() ==  java.awt.event.ItemEvent.SELECTED){
            logicaAdministrador.setFilterDate((jComboBoxFecha.getSelectedItem().toString().compareTo("Seleccione una Fecha") == 0)?
                    null:jComboBoxFecha.getSelectedItem().toString());
            logicaAdministrador.startFiltering();
            jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" registro(s)");
        }
    }//GEN-LAST:event_jComboBoxFechaItemStateChanged

    private void jTextFieldFilterNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFilterNameFocusGained
        if(lastSearch != null && lastSearch.compareTo("") != 0){
            jTextFieldFilterName.setText(lastSearch);
            jTextFieldFilterName.selectAll();
        }else{
            jTextFieldFilterName.setCaretPosition(0);
        }
        
    }//GEN-LAST:event_jTextFieldFilterNameFocusGained

    private void jTextFieldFilterNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFilterNameFocusLost
        lastSearch = jTextFieldFilterName.getText();
        jTextFieldFilterName.setText("Buscar por nombres");
    }//GEN-LAST:event_jTextFieldFilterNameFocusLost

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try{
           checkTableSelectionEmply(true);
        }catch(RuntimeException ex){
           java.awt.Toolkit.getDefaultToolkit().beep();
           return;
        }
        Runnable run = new Runnable() {

            @Override
            public void run() {
                int option = javax.swing.JOptionPane.showConfirmDialog(PanelModeAdministrador.this, "¿Esta realmente seguro de eliminar estos registros?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION, 
                            javax.swing.JOptionPane.QUESTION_MESSAGE, null);
                setWaiting(1,true);
                try{
                    if(option == javax.swing.JOptionPane.YES_OPTION){
                        PersonaDao personDao = new PersonaDao();
                        personDao.removeEstudiantes(getListFromModel());
                        ControlModel.getInstance().getConsultor().despertar();
                        ((ComboBoxModelTad)jComboBoxFecha.getModel()).update();
                    }
                }catch(java.sql.SQLException ex){
                    Logger.getLogger(PanelModeAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    setWaiting(1,false);
                    try{checkTableSelectionEmply(false);}catch(RuntimeException ex){}
                }
            }
        };
        new Thread(run).start();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        if(evt.getPropertyName().equals("changedPanel")){
            javax.swing.JScrollPane scrollPane = (javax.swing.JScrollPane)evt.getOldValue();
            jPanelCenter.remove(scrollPane);
            javax.swing.JPanel panel = (javax.swing.JPanel)evt.getNewValue();
            jPanelCenter.add(panel,java.awt.BorderLayout.CENTER);
            jPanelCenter.updateUI();
        }
    }//GEN-LAST:event_formPropertyChange

    public void checkTableSelectionEmply(boolean select){
        if(jTable1.getRowCount() == 0){
            throw new RuntimeException("");
        }
        if(select){
            jTable1.selectAll();
        }else{
            jTable1.getSelectionModel().clearSelection();
        }
    }
    
    private java.util.List<Persona> getListFromModel(){
        java.util.List<Persona> list = new java.util.ArrayList<Persona>();
        int indexs[] = jTable1.getSelectedRows();
        for(int i = 0 ; i < indexs.length ; i++)
            list.add(((TableModelData)jTable1.getModel()).getPersona(jTable1.convertRowIndexToModel(indexs[i])));
        return list;
    }
    
    private void removeViewMain(){
        jPanelCenter.remove(jScrollPane1);
    }
    
    private void changedModeAtView(final Persona persona) {
         PanelViewData panel = new PanelViewData(persona,logicaAdministrador);
         firePropertyChange("changedPanel", jScrollPane1, panel);
//        PanelRegistroEstudiante panel = new PanelRegistroEstudiante();
        
    }
    
    private javax.swing.JPopupMenu createPopupMenu(){
        javax.swing.JPopupMenu menu = new javax.swing.JPopupMenu();
        javax.swing.JMenuItem item = new javax.swing.JMenuItem("Ver perfil completo");
        item.setFont(jButtonGenerarInforme.getFont());
        item.setBackground(jPanelWest.getBackground());
        item.setBorder(null);
        item.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

            }
        });

        menu.add(item);
        return menu;
    }

    Persona createPerson(){
        Persona p = new Persona(3);
        p.setNombreCompleto("Ariel Jose Arnedo");
        p.setEdad(17);
        p.setTipoOcupacion(OcupacionEnum.ESTUDIANTE);
        p.setProcesado(Boolean.FALSE);
        p.setFechaRegistro(new java.sql.Date(java.util.Calendar.getInstance().getTimeInMillis()));
        Ocupacion o = new Ocupacion();
        o.setGradoCursado(11);
        o.setCodigo(11);
        o.setCargo("nose");o.setCodigoEstudiante(3);o.setNivelEscolaridad("Nose");o.setCulminadoEstudio(Boolean.TRUE);o.setUltimoGradoCursado(11);
        o.setInstitucion("Inetit");
        p.setOcupacion(o);
        Test t = new Test(5, "13333333332435",3);
        p.setPrueba(t);
        return p;
    }
    
    public java.io.File createAndGetFileChooser() {
        
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Microsoft Excel","xls"));
        fileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        if(fileChooser.showSaveDialog(PanelModeAdministrador.this) == javax.swing.JFileChooser.APPROVE_OPTION){
            return  new java.io.File(fileChooser.getCurrentDirectory(), fileChooser.getName(fileChooser.getSelectedFile())+".xls");
        }
        throw new RuntimeException();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGenerarInforme;
    private javax.swing.JButton jButtonTitleFilter;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBoxFecha;
    private javax.swing.JComboBox jComboBoxOcupacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCountStudent;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelProcessExcel;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelNort;
    private javax.swing.JPanel jPanelWest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldFilterName;
    // End of variables declaration//GEN-END:variables
    private class PJKeyAdapter extends java.awt.event.KeyAdapter{
        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {
                if(((javax.swing.JTextField) e.getSource()).getText().compareTo("Buscar por nombres") == 0)
                    ((javax.swing.JTextField) e.getSource()).setText("");
        }

        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {
            logicaAdministrador.setFilterNames(((javax.swing.JTextField) e.getSource()).getText());
            logicaAdministrador.startFiltering();
            jLabelCountStudent.setText((jTable1.getRowCount() == 0)? "Ningun Resultado":"Muestra de "+jTable1.getRowCount()+" registro(s)");
        }
        
        
    }
}
