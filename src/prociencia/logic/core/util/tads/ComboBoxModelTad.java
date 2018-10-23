
package prociencia.logic.core.util.tads;

import prociencia.logic.core.daos.TestDao;


/**
 *
 * @author Klac
 */
public class ComboBoxModelTad extends javax.swing.DefaultComboBoxModel<Object>{

    private java.util.List lista;
    
    public ComboBoxModelTad(int type) {
        if(type == 0){
            lista = new java.util.ArrayList();
            lista.add("Seleccione una Ocupación");
            lista.add("Estudiante");
            lista.add("Empleado");
            lista.add("Otro");
        }else{
            lista = new java.util.ArrayList();
            lista.add("Seleccione una Fecha");
            try {
                this.lista.addAll(new TestDao().getFechas());
            } catch (java.sql.SQLException ex) {
                lista.add("Fecha no obtenidas");
                ex.printStackTrace();
            }
        }
    }

    public void update(){
        if(lista.size() > 0){
            if(lista.get(1) instanceof java.sql.Date){
                int ultimo = lista.size();
                lista = new java.util.ArrayList();
                fireIntervalRemoved(this, 0, ultimo);
                lista.add("Seleccione una Fecha");
                try {
                    this.lista.addAll(new TestDao().getFechas());
                } catch (java.sql.SQLException ex) {
                    lista.add("Fecha no obtenidas");
                    ex.printStackTrace();
                }finally{
                    ultimo = lista.size();
                    fireIntervalAdded(this, 0, ultimo);
                }
            }
        }
    }
    
    @Override
    public Object getElementAt(int index) {
        return (lista == null) ? null : lista.get(index);
    }

    @Override
    public int getSize() {
        return (lista == null) ? 0: lista.size();
    }
    
}
