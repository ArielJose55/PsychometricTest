

package prociencia.logic.core.util.tads;

import prociencia.logic.core.entities.Persona;


/**
 *
 * @author Klac
 */
public class TableModelData extends javax.swing.table.AbstractTableModel{

    private java.util.List<Persona> lista;

    public TableModelData() {
        this.lista = null;
    }

    public TableModelData(java.util.List<Persona> lista) {
        this.lista = lista;
    }

    public java.util.List<Persona> getLista() {
        return lista;
    }

    public void addListaAndReplace(java.util.List<Persona> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
    public void addLista(java.util.List<Persona> lista){
        if(this.lista == null){
            this.lista = lista;
            fireTableRowsInserted(0, lista.size());
        }
        this.lista.addAll(lista);
        fireTableRowsInserted(this.lista.size(), this.lista.size() - 1 + lista.size());
        
    }
    
    public Persona getPersona(int fila){
        return lista.get(fila);
    }
    
    @Override
    public int getRowCount() {
        return (lista == null)? 0:lista.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Class getColumnClass(int column){
        if(column == 1){
            return Integer.class;
        }else if(column == 4){
            return Boolean.class;
        }else{
            return String.class;
        }
    }
    
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(lista == null) return null;
        return getAtributo(lista.get(rowIndex), columnIndex);
    }
    
    private Object getAtributo(Persona persona, int  column){
        switch(column){
            case 0: return "  "+persona.getNombreCompleto();
            case 1: return persona.getEdad();
            case 2: return persona.getStringDeOcupacion(persona.getTipoOcupacion());
            case 3: return persona.getFechaRegistro().toString();
            case 4: return persona.isProcesado();
            default: return null;
        }
    }
}
