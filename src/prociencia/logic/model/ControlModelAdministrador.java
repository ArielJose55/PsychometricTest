

package prociencia.logic.model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableRowSorter;
import prociencia.logic.core.entities.Persona;
import prociencia.logic.core.util.tads.TableModelData;

/**
 *
 * @author Klac
 */
public class ControlModelAdministrador {
    
    private static ControlModelAdministrador logica = null;
    
    private final javax.swing.table.TableRowSorter<TableModelData> tableRowSorter;
    
    private javax.swing.RowFilter<TableModelData,Integer> rowFieldSearch;
    private javax.swing.RowFilter<TableModelData,Integer> rowFilterProcess;
    private javax.swing.RowFilter<TableModelData,Integer> rowfilterOcupation;
    private javax.swing.RowFilter<TableModelData,Integer> rowfilterDate;
    
    private String filterNames;
    private Boolean filterProcess;
    private String filterOcupation;
    private String filterDate;
    
    private javax.swing.JScrollPane panelViewTable;
    private javax.swing.JPanel panelCenter;

    private ControlModelAdministrador() {
        tableRowSorter = new javax.swing.table.TableRowSorter<TableModelData>(ControlModel.getInstance().getTableModel());
        initFiltering();
    }
    
     static ControlModelAdministrador getInstance(){
        if(logica == null){
            logica = new ControlModelAdministrador();
        }
        return logica;
    }
    
    static void destrucModeAdministrador()
    {
        logica = null;
    }   
//    -------------------------------------------------------------SETTES AND GETTES ------------------------------
    public TableRowSorter<TableModelData> getTableRowSorter() {
        return tableRowSorter;
    }

    public void setPanelViewTable(JScrollPane panelViewTable) {
        this.panelViewTable = panelViewTable;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public void setFilterNames(String filterNames) {
        this.filterNames = filterNames;
    }

    public void setFilterProcess(Boolean filterProcess) {
        this.filterProcess = filterProcess;
    }

    public void setFilterOcupation(String filterOcupation) {
        this.filterOcupation = filterOcupation;
    }

    public void setFilterDate(String filterDate) {
        this.filterDate = filterDate;
    }
    
//    ----------------------------------------------------------------------------------------------------------------
    
    private void initFiltering(){
        rowFieldSearch = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterNames) || compateTo("Buscar por nombres", filterNames)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona persona = modelo.getPersona(entrada.getIdentifier());
                return isNotNull(persona.getNombreCompleto()) && compareOrContains(persona.getNombreCompleto(), filterNames);
            }
        };
        
        rowFilterProcess = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterProcess)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona persona = modelo.getPersona(entrada.getIdentifier());
                if(filterProcess.compareTo(Boolean.TRUE) == 0){
                    return isNotNull(persona.isProcesado()) && compareTo(!persona.isProcesado(), filterProcess);
                }else{
                    return true;
                }
            }
        };
        
        rowfilterOcupation = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterOcupation) && compateTo("Seleccione una Ocupación", filterOcupation)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona persona = modelo.getPersona(entrada.getIdentifier());
                return isNotNull(persona.getStringDeOcupacion(persona.getTipoOcupacion())) && compareOrContains(persona.getStringDeOcupacion(persona.getTipoOcupacion()), filterOcupation);
            }
        };
        
        
        
        rowfilterDate = new javax.swing.RowFilter<TableModelData, Integer>(){
            @Override
            public boolean include(javax.swing.RowFilter.Entry<? extends TableModelData,? extends Integer> entrada){
                if(!isNotNull(filterDate) || compateTo("Seleccione una fecha", filterDate)) return true;
                TableModelData modelo = entrada.getModel();
                if(modelo.getRowCount() == 0) return false;
                Persona persona = modelo.getPersona(entrada.getIdentifier());
                return compateTo(persona.getFechaRegistro().toString(), filterDate);
            }
        };
    }
    
    public void startFiltering(){
     /*1*/   if(isNotNull(filterProcess) && isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(4);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                select.add(rowfilterOcupation);
                select.add(rowfilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
     /*2*/    }else if(isNotNull(filterProcess) && isNotNull(filterOcupation) && !isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(3);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                select.add(rowfilterOcupation);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*3*/     }else if(isNotNull(filterProcess) && !isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(3);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                select.add(rowfilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*4*/     }else if(isNotNull(filterProcess) && !isNotNull(filterOcupation) && !isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(2);
                select.add(rowFieldSearch);
                select.add(rowFilterProcess);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*5*/     }else if(!isNotNull(filterProcess) && isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(3);
                select.add(rowFieldSearch);
                select.add(rowfilterOcupation);
                select.add(rowfilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*6*/     }else if(!isNotNull(filterProcess) && isNotNull(filterOcupation) && !isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(2);
                select.add(rowFieldSearch);
                select.add(rowfilterOcupation);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
     /*7*/    }else if(!isNotNull(filterProcess) && !isNotNull(filterOcupation) && isNotNull(filterDate)){
                java.util.List<javax.swing.RowFilter<TableModelData,Integer>> select = new java.util.ArrayList<javax.swing.RowFilter<TableModelData,Integer>>(2);
                select.add(rowFieldSearch);
                select.add(rowfilterDate);
                javax.swing.RowFilter<TableModelData,Integer> comboFilter = javax.swing.RowFilter.andFilter(select);
                tableRowSorter.setRowFilter(comboFilter);
    /*8*/     }else{
                tableRowSorter.setRowFilter(rowFieldSearch);
    /**/      }
    }
    
    public void changedViewAtMode(){
        panelCenter.removeAll();
        panelCenter.add(panelViewTable,java.awt.BorderLayout.CENTER);
        panelCenter.updateUI();
    }
    
//    -------------------------------------------------------UTIL--------------------------------------------------------
    public boolean isNotNull(Boolean entero){
        return entero != null;
    }
    
    public boolean compareTo(Boolean entero, Boolean entero2){
        return entero.compareTo(entero2) == 0;
    }
    
    private boolean isNotNull(String filter){
        return filter != null && filter.compareTo("") != 0;
    }
    
    private boolean compareOrContains(String textOrigen,String textDestine) {
        return textOrigen.toLowerCase().replace(" ", "").contains(textDestine.toLowerCase().replace(" ", ""));
    }
    
    private boolean compateTo(String textOrigen,String textDestine){
        return textOrigen.toLowerCase().replace(" ", "").compareTo(textDestine.toLowerCase().replace(" ", "")) == 0;
    }
}
