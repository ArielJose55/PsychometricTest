

package prociencia.logic.sheetexcels;

import org.apache.poi.ss.usermodel.Cell;
import prociencia.logic.core.daos.OcupacionDao;
import prociencia.logic.core.daos.PersonaDao;
import prociencia.logic.core.daos.TestDao;
import prociencia.logic.core.entities.OcupacionEnum;
import prociencia.logic.core.entities.Persona;

/**
 *
 * @author Klac
 */
public class WriterExcel {
    
    private final java.util.List<Persona> LIST;
    private final java.io.File archivo;
    private final OcupacionEnum OCUPATIONS[] = {OcupacionEnum.ESTUDIANTE,OcupacionEnum.EMPLEADO,OcupacionEnum.OTRO};
    private static final int ROW_HEADER = 0;
    private static final String ESTUDIANTE_HEADER[] = {"NOMBRES","EDAD","FECHA DE REGISTRO","INSTITUCIÓN","GRADO CURSADO","RESPUESTAS"};
    private static final String EMPLEADO_HEADER[] = {"NOMBRES","EDAD","FECHA DE REGISTRO","EMPRESA","CARGO","NIVEL DE ESCOLARIDAD","PROGRAMA","CULMINO","ULTIMO GRADO","RESPUESTAS"};
    private static final String OTRO_HEADER[] = {"NOMBRES","EDAD","FECHA DE REGISTRO","CARGO","NIVEL DE ESCOLARIDAD","PROGRAMA","CULMINO","ULTIMO GRADO","RESPUESTAS"};

    public WriterExcel(java.io.File archivo, java.util.List<Persona> list,boolean marcar) throws Exception {
        this.archivo = archivo;
        this.LIST = list;
        startResearchAttibutePerson();
        if(marcar)
            new PersonaDao().uptateProcessPerson(list);
    }
    
    public final void startResearchAttibutePerson() throws Exception{
        new OcupacionDao().updateListFromPerson(LIST);
        new TestDao().updateTestFromPerson(LIST);
    }
    
    public void startWriting() throws Exception{
        org.apache.poi.hssf.usermodel.HSSFWorkbook workbook = new org.apache.poi.hssf.usermodel.HSSFWorkbook();
        int i= 0;
        
        for(OcupacionEnum ocupation : OCUPATIONS){
            if(FactoryUtility.isContentOcupation(LIST, ocupation)){
                org.apache.poi.hssf.usermodel.HSSFSheet sheet = workbook.createSheet(FactoryUtility.convertePlural(ocupation.name()));
                FactoryUtility.writerHeader(workbook, sheet, ocupation);
                java.util.List<Persona> subList = FactoryUtility.getSubList(LIST, ocupation);
                FactoryUtility.writerCell(workbook, sheet, ocupation, subList);
            }
        }
        
        java.io.FileOutputStream stream = new java.io.FileOutputStream(archivo);
        workbook.write(stream);
        stream.close();
    }
    
  
    
    private static class FactoryUtility{
        
        static boolean isContentOcupation(java.util.List<Persona> list,OcupacionEnum ocupation){
            for(Persona person :  list){
                if(person.getTipoOcupacion().compareTo(ocupation) == 0)
                    return true;
            }
            return false;
        }
        
        static java.util.List<Persona> getSubList(java.util.List<Persona> list,OcupacionEnum ocupation){
            final java.util.List<Persona> subList = new java.util.ArrayList<Persona>();
            for(Persona person : list){
                if(person.getTipoOcupacion().compareTo(ocupation) == 0){
                    subList.add(person);
                }
            }
            return subList;
        }
        
        static String convertePlural(String single){
            return single+"S";
        }
        
