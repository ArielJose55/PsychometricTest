

package prociencia.logic.core.daos;

import prociencia.logic.core.entities.Persona;
import prociencia.logic.core.entities.Test;
import prociencia.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class TestDao {
    
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia/logic/core/daos/sentencias");
    
    public boolean registrarTest(Test test) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int i;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Test_registro"));
            sentencia.setString(1, test.getRespuestas());
            sentencia.setInt(2, test.getCodigoEstudiante());
            i = sentencia.executeUpdate();
            sentencia.close();
            return i < 0;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    public boolean registrar(java.sql.Connection connection,Test test) throws java.sql.SQLException{
        java.sql.PreparedStatement sentencia = connection.prepareStatement(RB.getString("Test_registro"));
        sentencia.setString(1, test.getRespuestas());
        sentencia.setInt(2, test.getCodigoEstudiante());
        boolean i = sentencia.execute();
        sentencia.close();
        return i;
    }
    
    public Test getTest(int codigoEstudiante) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Test_getTest"));
            sentencia.setInt(1, codigoEstudiante);
            java.sql.ResultSet rs = sentencia.executeQuery();
            rs.last();
            if(rs.getRow() == 1){
                Test test = new Test(rs.getInt(1), codigoEstudiante);
                test.setRespuestas(rs.getString(2));
                rs.close();
                sentencia.close();
                return test;
            }else{
                rs.close();
                sentencia.close();
                return null;
            }
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
     public void updateTestFromPerson(java.util.List<Persona> list) throws java.sql.SQLException{
         java.sql.Connection connection = null;
         try{
             connection = ConnectionPool.getConexionPool().getConnection();
             java.sql.Statement sentencia = connection.createStatement();
             for(Persona person : list){
                 java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Test_getTestL")+person.getCodigo());
                 while(rs.next()){
                     Test test = new Test();
                     test.setRespuestas(rs.getString(2));
                     person.setPrueba(test);
                 }
                 rs.close();
             }
         }finally{
             if(connection != null){
                 ConnectionPool.getConexionPool().devolverConexion(connection);
             }
         }
     }
    
    public java.util.List<java.sql.Date> getFechas() throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            java.util.List<java.sql.Date> lista = new java.util.ArrayList<java.sql.Date>();
            java.sql.Statement sentencia = conexion.createStatement();
            java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Estudiante_getFecha"));
            while(rs.next()){
                 lista.add(rs.getDate(1));
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
}
