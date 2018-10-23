
package prociencia.views.componets.table;


/**
 *
 * @author Klac
 */
class FactoryCellTableRenderer{
    
    static javax.swing.table.DefaultTableCellRenderer createTableCellRenderer(int columna,TypeTable typeTable){
        if(typeTable.compareTo(TypeTable.TABLE_MAIN) == 0){
            return new RowRendererOfClassOne(columna);
        }else{
            return new RowRendererOfClassTwo(columna);
        }
    }
    
    static javax.swing.table.DefaultTableCellRenderer createTableCellRendererProcess(){
        return new RowRendererOfClassTree();
    }
    
    private static class RowRendererOfClassOne extends javax.swing.table.DefaultTableCellRenderer{
        private final int columna;

        RowRendererOfClassOne(int columna) {
            this.columna = columna;
        }
        
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(null);
            setBackground(java.awt.Color.WHITE);
            if(column != 0 && column != 5)
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            if(columna < 0){
                setPreferredSize(new java.awt.Dimension(12, 36));
                setFont(new java.awt.Font("Tahoma", 1, 19));
                setForeground(new java.awt.Color(90,90,90));
                return this;
            }
            if(isSelected){
                setBackground(table.getSelectionBackground());
                setForeground(table.getSelectionForeground());
            }else{
                setForeground(new java.awt.Color(39,38,39));
            }
            setFont(new java.awt.Font("Arial", 0, 16));
            return this;
        }
    }
    
    private static class RowRendererOfClassTwo extends javax.swing.table.DefaultTableCellRenderer{
        
        private final int columna;

        RowRendererOfClassTwo(int columna) {
            this.columna = columna;
        }
        
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            setBackground(java.awt.Color.WHITE);
            if(column != 0 && column != 5)
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            if(columna < 0){
                setPreferredSize(new java.awt.Dimension(12, 40));
                setFont(new java.awt.Font("Arial", 1, 20));
                setForeground(new java.awt.Color(120,120,120));
                return this;
            }
          
            if(isSelected){
                setBackground(new java.awt.Color(228,240,255));
                setForeground(table.getSelectionForeground());
            }else{
                setForeground(new java.awt.Color(130,130,130));
                
            }
            setFont(new java.awt.Font("Arial", 0, 16));
            return this;
        }
    }
    
    private static class RowRendererOfClassTree extends javax.swing.table.DefaultTableCellRenderer{

        private final javax.swing.ImageIcon images[] = {new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/Procesado28x28.png")),
                                                        new javax.swing.ImageIcon(getClass().getResource("/prociencia/views/resources/NoProcesado28x28.png"))};
        
        RowRendererOfClassTree() {
        }
        
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
             javax.swing.table.TableModel model = table.getModel(); 
             boolean winner = ((Boolean) model.getValueAt(table.convertRowIndexToModel(row), 
                     4)).booleanValue();
             
             if(winner){
                 setIcon(images[0]);
             }else{
                 setIcon(images[1]);
             }
            setText("");
            setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            setBackground(java.awt.Color.WHITE);
            setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            if(isSelected){
                setBackground(new java.awt.Color(228,240,255));
                setForeground(table.getSelectionForeground());
            }else{
                setForeground(new java.awt.Color(130,130,130));
                
            }
            return this;
        }
    }
}