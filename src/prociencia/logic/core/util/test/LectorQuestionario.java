
package prociencia.logic.core.util.test;

import prociencia.logic.core.entities.Pregunta;


public class LectorQuestionario {
    
    private  final java.util.List<Pregunta> PREGUNTAS;

    public LectorQuestionario() {
        this.PREGUNTAS = new java.util.ArrayList<Pregunta>();
    }
    
    public static java.util.List<Pregunta> getPreguntas() throws Exception{
        LectorQuestionario lector = new LectorQuestionario();
        lector.iniLeaderData();
        return lector.PREGUNTAS;
    }
    
    private void iniLeaderData() throws Exception{
        org.jdom2.Document documento = new org.jdom2.input.SAXBuilder().build(LectorQuestionario.class.getResource("Questionario.xml"));
        
        org.jdom2.Element elemento = documento.getRootElement();
        
        for(org.jdom2.Element question:elemento.getChildren()){
            Pregunta pregunta = new Pregunta(question.getTextNormalize());
            int i = 0;
            for(org.jdom2.Element respuesta:question.getChildren()){
                switch(i){
                    case 0:{
                        pregunta.setOpcionA(respuesta.getTextNormalize());
                        break;
                    }
                    case 1:{
                        pregunta.setOpcionB(respuesta.getTextNormalize());
                        break;
                    }
                    case 2:{
                        pregunta.setOpcionC(respuesta.getTextNormalize());
                        break;
                    }
                    
                }
                i++;
            }
            
            PREGUNTAS.add(pregunta);
        }
    }
    
}
