

package prociencia.logic.core.util.tads;

import prociencia.logic.core.daos.AdministradorDao;

/**
 *
 * @author Klac
 */
public class ThreadExecutorTutor extends Thread{
    
    private  java.io.File archivo;
    private boolean isWriter;
    

    public ThreadExecutorTutor() throws java.io.IOException {
        isWriter = true;
        initComponents();
    }
    
    private void initComponents() throws java.io.IOException{
        archivo = new java.io.File(System.getProperty("java.io.tmpdir")+"rt12l.jsn");
        if(archivo.exists()){
            isWriter = false;
            start();
        }else if(archivo.createNewFile()){
            start();
        }else{
            interrupt();
        }
    }
    
    @Override
    public void run(){
        java.io.FileOutputStream outStream = null;
        try {
            
            String pass = "1234";
            byte[] bytes = pass.getBytes();
            int[] resul = new int[bytes.length];
            for(int i = 0; i < bytes.length ; i++){
                resul[i] = (int)i + (int)bytes[i];
            }
            outStream = new java.io.FileOutputStream(archivo);
            for (int c : resul) {
                outStream.write(c);
            }
            
        } catch (java.io.FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThreadExecutorTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(ThreadExecutorTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            try {
                if(outStream != null){
                    outStream.close();
                }
            } catch (java.io.IOException ex) {}
        }
            
    }

}
