

package prociencia.logic.core.util.tads;

import javax.swing.event.DocumentEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Klac
 */
public class JTextFieldTad extends javax.swing.JTextField{
    
    private boolean numeric;
    private boolean emply;
    private boolean espacio = true;

    public JTextFieldTad() {
        this(false);
    }

    public JTextFieldTad(boolean numeric) {
        super();
        this.numeric = numeric;
    }

    public boolean fieldEmply(){
        return this.getText().compareTo("") == 0;
    }
    
    @Override
    protected Document createDefaultModel() {
        return new PlainDocumentTad();
    }
    
    public void setNumeric(boolean numeric){
        this.numeric = numeric;
    }
    
    protected class PlainDocumentTad extends javax.swing.text.PlainDocument{

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if(!numeric){
                char[] fuente = str.toCharArray();
                char[] resultado = new char[fuente.length];
                int j = 0;
                
                for(int i = 0; i < fuente.length;){
                    if(espacio){
                        resultado[j++] = String.valueOf(fuente[i]).toUpperCase().charAt(0);
                        espacio = false;
                    }else{
                        if(fuente[i] == ' '){
                            espacio = true;
                        }
                        resultado[j++] = fuente[i];
                    }
                    i++;
                }
                super.insertString(offs, new String(resultado, 0, j), a);
            }else{
                char[] fuente = str.toCharArray();
                char[] resultado = new char[fuente.length];
                int j = 0;
                
                for(int i = 0; i < fuente.length; i++){
                    if(fuente[i] >= '0' && fuente[i] <= '9'){
                        resultado[j++] = fuente[i];
                    }else{
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    }
                }
                super.insertString(offs, new String(resultado, 0, j), a);
            }
            
        }

        @Override
        protected void fireRemoveUpdate(DocumentEvent e) {
            if(e.getDocument().getLength() == 0){
                espacio = true;
            }
            super.fireRemoveUpdate(e); //To change body of generated methods, choose Tools | Templates.
        }
        
    
    }
}
