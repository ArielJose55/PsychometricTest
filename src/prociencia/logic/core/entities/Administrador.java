
package prociencia.logic.core.entities;

import java.io.Serializable;

/**
 *
 * @author Klac
 */
public class Administrador implements Serializable{
    
    private int cedula;
    private String nombres;
    private String apellidos;
    private String password;

    public Administrador() {
    }

    public Administrador(int cedula) {
        this.cedula = cedula;
    }

    public Administrador(int cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    public Administrador(int cedula, String nombres, String apellidos, String password) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.password = password;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
