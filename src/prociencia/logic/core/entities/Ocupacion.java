

package prociencia.logic.core.entities;

/**
 *
 * @author Klac
 */
public class Ocupacion implements java.io.Serializable{
    
    private Integer codigo;
    private Integer gradoCursado;
    private String institucion;
    private String cargo;
    private String nivelEscolaridad;
    private String programa;
    private Boolean culminadoEstudio;
    private Integer ultimoGradoCursado;
    private Integer codigoEstudiante;

    public Ocupacion() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getGradoCursado() {
        return gradoCursado;
    }

    public void setGradoCursado(Integer gradoCursado) {
        this.gradoCursado = gradoCursado;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = normalizeText(institucion);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public String getNivelEscolaridad() {
        return nivelEscolaridad;
    }

    public void setNivelEscolaridad(String nivelEscolaridad) {
        this.nivelEscolaridad = normalizeText(nivelEscolaridad);
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
    
    public Boolean isCulminadoEstudio() {
        return culminadoEstudio;
    }

    public void setCulminadoEstudio(Boolean culminadoEstudio) {
        this.culminadoEstudio = culminadoEstudio;
    }

    public Integer getUltimoGradoCursado() {
        return ultimoGradoCursado;
    }

    public void setUltimoGradoCursado(Integer ultimoGradoCursado) {
        this.ultimoGradoCursado = ultimoGradoCursado;
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }
    
    private String normalizeText(String text){
        if(text == null || text.compareTo("") == 0) return null;
        if(text.contains(" ")){
            String[] texts = text.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String texto : texts){
                sb.append(normalizeText(texto));
                sb.append(" ");
            }
            return sb.toString();
        }else{
            if(text.length() > 0){
                String newText = text.toLowerCase();
                return newText.replaceFirst(String.valueOf(newText.charAt(0)), String.valueOf(Character.toUpperCase(newText.charAt(0))));
            }
            return text;
        }
    }
}
