

package prociencia.logic.core.util.tads;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prociencia.logic.core.daos.PersonaDao;
import prociencia.logic.model.ControlModel;
import prociencia.logic.model.User;

/**
 *
 * @author Klac
 */
public class ConsultorDatabase implements Runnable{

    private final ControlModel logica;

    public ConsultorDatabase(ControlModel logica) {
        this.logica = logica;
    }
    
    
    @Override
    public void run() {
        while (true) {            
            if(ControlModel.getSesion().compareTo(User.ADMINISTRADOR) == 0){
                PersonaDao estudao = new PersonaDao();
                try {
                    System.err.println("Consultando...");
                    logica.createDateModelTable(estudao.listAllEstudiante());
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultorDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dormir();
        }
    }
    
    private synchronized void dormir(){

        try {
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConsultorDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void despertar(){
        this.notify();
    }
    

}
