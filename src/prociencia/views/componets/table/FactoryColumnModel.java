package prociencia.views.componets.table;

/**
 *
 * @author Klac
 */
public class FactoryColumnModel {
    
    public static javax.swing.table.TableColumnModel createModelColumnTableMain(){
        javax.swing.table.DefaultTableColumnModel tablaColumn = new  javax.swing.table.DefaultTableColumnModel();
        tablaColumn.setColumnMargin(0);
        int ancho[] ={350,50,150,200,80};
        String cabeceras[] = {"  Nombres","Edad","Ocupación","Fecha de Registro","Procesado"}; 
        for(int i = 0; i < cabeceras.length ; i++){
                javax.swing.table.TableColumn columna = new javax.swing.table.TableColumn(i,ancho[i]);
                columna.setHeaderValue(cabeceras[i]);
                javax.swing.table.DefaultTableCellRenderer rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(-1, TypeTable.TABLE_MAIN);
                columna.setHeaderRenderer(rowRenderer);
                if(i == 4){
                  rowRenderer = FactoryCellTableRenderer.createTableCellRendererProcess();
                }else{
                    rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(i, TypeTable.TABLE_MAIN);
                }
                columna.setCellRenderer(rowRenderer);
                tablaColumn.addColumn(columna);
        }
        return tablaColumn;
    }
    
    public static javax.swing.table.TableColumnModel createModelColumnTableRegistro(){
        javax.swing.table.DefaultTableColumnModel tablaColumn = new  javax.swing.table.DefaultTableColumnModel();
        tablaColumn.setColumnMargin(0);
        int ancho[] ={350,60,150,200};
        String cabeceras[] = {"NOMBRES","EDAD","OCUPACIÓN","FECHA DE REGISTRO"};
        for(int i = 0; i < 4 ; i++){
                javax.swing.table.TableColumn columna = new javax.swing.table.TableColumn(i,ancho[i]);
                columna.setHeaderValue(cabeceras[i]);
                javax.swing.table.DefaultTableCellRenderer rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(-1, TypeTable.TABLE_REGISTRO);
                columna.setHeaderRenderer(rowRenderer);
                rowRenderer = FactoryCellTableRenderer.createTableCellRenderer(i, TypeTable.TABLE_REGISTRO);
                columna.setCellRenderer(rowRenderer);
                tablaColumn.addColumn(columna);
        }
        return tablaColumn;
    }
    
}