        static void writerHeader(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook,org.apache.poi.hssf.usermodel.HSSFSheet sheet, OcupacionEnum ocupacion){
            switch(ocupacion){
                case ESTUDIANTE:{
                    org.apache.poi.ss.usermodel.Row row = sheet.createRow(ROW_HEADER);
                    row.setHeight((short)400);
                    for(int i = 0; i < ESTUDIANTE_HEADER.length ; i++){
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(i);
                        cell.setCellStyle(createFontTytle(workbook));
                        cell.setCellValue(ESTUDIANTE_HEADER[i]);
                    }
                    break;
                }
                case EMPLEADO:{
                    org.apache.poi.ss.usermodel.Row row = sheet.createRow(ROW_HEADER);
                    row.setHeight((short)400);
                    for(int i = 0; i < EMPLEADO_HEADER.length ; i++){
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(i);
                        cell.setCellStyle(createFontTytle(workbook));
                        cell.setCellValue(EMPLEADO_HEADER[i]);
                    }
                    break;
                }
                case OTRO:{
                    org.apache.poi.ss.usermodel.Row row = sheet.createRow(ROW_HEADER);
                    row.setHeight((short)400);
                    for(int i = 0; i < OTRO_HEADER.length ; i++){
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(i);
                        cell.setCellStyle(createFontTytle(workbook));
                        cell.setCellValue(OTRO_HEADER[i]);
                    }
                    break;
                }
            }
        }
        
