
package prociencia.views.dialogs;

import prociencia.views.panels.PanelConfigPass;


public class DialogChangeModoUser extends javax.swing.JDialog {
    
    private final PanelConfigPass panelConfiPass = new PanelConfigPass(this);
    
    public DialogChangeModoUser(java.awt.Frame parent) {
        super(parent,"Cambiar contraseña de administrador", true);
        setIconImage(parent.getIconImage());
        this.add(panelConfiPass);
        initComponents();
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}