
package prociencia.views.panels;

import prociencia.logic.core.entities.Persona;

/**
 *
 * @author Klac
 */
public class PanelViewDataPerson extends javax.swing.JPanel {

    private final Persona persona;
    
    public PanelViewDataPerson(Persona persona) {
        this.persona = persona;
        initComponents();
        updateViewDataPerson();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombres = createTextField();
        ocupacion = createTextField();
        fecha = createTextField();
        institucion = createTextField();
        grado = createTextField();
        cargo = createTextField();
        escolaridad = createTextField();
        programa = createTextField();
        culmino = createTextField();
        edad = createTextField();
        ultimo = createTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        nombres.setText("");

        ocupacion.setText("");

        fecha.setText("nombres");

        institucion.setText("");

        grado.setText("grado");

        cargo.setText("");

        escolaridad.setText("");

        programa.setText("");

        culmino.setText("");

        edad.setText("");

        ultimo.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombres)
                    .addComponent(ocupacion, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(institucion, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(cargo, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(programa, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(culmino, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(edad, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(ultimo, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(escolaridad, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(escolaridad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(programa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(culmino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateViewDataPerson(){
        if(persona != null && persona.getOcupacion() != null){
            if(persona.getNombreCompleto() == null){
               nombres.setVisible(false);
            }else{
                nombres.setText("Nombre: "+persona.getNombreCompleto());
            }
            if(persona.getEdad() == null){
                edad.setVisible(false);
            }else{
                edad.setText("Edad: "+persona.getEdad());
            }
            if(persona.getTipoOcupacion() == null){
                ocupacion.setVisible(false);
            }else{
                ocupacion.setText("Ocupación: "+persona.getStringDeOcupacion(persona.getTipoOcupacion()));
            }
            if(persona.getFechaRegistro() == null){
                fecha.setVisible(false);
            }else{
                fecha.setText("Fecha de registro: "+persona.getFechaRegistro().toString());
            }
            if(persona.getOcupacion()== null){
            }else{
                if(persona.getOcupacion().getGradoCursado() == null){
                    grado.setVisible(false);
                }else{
                    grado.setText("Grado cursado: "+persona.getOcupacion().getGradoCursado());
                }
                if(persona.getOcupacion().getInstitucion() == null){
                    institucion.setVisible(false);
                }else{
                    institucion.setText("Institución o Empresa: "+persona.getOcupacion().getInstitucion());
                }
                if(persona.getOcupacion().getCargo() == null){
                    cargo.setVisible(false);
                }else{
                    cargo.setText("Cargo desempeñado: "+persona.getOcupacion().getCargo());
                }
                if(persona.getOcupacion().getNivelEscolaridad() == null){
                    escolaridad.setVisible(false);
                }else{
                    escolaridad.setText("Nivel de escolaridad: "+persona.getOcupacion().getNivelEscolaridad());
                }
                if(persona.getOcupacion().getPrograma() == null){
                    programa.setVisible(false);
                }else{
                    programa.setText("Programa: "+persona.getOcupacion().getPrograma());
                }
                if(persona.getOcupacion().isCulminadoEstudio() == null){
                    culmino.setVisible(false);
                }else{
                    culmino.setText("Estudios culminados: "+ ((persona.getOcupacion().isCulminadoEstudio())? "SI":"NO"));
                }
                if(persona.getOcupacion().getUltimoGradoCursado() == null){
                    ultimo.setVisible(false);
                }else{
                    ultimo.setText("Ultimo grado o semestre cursado: "+persona.getOcupacion().getUltimoGradoCursado());
                }
            }
        }else{
            removeAll();
            setLayout(new java.awt.BorderLayout());
            javax.swing.JLabel icono = new javax.swing.JLabel(
                    new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/Error.png"))
            );
            icono.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
            icono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            add(icono,java.awt.BorderLayout.CENTER);
            icono = new javax.swing.JLabel("DATOS NO OBTENIDOS, POSIBLE ERROR DE CONEXIÓN CON EL SERVIDOR");
            icono.setFont(new java.awt.Font("Arial", 0, 20));
            icono.setForeground(java.awt.Color.ORANGE);
            add(icono,java.awt.BorderLayout.SOUTH);
            updateUI();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cargo;
    private javax.swing.JTextField culmino;
    private javax.swing.JTextField edad;
    private javax.swing.JTextField escolaridad;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField grado;
    private javax.swing.JTextField institucion;
    private javax.swing.JTextField nombres;
    private javax.swing.JTextField ocupacion;
    private javax.swing.JTextField programa;
    private javax.swing.JTextField ultimo;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JTextField createTextField(){
        final javax.swing.JTextField campo = new javax.swing.JTextField();
        campo.setFont(new java.awt.Font("Arial", 0, 20));
        campo.setForeground(new java.awt.Color(102, 102, 102));
        campo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                e.consume();
            }
        });
        campo.addFocusListener(new FocusListenerCopy());
        return campo;
    }
    
    private class FocusListenerCopy implements java.awt.event.FocusListener{

        public void focusGained(java.awt.event.FocusEvent e) {
            javax.swing.JTextField campo = (javax.swing.JTextField)e.getSource();
            String text = campo.getText();
            if(text.compareTo("") != 0){
                int i = text.indexOf(": ");
                if(i > 0){
                    campo.setSelectionStart(i+2);
                    campo.setSelectionEnd(text.length());
                }
            }
        }

        public void focusLost(java.awt.event.FocusEvent e) {}
        
    }
}
