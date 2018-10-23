
package prociencia.views.tads;
 

import prociencia.logic.core.util.tads.Observador;
import prociencia.logic.model.ControlModel;
import prociencia.logic.model.User;
import prociencia.views.dialogs.DialogoGenericModo;
import prociencia.views.frames.MainFrame;

/**
 *
 * @author Klac
 */
public class JMenuBarTad extends javax.swing.JToolBar implements java.util.Observer{

    private int sizeFont = 13;
    private final MainFrame mainFrame;
    
    public JMenuBarTad(MainFrame ventana) {
        this.mainFrame = ventana;
        startFollowUp();
        initComponents();
    }

    private void startFollowUp(){
        Observador.getInstance().addObserver(this);
    }
    
    private void initComponents(){
        setBackground(new java.awt.Color(250, 252, 252, 255));
        setFloatable(false);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(.9f,.9f,.9f,1f)));
        setLayout(new java.awt.GridBagLayout());
        java.awt.Insets insets = new java.awt.Insets(5, 5, 5, 5);
        
        java.awt.GridBagConstraints co = new java.awt.GridBagConstraints();
        
        inicio = new javax.swing.JButton("Instrucciones");
        inicio.setFocusPainted(false);
        inicio.setBorderPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        inicio.setFont(new java.awt.Font("Lao UI",java.awt.Font.BOLD,18));
        inicio.setForeground(new java.awt.Color(.6f, .6f, .6f));
        inicio.addMouseListener(createMouseAdapter());
        inicio.setBackground(this.getBackground());
        inicio.addActionListener(new java.awt.event.ActionListener() {
            final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia/views/tads/instruciones");
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                javax.swing.JOptionPane.showMessageDialog(mainFrame, RB.getString("intrucciones"),"Guia de realizacion del test",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        });
        co.gridx = 0;
        co.anchor = java.awt.GridBagConstraints.WEST;
        co.insets = insets;
        co.weightx = 1f;
        co.gridwidth = 1;
        add(inicio, co);
        
        zoomIn = new javax.swing.JButton(new javax.swing.ImageIcon(this.getClass().getResource("icon_ZoomIn.png")));
        zoomIn.setRolloverIcon(new javax.swing.ImageIcon(this.getClass().getResource("icon_ZoomInRellover.png")));
        zoomIn.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if(sizeFont <= 20){
                   Observador.getInstance().notifyObservers(new java.awt.Font("Arial", 0, sizeFont));
                   sizeFont++;
                }
            }
        });
        zoomIn.setFocusPainted(false);
        zoomIn.setBorderPainted(false);
        zoomIn.setContentAreaFilled(false);
        zoomIn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        zoomIn.setBackground(this.getBackground());
        co.gridx = 1;
        co.weightx = 0f;
        co.insets = new java.awt.Insets(0, 0, 0, 0);
        add(zoomIn,co);
        
        zoomOut = new javax.swing.JButton(new javax.swing.ImageIcon(this.getClass().getResource("icon_ZoomOut.png")));
        zoomOut.setRolloverIcon(new javax.swing.ImageIcon(this.getClass().getResource("icon_ZoomOutRellover.png")));
        zoomOut.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if(sizeFont >= 10){
                   Observador.getInstance().notifyObservers(new java.awt.Font("Arial", 0, sizeFont));
                   sizeFont--;
                }
            }
        });
        zoomOut.setFocusPainted(false);
        zoomOut.setBorderPainted(false);
        zoomOut.setContentAreaFilled(false);
        zoomOut.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        zoomOut.setBackground(this.getBackground());
        co.gridx = 2;
        co.weightx = 16f;
        add(zoomOut,co);
        
        
        
        javax.swing.JButton icono = new javax.swing.JButton(new javax.swing.ImageIcon(this.getClass().getResource("icon_user.png")));
        icono.setRolloverIcon(new javax.swing.ImageIcon(this.getClass().getResource("icon_userRellover.png")));
        icono.setFocusPainted(false);
        icono.setBorderPainted(false);
        icono.setContentAreaFilled(false);
        
        icono.setBackground(inicio.getBackground());
        co.gridx = 3;
        co.weightx = 0f;
        co.anchor = java.awt.GridBagConstraints.EAST;
        add(icono, co);
        
        startSesion = new javax.swing.JButton("Iniciar Sesión");
        startSesion.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                DialogoGenericModo dialogo = new DialogoGenericModo();
                if(dialogo.getVerificion() == 1){
                    ControlModel.getInstance().waiting();
                    ControlModel.setSesion(User.ADMINISTRADOR);
                    ControlModel.getInstance().getConsultor().despertar();
                    mainFrame.uptadeSesion();
                    mainFrame.updateModeAdministrador(true);
                    ControlModel.getInstance().startSessionAdministrador();
                }else if(dialogo.getVerificion() == 2){
                    ControlModel.setSesion(User.TUTOR);
                    mainFrame.uptadeSesion();
                    startSesion.setEnabled(false);
                }
            }
        });
        startSesion.setBorderPainted(inicio.isBorderPainted());
        startSesion.setFocusPainted(inicio.isFocusPainted());
        startSesion.setContentAreaFilled(inicio.isContentAreaFilled());
        startSesion.setCursor(inicio.getCursor());
        startSesion.setFont(inicio.getFont());
        startSesion.setForeground(inicio.getForeground());
        startSesion.setBackground(this.getBackground());
        startSesion.addMouseListener(createMouseAdapter());
        co.gridx = 4;
        add(startSesion, co);
        updateViews(false);
    }

    public javax.swing.JButton getStartSesion() {
        return startSesion;
    }
    
    
    
    public void updateViews(boolean views){
        zoomIn.setVisible(views);
        zoomOut.setVisible(views);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        if(arg instanceof Boolean){
            if(Boolean.valueOf(String.valueOf(arg))){
                if(!zoomIn.isVisible()){
                    updateViews(true);
                }
            }else{
                if(zoomIn.isVisible()){
                    updateViews(false);
                }
            }
        }
    }
    
    
    private java.awt.Color color;
    private javax.swing.JButton inicio;
    private javax.swing.JButton startSesion;
    private javax.swing.JButton zoomIn;
    private javax.swing.JButton zoomOut;
    private javax.swing.JTextField sizePorcentaje;
    
    private java.awt.event.MouseAdapter createMouseAdapter(){
        
        java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                javax.swing.JComponent compo = (javax.swing.JComponent) e.getSource();
                color = compo.getForeground();
                compo.setForeground(new java.awt.Color(105, 155, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                javax.swing.JComponent compo = (javax.swing.JComponent) e.getSource();
                compo.setForeground(color);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                javax.swing.JComponent compo = (javax.swing.JComponent) e.getSource();
                compo.setForeground(color);
            }
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                javax.swing.JComponent compo = (javax.swing.JComponent) e.getSource();
                compo.setForeground(new java.awt.Color(21, 21, 21));
            }
            
            
            
        };
        return mouseAdapter;
    }
}