        static org.apache.poi.hssf.usermodel.HSSFCellStyle createFontTytle(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook){
            org.apache.poi.hssf.usermodel.HSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setColor(org.apache.poi.hssf.util.HSSFColor.BLACK.index);
            font.setFontName(org.apache.poi.hssf.usermodel.HSSFFont.FONT_ARIAL);
            font.setFontHeight((short)250);
            org.apache.poi.hssf.usermodel.HSSFCellStyle style = workbook.createCellStyle();
            style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_CENTER);
            style.setVerticalAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.VERTICAL_CENTER);
            style.setFont(font);
            style.setBorderBottom(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderTop(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderLeft(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderRight(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_MEDIUM);
            style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.AQUA.index);
            style.setFillPattern(org.apache.poi.ss.usermodel.CellStyle.SOLID_FOREGROUND);
            return style;
        }
        
        static org.apache.poi.hssf.usermodel.HSSFCellStyle createFontCell(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook){
            org.apache.poi.hssf.usermodel.HSSFFont font = workbook.createFont();
            font.setColor(org.apache.poi.hssf.util.HSSFColor.BLACK.index);
            font.setFontName(org.apache.poi.hssf.usermodel.HSSFFont.FONT_ARIAL);
            font.setFontHeight((short)200);
            org.apache.poi.hssf.usermodel.HSSFCellStyle style = workbook.createCellStyle();
            style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
            style.setVerticalAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.VERTICAL_CENTER);
            style.setFont(font);
            style.setBorderBottom(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_MEDIUM);
            style.setBorderRight(org.apache.poi.hssf.usermodel.HSSFCellStyle.BORDER_MEDIUM);
            style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.WHITE.index);
            style.setFillPattern(org.apache.poi.ss.usermodel.CellStyle.SOLID_FOREGROUND);
            return style;
        }
        
        static void writerCell(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook,org.apache.poi.hssf.usermodel.HSSFSheet sheet, OcupacionEnum ocupacion,java.util.List<Persona> subList){
            switch(ocupacion){
                case ESTUDIANTE: {
                    for(int i = 0; i < subList.size() ; i++){
                        org.apache.poi.ss.usermodel.Row row = sheet.createRow(i + 1);
                        row.setHeight((short)300);
                        for(int j = 0 ; j < ESTUDIANTE_HEADER.length; j++){
                            org.apache.poi.ss.usermodel.Cell cell = row.createCell(j);
                            cell.setCellStyle(createFontCell(workbook));
                            switch(j){
                                case 0:{
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                                    cell.setCellValue(subList.get(i).getNombreCompleto());
                                    break;
                                }
                                case 1:{
                                    cell.setCellValue(subList.get(i).getEdad());
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC);
                                    break;
                                }
                                case 2:{
                                    cell.setCellValue(subList.get(i).getFechaRegistro().toString());
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 3:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getInstitucion());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 4:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getGradoCursado());
                                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                    break;
                                }
                                case 5:{
                                    cell.setCellValue(subList.get(i).getPrueba().getRespuestas());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                            }
                            sheet.autoSizeColumn(j);
                        }
                    }
                    break;
                }
                case EMPLEADO: {
                    for(int i = 0; i < subList.size() ; i++){
                        org.apache.poi.ss.usermodel.Row row = sheet.createRow(i + 1);
                        row.setHeight((short)400);
                        for(int j = 0 ; j < EMPLEADO_HEADER.length; j++){
                            org.apache.poi.ss.usermodel.Cell cell = row.createCell(j);
                            cell.setCellStyle(createFontCell(workbook));
                            switch(j){
                                case 0:{
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                                    cell.setCellValue(subList.get(i).getNombreCompleto());
                                    break;
                                }
                                case 1:{
                                    cell.setCellValue(subList.get(i).getEdad());
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC);
                                    break;
                                }
                                case 2:{
                                    cell.setCellValue(subList.get(i).getFechaRegistro().toString());
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 3:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getInstitucion());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 4:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getCargo());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 5:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getNivelEscolaridad());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 6:{
                                    cell.setCellValue((subList.get(i).getOcupacion().getPrograma() == null || subList.get(i).getOcupacion().getPrograma().compareTo("") == 0)?
                                            "No Aplica" : subList.get(i).getOcupacion().getPrograma());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 7:{
                                    cell.setCellValue(subList.get(i).getOcupacion().isCulminadoEstudio() ? "SI" : "NO");
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 8:{
                                    cell.setCellValue(subList.get(i).getOcupacion().isCulminadoEstudio() ? "No Aplica" :
                                            subList.get(i).getOcupacion().getUltimoGradoCursado()+"");
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 9:{
                                    cell.setCellValue(subList.get(i).getPrueba().getRespuestas());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                }
                            }
                            sheet.autoSizeColumn(j);
                        }
                        
                    }
                    break;
                }
                case OTRO: {
                    for(int i = 0; i < subList.size() ; i++){
                        org.apache.poi.ss.usermodel.Row row = sheet.createRow(i + 1);
                        row.setHeight((short)400);
                        for(int j = 0 ; j < OTRO_HEADER.length; j++){
                            org.apache.poi.ss.usermodel.Cell cell = row.createCell(j);
                            cell.setCellStyle(createFontCell(workbook));
                            switch(j){
                                case 0:{
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                                    cell.setCellValue(subList.get(i).getNombreCompleto());
                                    break;
                                }
                                case 1:{
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC);
                                    cell.setCellValue(subList.get(i).getEdad());
                                    break;
                                }
                                case 2:{
                                    cell.setCellValue(subList.get(i).getFechaRegistro().toString());
                                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 3:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getCargo());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 4:{
                                    cell.setCellValue(subList.get(i).getOcupacion().getNivelEscolaridad());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 5:{
                                    cell.setCellValue((subList.get(i).getOcupacion().getPrograma() == null || subList.get(i).getOcupacion().getPrograma().compareTo("") == 0)?
                                            "No Aplica" : subList.get(i).getOcupacion().getPrograma());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 6:{
                                    cell.setCellValue(subList.get(i).getOcupacion().isCulminadoEstudio() ? "SI" : "NO");
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 7:{
                                    cell.setCellValue(subList.get(i).getOcupacion().isCulminadoEstudio() ? "No Aplica" :
                                            subList.get(i).getOcupacion().getUltimoGradoCursado()+"");
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    break;
                                }
                                case 8:{
                                    cell.setCellValue(subList.get(i).getPrueba().getRespuestas());
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                }
                            }
                            sheet.autoSizeColumn(j);
                        }
                    }
                    break;
                }
            }
        }
    }    
    
}
