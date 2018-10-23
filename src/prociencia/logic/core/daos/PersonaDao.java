
package prociencia.logic.core.daos;

import prociencia.logic.core.entities.Ocupacion;
import prociencia.logic.core.entities.Persona;
import prociencia.logic.core.entities.Test;
import prociencia.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class PersonaDao {
   
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia/logic/core/daos/sentencias");
    
    public void registrarEstudiante(Persona persona) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            conexion.setAutoCommit(false);
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Estudiante_registro"),java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, persona.getNombreCompleto());
            sentencia.setInt(2, persona.getEdad());
            sentencia.setInt(3, persona.getEnteroDeOcupacion(persona.getTipoOcupacion()));
            sentencia.setBoolean(4, Boolean.FALSE);
            sentencia.setDate(5, persona.getFechaRegistro());
            sentencia.execute();
            java.sql.ResultSet rs = sentencia.getGeneratedKeys();
            while(rs.next()){
                if(persona.getOcupacion() != null && persona.getPrueba() != null){
                    persona.getPrueba().setCodigoEstudiante(rs.getInt(1));
                    persona.getOcupacion().setCodigoEstudiante(rs.getInt(1));
                    new OcupacionDao().registrar(conexion, persona.getOcupacion());
                    new TestDao().registrar(conexion, persona.getPrueba());
                }
            }
            conexion.commit();
            rs.close();
            sentencia.close();
        }catch(java.sql.SQLException ex){
            if(conexion != null){
                conexion.rollback();
            }
            throw ex;
        }finally{
            if(conexion != null){
                conexion.setAutoCommit(true);
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
   public boolean uptateProcessPerson(int codigoOcupation,Boolean uptate) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Estudiante_Uptate_Process"));
            sentencia.setBoolean(1, uptate);
            sentencia.setInt(2, codigoOcupation);
            boolean i = sentencia.execute();
            sentencia.close();
            return i;
        }finally{
            if(connection != null){
                 ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
    
    public void uptateProcessPerson(java.util.List<Persona> list) throws java.sql.SQLException{
        java.sql.Connection connection = null;
        try{
            connection = ConnectionPool.getConexionPool().getConnection();
            java.sql.Statement sentencia = connection.createStatement();
            sentencia.execute(getCompleteStatementProcees(list));
            sentencia.close();
        }finally{
            if(connection != null){
                 ConnectionPool.getConexionPool().devolverConexion(connection);
            }
        }
    }
    
    public java.util.List<Persona> listAllEstudiante() throws java.sql.SQLException{
        java.util.List<Persona> lista;
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            lista = new java.util.ArrayList<Persona>();
            java.sql.Statement sentencia = conexion.createStatement();
            java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Estudiante_getAll"));
            TestDao testdao = new TestDao();
            while(rs.next()){
                Persona persona = new Persona(rs.getInt(1));
                persona.setNombreCompleto(rs.getString(2));
                persona.setEdad(rs.getInt(3));
                persona.setTipoOcupacion(persona.getOcupacionDeEntero(rs.getInt(4)));
                persona.setProcesado(rs.getBoolean(5));
                persona.setFechaRegistro(rs.getDate(6));
                lista.add(persona);
            }
            rs.close();
            sentencia.close();
            return lista;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    public void registrarEstudiante(java.util.List<Persona> students) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            conexion.setAutoCommit(false);
            java.sql.Statement sentencia = conexion.createStatement();
            java.sql.Statement sentencia2 = conexion.createStatement();
            for(Persona person: students){ 
                sentencia.execute(getCompleteStatementPerson(person),java.sql.Statement.RETURN_GENERATED_KEYS);
                java.sql.ResultSet rs = sentencia.getGeneratedKeys();
                rs.next();
                int codigo = rs.getInt(1);
                sentencia.execute(getCompleteStatementOcupation(person.getOcupacion(), codigo));
                sentencia.execute(getCompleteStatementTest(person.getPrueba(), codigo));
                rs.close();
            }        
            conexion.commit();
            sentencia2.close();
            sentencia.close();
            
        }catch(java.sql.SQLException ex){
            if(conexion != null)
                conexion.rollback();
            throw ex;
        }finally{
            if(conexion != null){
                conexion.setAutoCommit(true);
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }    
    
    public boolean removeEstudiantes(java.util.List<Persona> list) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            conexion.setAutoCommit(false);
            java.sql.Statement sentencia = conexion.createStatement();
            for(Persona person : list){
                 sentencia.executeUpdate(RB.getString("Estudiante_Delete")+person.getCodigo());
            }
            conexion.commit();
            sentencia.close();
            return true;
        }catch(java.sql.SQLException ex){
            if(conexion != null)
                conexion.rollback();
            throw ex;
        }finally{
            if(conexion != null){
                conexion.setAutoCommit(true);
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
//    ----------------------------------------------------------------------------------------------------------------
    
    private String getCompleteStatementProcees(java.util.List<Persona> list){
        StringBuilder sb = new StringBuilder(RB.getString("Estudiante_Uptate_ALL"));
        for(int i = 0; i < list.size() ; i++){
            sb.append(" codigo = ");
            sb.append(list.get(i).getCodigo());
            if(i != list.size() - 1)
                sb.append(" OR");
        }
        return sb.toString();
    }
    
    private String getCompleteStatementPerson(Persona persona){
        StringBuilder sb = new StringBuilder(RB.getString("Estudiante_Insert"));
        sb.append(" ('"); sb.append(persona.getNombreCompleto()); sb.append("','");
        sb.append(persona.getEdad()); sb.append("','"); sb.append(persona.getEnteroDeOcupacion(persona.getTipoOcupacion()));
        sb.append("',b'0','"); sb.append(persona.getFechaRegistro()); sb.append("')");
        return sb.toString();
    }
    
    private String getCompleteStatementOcupation(Ocupacion ocupacion , int codigoStudent){
        StringBuilder sb = new StringBuilder(RB.getString("Ocupacion_Insert"));
        sb.append(" (");
        sb.append(checkNull(ocupacion.getGradoCursado())); sb.append(",");
        sb.append(checkNull(ocupacion.getInstitucion())); sb.append(",");
        sb.append(checkNull(ocupacion.getCargo())); sb.append(",");
        sb.append(checkNull(ocupacion.getNivelEscolaridad())); sb.append(",");
        sb.append(checkNull(ocupacion.getPrograma())); sb.append(",");
        sb.append(checkNull(ocupacion.isCulminadoEstudio())); sb.append(",");
        sb.append(checkNull(ocupacion.getUltimoGradoCursado())); sb.append(",");
        sb.append(checkNull(codigoStudent)); sb.append(")");
        return sb.toString();
    }
    
    private String getCompleteStatementTest(Test test , int codigoStudent){
        StringBuilder sb = new StringBuilder(RB.getString("Test_Insert"));
        sb.append(" (");
        sb.append(checkNull(test.getRespuestas())); sb.append(",");
        sb.append(checkNull(codigoStudent)); sb.append(")");
        return sb.toString();
    }
    
    private String checkNull(Integer entero){
        if(entero == null){
            return "NULL";
        }else{
            return "'"+entero.intValue()+"'";
        }
    }
    
    private String checkNull(Boolean bool){
        if(bool == null){
            return "NULL";
        }else{
            return "b'"+((bool.booleanValue())? "1" : "0")+"'";
        }
    }
    
    private String checkNull(String text){
        if(text == null || text.compareTo("") == 0){
            return "NULL";
        }else{
            return "'"+text+"'";
        }
    }
}
