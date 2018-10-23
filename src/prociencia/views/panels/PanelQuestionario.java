

package prociencia.views.panels;

import javax.swing.JScrollPane;


/**
 *
 * @author Klac
 */
public class PanelQuestionario extends javax.swing.JPanel implements java.util.Observer{

    private final prociencia.logic.core.entities.Pregunta pregunta;
    private final ChangedListenerTad EVENT_CHANGE = new ChangedListenerTad();
    private final javax.swing.JScrollPane scrollPane;
    
    private int positionIndex;
    
    public PanelQuestionario(prociencia.logic.core.entities.Pregunta pregunta, JScrollPane pane) {
        this.scrollPane = pane;
        this.pregunta = pregunta;
        startFollowUp();
        initComponents();
        positionIndex = 0;
    }

    private void startFollowUp(){
        prociencia.logic.core.util.tads.Observador.getInstance().addObserver(this);
    }

    public int getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(int positionIndex) {
        this.positionIndex = positionIndex;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel("<html><p>"+pregunta.getPregunta()+"</p></html>");
        jPanel1 = new javax.swing.JPanel();
        a = new javax.swing.JRadioButton();
        b = new javax.swing.JRadioButton();
        c = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        setMaximumSize(new java.awt.Dimension(32767, 110));
        setMinimumSize(new java.awt.Dimension(0, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        grupo.add(a);
        a.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        a.setForeground(new java.awt.Color(92, 92, 92));
        a.setText("A.  "+pregunta.getOpcionA());
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.setRequestFocusEnabled(false);
        a.addItemListener(EVENT_CHANGE);
        jPanel1.add(a);

        grupo.add(b);
        b.setFont(a.getFont());
        b.setForeground(a.getForeground());
        b.setText("B.  "+pregunta.getOpcionB());
        b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.setRequestFocusEnabled(false);
        b.addItemListener(EVENT_CHANGE);
        jPanel1.add(b);

        grupo.add(c);
        c.setFont(a.getFont());
        c.setForeground(a.getForeground());
        c.setText("C.  "+pregunta.getOpcionC());
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.setRequestFocusEnabled(false);
        c.addItemListener(EVENT_CHANGE);
        jPanel1.add(c);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getRespuesta(){
        if(a.isSelected()){
            return 1;
        }else if(b.isSelected()){
            return 2;
        }else if(c.isSelected()){
            return 3;
        }else{
            return -2;
        }
    }
    
    public void azar(){
        java.util.Random rm = new java.util.Random();
        int i = rm.nextInt(4);
        if(i == 1){
            a.setSelected(true);
        }else if(i == 2){
            b.setSelected(true);
        }else if(i == 3){
            c.setSelected(true);
        }else{
            a.setSelected(true);
        }
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        if(arg instanceof java.awt.Font){
            java.awt.Font fuente = new java.awt.Font(a.getFont().getFamily(), a.getFont().getStyle(), ((java.awt.Font)arg).getSize());
            a.setFont(fuente);
            b.setFont(fuente);
            c.setFont(fuente);
        }
    }
    
    
    
    public void setVerificado(boolean accept){
        if(!accept){
            jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED));
        }
    }

    private class ChangedListenerTad implements java.awt.event.ItemListener{

        @Override
        public void itemStateChanged(java.awt.event.ItemEvent e) {
            if(e.getStateChange() == java.awt.event.ItemEvent.SELECTED){
                if(jLabel1.getBorder() != null) jLabel1.setBorder(null);
                int i = scrollPane.getVerticalScrollBar().getValue();
                try{
                    scrollPane.firePropertyChange("desplanzando", new Integer(i), positionIndex);
                }catch(Exception ex){}
            }
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton a;
    private javax.swing.JRadioButton b;
    private javax.swing.JRadioButton c;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
