/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia.logic.core.daos;


import prociencia.logic.core.util.connections.ConnectionPool;

/**
 *
 * @author Klac
 */
public class AdministradorDao {
    
    
    private final java.util.ResourceBundle RB = java.util.ResourceBundle.getBundle("prociencia/logic/core/daos/sentencias");
    
    /**
     * Metodo verificado (Sintaxis)
     * @param passwork
     * @return
     * @throws java.sql.SQLException 
     */
    public boolean verificarUsuario(String passwork) throws java.sql.SQLException {
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int row;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Usuario_verifica_V"));
            sentencia.setString(1, passwork);
            java.sql.ResultSet rs = sentencia.executeQuery();
            rs.last();
            row = rs.getRow();
            rs.close();
            sentencia.close();
            return row == 1;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    /**
     *  Metodo verificado (Sintaxis)
     * @param password
     * @return
     * @throws java.sql.SQLException 
     */
    public boolean changedPasswordTutor(String password)throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int row;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Usuario_ConfiPassTutor_V"));
            sentencia.setString(1, password);
            row = sentencia.executeUpdate();
            sentencia.close();
            return row == 1;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    /**
     * Metodo verificado (Sintaxis)
     * @return
     * @throws java.sql.SQLException 
     */
    public String getPassTutor()throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            java.sql.Statement sentencia = conexion.createStatement();
            java.sql.ResultSet rs = sentencia.executeQuery(RB.getString("Usuario_Tutor_V"));
            rs.last();
            if(rs.getRow() == 1){
                return rs.getString(1);
            }else if(rs.getRow() == 0){
                return "****";
            }
            
            throw new java.sql.SQLException("Resulset Vacio");
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
    
    /**
     * Metodo verificado (Sintaxis)
     * @param passworkOld
     * @param passwork
     * @return
     * @throws java.sql.SQLException 
     */
    public boolean updatePassword(String passworkOld,String passwork) throws java.sql.SQLException{
        java.sql.Connection conexion = null;
        
        try{
            conexion = ConnectionPool.getConexionPool().getConnection();
            int i;
            java.sql.PreparedStatement sentencia = conexion.prepareStatement(RB.getString("Usuario_ConfiPass_V"));
            sentencia.setString(1, passwork);
            sentencia.setString(2, passworkOld);
            i = sentencia.executeUpdate();
            sentencia.close();
            return i == 1;
        }finally{
            if(conexion != null){
                ConnectionPool.getConexionPool().devolverConexion(conexion);
            }
        }
    }
}
