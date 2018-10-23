

package prociencia.logic.core.util.tads;


/**
 *
 * @author Klac
 */
public class Observador extends java.util.Observable{
    
    private static Observador obs = null;

    public static Observador getInstance() {
        if(obs == null){
            obs = new Observador();
        
        }
        return obs;
    }
    
    public void addObserver(java.util.Observer observer){
        super.addObserver(observer);
    }
    
    public void notifyObservers(Object arg){
        super.setChanged();
        super.notifyObservers(arg);
    }
    
}
