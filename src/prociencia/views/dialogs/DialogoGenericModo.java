
package prociencia.views.dialogs;

import prociencia.logic.core.daos.AdministradorDao;

/**
 *
 * @author Klac
 */
public class DialogoGenericModo extends javax.swing.JDialog {

    private static final int IN_ADMINISTRADOR = 1;
    private static final int IN_TUTOR = 2;
    private static final int OFF = 0;
    
    private int verificion;
    
    public DialogoGenericModo() {
        super(new javax.swing.JFrame(), true);
        initComponents();
        this.getContentPane().setBackground(java.awt.Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public int getVerificion() {
        return verificion;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordFieldPass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Verificación");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPasswordFieldPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPasswordFieldPass.setForeground(new java.awt.Color(102, 102, 102));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(jPasswordFieldPass.getFont());
        jButton1.setForeground(jPasswordFieldPass.getForeground());
        jButton1.setText("Aceptar");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        this.getRootPane().setDefaultButton(jButton1);

        jButton2.setBackground(jButton1.getBackground());
        jButton2.setFont(jPasswordFieldPass.getFont());
        jButton2.setForeground(jPasswordFieldPass.getForeground());
        jButton2.setText("Cancelar");
        jButton2.setBorderPainted(jButton1.isBorderPainted());
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(jButton1.isFocusPainted());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(jPasswordFieldPass.getFont());
        jLabel1.setForeground(jPasswordFieldPass.getForeground());
        jLabel1.setText("Contraseña");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/teacher-female48.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        doClose(OFF);
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        doClose(OFF);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jPasswordFieldPass.getPassword().length == 0){
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }
        AdministradorDao usaDao = new AdministradorDao();
        try {
            if(usaDao.verificarUsuario(String.valueOf(jPasswordFieldPass.getPassword()))){
                doClose(IN_ADMINISTRADOR);
            }else if(usaDao.getPassTutor().compareTo(String.valueOf(jPasswordFieldPass.getPassword())) == 0){
                doClose(IN_TUTOR);
            }else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta","Advertancia!",javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (java.sql.SQLException ex) {
            try{
                java.io.FileInputStream file = new java.io.FileInputStream(new java.io.File(System.getProperty("java.io.tmpdir")+"rt12l.jsn"));
                if(verificarTutor(file, String.valueOf(jPasswordFieldPass.getPassword()))){
                    doClose(IN_TUTOR);
                }else{
                    javax.swing.JOptionPane.showMessageDialog(rootPane, "Contraseña de tutor no valida","Advertencia!",javax.swing.JOptionPane.WARNING_MESSAGE);
                }
            }catch(java.io.IOException ex1){
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Error de verificacion de contraseña\n"
                        + "por favor intentelo más tarde","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean verificarTutor(java.io.FileInputStream strem,String pass) throws java.io.IOException{
        java.util.ArrayList<Integer> lis = new java.util.ArrayList<Integer>();
        int j;
        do{
            j = strem.read();
            if(j!= -1)
                lis.add(j);
        }while(j != -1);
        
        strem.close();
        
        char [] result = new char[lis.size()];
                
        for(int i = 0; i < lis.size() ; i++){
            result[i] = (char) (lis.get(i) - i);
        }
        return String.valueOf(result).compareTo(pass) == 0;
    }
    
    private void doClose(int verifiacion){
        this.verificion = verifiacion;
        this.setVisible(false);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
