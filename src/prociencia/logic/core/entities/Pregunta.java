

package prociencia.logic.core.entities;

/**
 *
 * @author Klac
 */
public class Pregunta {
    
    private String pregunta;
    private String opcionA;
    private String opcionB;
    private String opcionC;

    public Pregunta() {
        pregunta = "";
        opcionA = "";
        opcionB = "";
        opcionC = "";
    }

    public Pregunta(String pregunta) {
        this();
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }
    
    
}
