

package prociencia.logic.core.entities;



public class Test implements java.io.Serializable{
    
    private Integer codigo;
    private String respuestas;
    private Integer codigoEstudiante;

    public Test() {
    }

    public Test(int codigo, int codigoEstudiante) {
        this.codigo = codigo;
        this.codigoEstudiante = codigoEstudiante;
    }
    
    public Test(int codigo, String respuestas, int codigoEstudiante) {
        this.codigo = codigo;
        this.respuestas = respuestas;
        this.codigoEstudiante = codigoEstudiante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public String toString() {
        return respuestas;
    }
    
}
