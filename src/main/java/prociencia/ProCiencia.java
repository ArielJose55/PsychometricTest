

package prociencia;

import prociencia.views.frames.MainFrame;

/**
 *
 * @author Klac
 */
public class ProCiencia {
    
    
    public static void main(String[] args) throws InstantiationException, ClassNotFoundException, IllegalAccessException, javax.swing.UnsupportedLookAndFeelException { 

//        javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
//        org.jvnet.substance.skin.CremeSkin
//        org.jvnet.substance.theme.SubstanceCremeTheme
//        javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
//        javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
//        org.jvnet.substance.SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin");
//        org.jvnet.substance.SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceCremeTheme");
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame().setVisible(true); 
            }
        });
    }
    
}
