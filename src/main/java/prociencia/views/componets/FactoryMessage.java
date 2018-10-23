
package prociencia.views.componets;


/**
 *
 * @author Klac
 */
public class FactoryMessage {
    
    private static final java.util.ResourceBundle RB = 
            java.util.ResourceBundle.getBundle("prociencia/views/componets/"+FactoryMessage.class.getSimpleName());
    
    public static void  createMessageAlert(Class clase, String taget){
        javax.swing.JOptionPane option = new javax.swing.JOptionPane(RB.getString(clase.getSimpleName()+"."+taget), javax.swing.JOptionPane.ERROR_MESSAGE);
        option.setComponentOrientation(javax.swing.JOptionPane.getRootFrame().getComponentOrientation());
        javax.swing.JDialog dialog = option.createDialog("Advertencia");
        dialog.setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(FactoryMessage.class.getResource("abort-icon.png")));
        option.selectInitialValue();
        option.setIcon(new javax.swing.ImageIcon(FactoryMessage.class.getResource("Error.png")));
        
        dialog.setVisible(true);
        dialog.dispose();
    }
    
    public static void createMessageAlert(Throwable ex){
        javax.swing.JOptionPane option = new javax.swing.JOptionPane(ex.getMessage(),javax.swing.JOptionPane.ERROR_MESSAGE);
        option.setIcon(new javax.swing.ImageIcon(FactoryMessage.class.getResource("Error.png")));
        option.setComponentOrientation(javax.swing.JOptionPane.getRootFrame().getComponentOrientation());
        javax.swing.JDialog dialog = option.createDialog("Advertencia");
        dialog.setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(FactoryMessage.class.getResource("abort-icon.png")));
        option.selectInitialValue();
                
        dialog.setVisible(true);
        dialog.dispose();
    }
    
    public static javax.swing.JOptionPane createMessageInformation(Class clase, String taget){
        javax.swing.JOptionPane option = new javax.swing.JOptionPane(RB.getString(clase.getSimpleName()+"."+taget), javax.swing.JOptionPane.INFORMATION_MESSAGE);
        option.setIcon(new javax.swing.ImageIcon(FactoryMessage.class.getResource("OK.png")));
        option.setComponentOrientation(javax.swing.JOptionPane.getRootFrame().getComponentOrientation());
        javax.swing.JDialog dialog = option.createDialog("Mensaje");
        dialog.setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage(FactoryMessage.class.getResource("OK-icon.png")));
        option.selectInitialValue();
        
        dialog.setVisible(true);
        return  option;
    }
}
