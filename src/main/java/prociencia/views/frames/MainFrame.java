
package prociencia.views.frames;

import prociencia.controllers.ChangedSelectionListener;
import prociencia.controllers.MouseMoveListener;
import prociencia.logic.core.daos.WriteWorkConnection;
import prociencia.logic.core.util.tads.Observador;
import prociencia.logic.model.ControlModel;
import prociencia.logic.model.User;
import prociencia.views.componets.FactoryMessage;
import prociencia.views.dialogs.DialogChangeModoUser;
import prociencia.views.dialogs.DialogChangedTutor;
import prociencia.views.panels.PanelExtratorStudent;
import prociencia.views.tads.JMenuBarTad;

/**
 *
 * @author Klac
 */
public final class MainFrame extends javax.swing.JFrame implements java.util.Observer{

    private final ControlModel logica = ControlModel.getInstance();
    
    private final MouseMoveListener MOUSE_LISTENER = new MouseMoveListener();
    private final ChangedSelectionListener CHANGED_LISTENER = new ChangedSelectionListener();
    
    public MainFrame() {
        super("Test Psicométrico - TestLine");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(MainFrame.class.getResource("iconTest.png")));
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        initComponents();
        uptadeSesion();
        
    }
    
    public void updateModeAdministrador(boolean isModoAdministrador){
        panelSelection.setVisible(!isModoAdministrador);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        jToolBar1 = new JMenuBarTad(this);
        panelSelection = new javax.swing.JPanel();
        jLabelTest = new javax.swing.JLabel();
        jToggleButtonRegistrar = new javax.swing.JToggleButton();
        jToggleButtonRealizarTest = new javax.swing.JToggleButton();
        jPanelWork = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemModoConexion = new javax.swing.JMenuItem();
        jMenuItemOpenFolder = new javax.swing.JMenuItem();
        jMenuItemModoNormal = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemImportar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuConfiguracion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        panelSelection.setBackground(new java.awt.Color(255, 255, 255));
        panelSelection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabelTest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTest.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTest.setText("TEST");

        jToggleButtonRegistrar.setBackground(panelSelection.getBackground());
        grupo1.add(jToggleButtonRegistrar);
        jToggleButtonRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jToggleButtonRegistrar.setForeground(new java.awt.Color(153, 153, 153));
        jToggleButtonRegistrar.setText("Formulario de Registro");
        jToggleButtonRegistrar.setBorderPainted(false);
        jToggleButtonRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButtonRegistrar.setFocusPainted(false);
        jToggleButtonRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButtonRegistrar.addMouseListener(MOUSE_LISTENER);
        jToggleButtonRegistrar.addChangeListener(CHANGED_LISTENER);

        jToggleButtonRealizarTest.setBackground(jToggleButtonRegistrar.getBackground());
        grupo1.add(jToggleButtonRealizarTest);
        jToggleButtonRealizarTest.setFont(jToggleButtonRegistrar.getFont());
        jToggleButtonRealizarTest.setForeground(jToggleButtonRegistrar.getForeground());
        jToggleButtonRealizarTest.setText("Realizar Test");
        jToggleButtonRealizarTest.setBorderPainted(false);
        jToggleButtonRealizarTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButtonRealizarTest.setEnabled(false);
        jToggleButtonRealizarTest.setFocusPainted(false);
        jToggleButtonRealizarTest.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButtonRealizarTest.addMouseListener(MOUSE_LISTENER);
        jToggleButtonRealizarTest.addChangeListener(CHANGED_LISTENER);

        javax.swing.GroupLayout panelSelectionLayout = new javax.swing.GroupLayout(panelSelection);
        panelSelection.setLayout(panelSelectionLayout);
        panelSelectionLayout.setHorizontalGroup(
            panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToggleButtonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
            .addComponent(jToggleButtonRealizarTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSelectionLayout.setVerticalGroup(
            panelSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTest)
                .addGap(12, 12, 12)
                .addComponent(jToggleButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jToggleButtonRealizarTest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        getContentPane().add(panelSelection, java.awt.BorderLayout.WEST);

        jPanelWork.setBackground(new java.awt.Color(255, 255, 255));
        jPanelWork.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelWork, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuArchivo.setBackground(new java.awt.Color(255, 255, 255));
        jMenuArchivo.setForeground(new java.awt.Color(51, 51, 51));
        jMenuArchivo.setText("Archivo");
        jMenuArchivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jMenuItemModoConexion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemModoConexion.setBackground(jMenuArchivo.getBackground());
        jMenuItemModoConexion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItemModoConexion.setForeground(jMenuArchivo.getForeground());
        jMenuItemModoConexion.setText("Trabajar sin conexion");
        jMenuItemModoConexion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItemModoConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModoConexionActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemModoConexion);

        jMenuItemOpenFolder.setBackground(jMenuArchivo.getBackground());
        jMenuItemOpenFolder.setFont(jMenuItemModoConexion.getFont());
        jMenuItemOpenFolder.setForeground(jMenuArchivo.getForeground());
        jMenuItemOpenFolder.setText("Abrir Carpeta");
        jMenuItemOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenFolderActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemOpenFolder);

        jMenuItemModoNormal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemModoNormal.setBackground(jMenuArchivo.getBackground());
        jMenuItemModoNormal.setFont(jMenuItemModoConexion.getFont());
        jMenuItemModoNormal.setForeground(jMenuArchivo.getForeground());
        jMenuItemModoNormal.setText("Cerrar modo administrador");
        jMenuItemModoNormal.setHorizontalAlignment(jMenuItemModoConexion.getHorizontalAlignment());
        jMenuItemModoNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModoNormalActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemModoNormal);
        jMenuArchivo.add(jSeparator1);

        jMenuItemImportar.setBackground(jMenuBar1.getBackground());
        jMenuItemImportar.setFont(jMenuItemModoConexion.getFont());
        jMenuItemImportar.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItemImportar.setText("Importar Estudiantes...");
        jMenuItemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemImportar);
        jMenuArchivo.add(jSeparator2);

        jMenuItemSalir.setBackground(jMenuArchivo.getBackground());
        jMenuItemSalir.setFont(jMenuItemModoConexion.getFont());
        jMenuItemSalir.setForeground(jMenuArchivo.getForeground());
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuConfiguracion.setBackground(jMenuArchivo.getBackground());
        jMenuConfiguracion.setForeground(jMenuArchivo.getForeground());
        jMenuConfiguracion.setText("Configuración");
        jMenuConfiguracion.setFont(jMenuArchivo.getFont());
        jMenuConfiguracion.setVisible(false);

        jMenuItem1.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItem1.setFont(jMenuItemModoConexion.getFont());
        jMenuItem1.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItem1.setText("Configuración de Administrador...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuItem1);

        jMenuItem3.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItem3.setFont(jMenuItemModoConexion.getFont());
        jMenuItem3.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItem3.setText("Configuración de Tutor...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(jMenuItem3);

        jMenuBar1.add(jMenuConfiguracion);

        jMenuAyuda.setBackground(jMenuArchivo.getBackground());
        jMenuAyuda.setForeground(jMenuArchivo.getForeground());
        jMenuAyuda.setText("Ayuda");
        jMenuAyuda.setFont(jMenuArchivo.getFont());
        jMenuAyuda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem2.setBackground(jMenuItemModoConexion.getBackground());
        jMenuItem2.setFont(jMenuItemModoConexion.getFont());
        jMenuItem2.setForeground(jMenuItemModoConexion.getForeground());
        jMenuItem2.setText("Acerca de...");
        jMenuAyuda.add(jMenuItem2);

        jMenuBar1.add(jMenuAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        logica.setPanelWokr(jPanelWork);
        Observador.getInstance().addObserver(this);
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        deleteFilePass();
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemModoConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModoConexionActionPerformed
        jMenuItemModoConexion.setEnabled(false);
        ControlModel.setWorkConnection(true);
        java.io.File carpeta = new java.io.File(System.getProperty("user.home")+"\\Desktop\\Resultados Prueba 16PF");
        if(!carpeta.exists()){
            if(carpeta.mkdirs())
                FactoryMessage.createMessageInformation(MainFrame.class, "information1");
            else
                FactoryMessage.createMessageAlert(MainFrame.class,"alert1");
        }else{
            FactoryMessage.createMessageInformation(MainFrame.class, "information1");
        }     
    }//GEN-LAST:event_jMenuItemModoConexionActionPerformed

    private void jMenuItemModoNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModoNormalActionPerformed
        ControlModel.setSesion(User.ESTUDIANTE);
        logica.closeSessionAdministrador();
        uptadeSesion();
        updateModeAdministrador(false);
    }//GEN-LAST:event_jMenuItemModoNormalActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                DialogChangeModoUser dialogo = new DialogChangeModoUser(MainFrame.this);
                dialogo.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarActionPerformed
        final Runnable run = new Runnable(){
            @Override
            public void run(){
                javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);
                fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Estudiantes","stud"));
                if(fileChooser.showOpenDialog(MainFrame.this) == javax.swing.JFileChooser.OPEN_DIALOG){
                    PanelExtratorStudent panel;
                    try{
                        panel = new PanelExtratorStudent(WriteWorkConnection.ReaderWorkConnection.getListEstudiante(fileChooser.getSelectedFiles()),fileChooser.getSelectedFiles());
                        logica.establacerPanelActual(panel);
                    }catch(Exception ex){
                        javax.swing.JOptionPane.showMessageDialog(MainFrame.this, ""
                               + "Ooops! ha ocurrido un error al tratar de leer\n"
                                + "el archivo seleccionado","Error de Lectura",javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
        javax.swing.SwingUtilities.invokeLater(run);
    }//GEN-LAST:event_jMenuItemImportarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                DialogChangedTutor dialog = new DialogChangedTutor();
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        deleteFilePass();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenFolderActionPerformed
        java.io.File carpeta = new java.io.File(System.getProperty("user.home")+"\\Desktop\\Resultados Prueba 16PF");
        try {
            if(!carpeta.exists())
                carpeta.mkdirs();
            Runtime.getRuntime().exec("explorer.exe "+carpeta.getAbsolutePath());
        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            FactoryMessage.createMessageAlert(ex);
        }
    }//GEN-LAST:event_jMenuItemOpenFolderActionPerformed

    private void deleteFilePass(){
        try{
             new java.io.File(System.getProperty("java.io.tmpdir")+"rt12l.jsn").delete();
        }catch(Exception ex){}
    }
    
    public void uptadeSesion(){
        switch(ControlModel.getSesion()){
            
            case TUTOR:{
                jMenuItemOpenFolder.setVisible(true);
                jMenuConfiguracion.setVisible(false);
                jMenuItemModoNormal.setVisible(false);
                jMenuItemImportar.setVisible(false);
                if(!jMenuItemModoConexion.isVisible()){
                    jMenuItemModoConexion.setVisible(true);
                }
                ((JMenuBarTad)jToolBar1).getStartSesion().setEnabled(true);
                break;
            }
            case ADMINISTRADOR:{
                jMenuItemOpenFolder.setVisible(false);
                jMenuConfiguracion.setVisible(true);
                jMenuItemModoNormal.setVisible(true);
                jMenuItemImportar.setVisible(true);
                jMenuItemModoConexion.setVisible(false);
                ((JMenuBarTad)jToolBar1).getStartSesion().setEnabled(false);
                break;
            }
            case ESTUDIANTE:{
                jMenuItemOpenFolder.setVisible(false);
                jMenuConfiguracion.setVisible(false);
                jMenuItemModoNormal.setVisible(false);
                jMenuItemModoConexion.setVisible(false);
                jMenuItemImportar.setVisible(false);
                ((JMenuBarTad)jToolBar1).getStartSesion().setEnabled(true);
                break;
            }
        }   
    }
    
    @Override
    public void update(java.util.Observable o, Object arg) {
        if(arg instanceof Integer){
            jToggleButtonRealizarTest.setEnabled(((Integer)arg) == 0);
            jToggleButtonRealizarTest.setSelected(((Integer)arg) == 1);
            if(((Integer)arg) == 1){
                jToggleButtonRegistrar.setEnabled(false);
            }
            if(((Integer)arg) == 2){
                jToggleButtonRegistrar.setEnabled(true);
                jToggleButtonRegistrar.setSelected(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JLabel jLabelTest;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemImportar;
    private javax.swing.JMenuItem jMenuItemModoConexion;
    private javax.swing.JMenuItem jMenuItemModoNormal;
    private javax.swing.JMenuItem jMenuItemOpenFolder;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JPanel jPanelWork;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToggleButton jToggleButtonRealizarTest;
    private javax.swing.JToggleButton jToggleButtonRegistrar;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelSelection;
    // End of variables declaration//GEN-END:variables
}
