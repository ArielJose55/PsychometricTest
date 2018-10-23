


package prociencia.logic.model;


import prociencia.logic.core.entities.Persona;
import prociencia.logic.core.util.tads.TableModelData;
import prociencia.logic.core.util.tads.ConsultorDatabase;
import prociencia.logic.core.util.tads.Observador;
import prociencia.logic.core.util.tads.ThreadExecutorTutor;
import prociencia.views.panels.PanelModeAdministrador;
import prociencia.views.panels.PanelRegistroEstudiante;
import prociencia.views.panels.PanelTest;

/**
 *
 * @author Klac
 */
public class ControlModel {
    
    private static ControlModel logica = null;
    private static User sesion = User.ESTUDIANTE;
    private static boolean workConnection = false;
    
    
    
    private javax.swing.JPanel panelWokr;
    private javax.swing.JPanel panelActual;
    private javax.swing.JPanel panelAnterior;
    private Persona persona;
    private final TableModelData tableModel = new TableModelData();
    private java.util.Timer tareaProgramada;
    private final ConsultorDatabase consultor = new ConsultorDatabase(this);
    private final Thread hiloActulizador;

    
    private ControlModel() {
        panelActual = panelAnterior = null;
        hiloActulizador = new Thread(consultor);
        inti();
        initExecutor();
    }
    
    private void initExecutor(){
        try {
            new ThreadExecutorTutor();
        } catch (java.io.IOException e) {
        }
    }
    
    private void inti(){
        hiloActulizador.start();
        tareaProgramada = new java.util.Timer();
        java.util.TimerTask tarea = new java.util.TimerTask() {
            @Override
            public void run() {
                System.err.println("timer ejecutandose....");
             consultor.despertar();
            }
        };
        tareaProgramada.schedule(tarea, 0,1800000);
    }
    
    public static ControlModel getInstance(){
        if(logica == null){
             logica = new ControlModel();
        }
        return logica;
    }

    public static boolean isWorkConnection() {
        return workConnection;
    }

    public static void setWorkConnection(boolean workConnection) {
        ControlModel.workConnection = workConnection;
    }
    
    public void setPanelWokr(javax.swing.JPanel panelWokr) {
        this.panelWokr = panelWokr;
    }
    
    public ConsultorDatabase getConsultor() {
        return consultor;
    }
    
    public void establacerPanelActual(javax.swing.JPanel actual){
        panelAnterior = panelActual;
        panelActual = actual;  
        cambiarPanel();
    }

    public TableModelData getTableModel() {
        return tableModel;
    }

    public void createDateModelTable(java.util.List<Persona> estudiante) {
        tableModel.addListaAndReplace(estudiante);
    }

    public static User getSesion() {
        return sesion;
    }

    public static void setSesion(User sesion) {
        ControlModel.sesion = sesion;
    }
  
    public javax.swing.JPanel getPanelWokr() {
        return panelWokr;
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void waiting(){
        panelWokr.add(new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/waiting.gif")))
                ,java.awt.BorderLayout.CENTER);
        panelWokr.updateUI();
    }
    
    public void setPersona(Persona estudiante) {
        this.persona = estudiante;
    }
    
    public ControlModelAdministrador getControlModelAdministrador(){
        return ControlModelAdministrador.getInstance();
    }
    void destrucControlModelAdministrador(){
        ControlModelAdministrador.destrucModeAdministrador();
    }
    
    public void startSessionAdministrador(){
        panelActual = new PanelModeAdministrador();
        cambiarPanel();
    }
    
    public void closeSessionAdministrador(){
        panelActual = new PanelRegistroEstudiante();
        destrucControlModelAdministrador();
        cambiarPanel();
    }
    
//    ----------------------------------------------------------------------------------------------------------
    
    public void volverAlPanelAnterior(){
        if(panelAnterior instanceof PanelModeAdministrador){
            ((PanelModeAdministrador)panelAnterior).getComboxBoxModelTad().update();
            ((PanelModeAdministrador)panelAnterior).getComboxBoxModelTad();
        }
        javax.swing.JPanel panel = panelAnterior;
        panelAnterior = panelActual;
        panelActual = panel;
        cambiarPanel();
    }
    
    
    private void cambiarPanel(){
        panelWokr.removeAll();
        if(panelAnterior == null){
              panelWokr.add(panelActual, java.awt.BorderLayout.CENTER);
        }else{
             panelWokr.add(panelActual, java.awt.BorderLayout.CENTER);
        }
        panelWokr.updateUI();
        if(panelActual instanceof PanelTest){
             Observador.getInstance().notifyObservers(true);
        }else{
             Observador.getInstance().notifyObservers(false);
        }
    }
}
