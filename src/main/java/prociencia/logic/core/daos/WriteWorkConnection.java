
package prociencia.logic.core.daos;

import prociencia.logic.core.entities.Persona;

/**
 *
 * @author Klac
 */
public class WriteWorkConnection {
    
    private static WriteWorkConnection connection = null;

    String fileName = ("16 PF "+(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)+"_"+(java.util.Calendar.getInstance().get(java.util.Calendar.MONTH)+1)+"_"+
                java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH))+".stud");
    java.io.File carpeta = new java.io.File(System.getProperty("user.home")+"\\Desktop\\Resultados Prueba 16PF");
    private java.io.ObjectOutputStream writerObject;
    private final java.util.List<Persona> LIST_ESTUDENTS  = new java.util.ArrayList<Persona>();
    
    public WriteWorkConnection() throws Exception {
    }
    
    private void initComponents() throws Exception{
        String fileNames = ("16 PF "+(java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)+"_"+(java.util.Calendar.getInstance().get(java.util.Calendar.MONTH)+1)+"_"+
                java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH))+".stud");
        java.io.File carpetas = new java.io.File(System.getProperty("user.home")+"\\Desktop\\Resultados Prueba 16PF");
        
        if(!carpeta.exists()){
            if(carpeta.mkdirs()){
                
            }
        }
        
        java.io.File file = new java.io.File(carpeta, fileName);
        if(file.exists()){
            
            try{
                LIST_ESTUDENTS.addAll(ReaderWorkConnection.getListEstudiante(file));
            }catch(Exception ex){}
            writerObject = new java.io.ObjectOutputStream(new java.io.FileOutputStream(file,false));
        }else if(file.createNewFile()){
            writerObject = new java.io.ObjectOutputStream(new java.io.FileOutputStream(file,true));
        }else{
            throw new Exception("Error al crear el archivo temporal de estudiantes");
        }
    }
    
    public static WriteWorkConnection getInstance() throws Exception{
        if(connection == null){
            connection = new WriteWorkConnection();
        }
        return connection;
    }
    
    public void writeStudent(Persona estudiante)throws Exception{
        java.util.List<Persona> lista = new java.util.ArrayList<Persona>();
        java.io.File file = new java.io.File(carpeta, fileName);
        if(file.exists()){
            
            try{
                lista.addAll(ReaderWorkConnection.getListEstudiante(file));
            }catch(Exception ex){}
            writerObject = new java.io.ObjectOutputStream(new java.io.FileOutputStream(file,false));
        }else if(file.createNewFile()){
            writerObject = new java.io.ObjectOutputStream(new java.io.FileOutputStream(file,true));
        }else{
            throw new Exception("Error al crear el archivo temporal de estudiantes");
        }
        lista.add(estudiante);
        new ThreadEscritor(lista).start();
        
    }

    private class ThreadEscritor extends Thread{
        
        java.util.List<Persona> personas;

        public ThreadEscritor(java.util.List<Persona> personas) {
            this.personas = personas;
            try {
                initComponents();
            } catch (Exception ex) {
                interrupt();
            }
        }
        
        @Override
        public void run(){
            try{
                writerObject.writeObject(personas);
            } catch (java.io.IOException ex) {
                java.util.logging.Logger.getLogger(WriteWorkConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }finally{
               if(writerObject != null){
                    try {
                        writerObject.close();
                    } catch (java.io.IOException ex) {
                        java.util.logging.Logger.getLogger(WriteWorkConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
    }
    
    
    public static class ReaderWorkConnection{
        public static java.util.List<Persona> getListEstudiante(java.io.File file)throws Exception{
            java.io.ObjectInputStream stram = null;
            try{
                stram = new java.io.ObjectInputStream(new java.io.FileInputStream(file));
                return (java.util.List<Persona>) stram.readObject();
            }finally{
                if(stram != null){
                    stram.close();
                }
            }    
        }
        
        public static java.util.List<Persona> getListEstudiante(java.io.File files[]) throws Exception{
            java.util.List<Persona> list = new java.util.ArrayList<Persona>();
            
            for(java.io.File file : files){
                list.addAll(ReaderWorkConnection.getListEstudiante(file));
            }
            return list;
        }
    }
}
