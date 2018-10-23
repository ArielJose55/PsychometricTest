
package prociencia.views.dialogs;

/**
 *
 * @author Klac
 */
public class DialogWait extends javax.swing.JDialog implements Runnable{

    private final Thread hilo;
    
    public DialogWait() {
        super();
        getContentPane().setBackground(java.awt.Color.WHITE);
        hilo = new Thread(this);
        start();
    }

    private void start(){
        hilo.start();
    }
    
    public void run(){
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(DialogWait.class.getResource("CircleLoadingBlue.gif")));
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void stop(){
       hilo.interrupt();
       this.setVisible(false);
       this.dispose();
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
