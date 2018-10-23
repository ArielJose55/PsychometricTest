/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prociencia.logic.sheetexcels;

import java.util.GregorianCalendar;
import prociencia.logic.core.entities.OcupacionEnum;
import prociencia.logic.core.entities.Persona;


public class CreatorPersonExcel {
    
    private final Persona persona;

    public CreatorPersonExcel(Persona persona) {
        this.persona = persona;
    }
    
    
    
    private org.apache.poi.hssf.usermodel.HSSFWorkbook selectorWorkbook(OcupacionEnum ocupacion) throws Exception{
        switch(ocupacion){
            case ESTUDIANTE:{
                return new org.apache.poi.hssf.usermodel.HSSFWorkbook(CreatorPersonExcel.class.getResourceAsStream("DataPersonStudent.xls"));
            }
            case EMPLEADO:{
                return new org.apache.poi.hssf.usermodel.HSSFWorkbook(CreatorPersonExcel.class.getResourceAsStream("DataPersonEmployee.xls"));
            }
            default:{
                return new org.apache.poi.hssf.usermodel.HSSFWorkbook(CreatorPersonExcel.class.getResourceAsStream("DataPersonOther.xls"));
            }
        }
    }
    
    public void startWriting(java.io.File file) throws Exception{
        switch(persona.getTipoOcupacion()){
            case ESTUDIANTE:{
                toWriteStudent(selectorWorkbook(persona.getTipoOcupacion()),file);
                break;
            }
            case EMPLEADO:{
                toWriteEmployee(selectorWorkbook(persona.getTipoOcupacion()), file);
                break;
            }
            case OTRO:{
                toWriteOther(selectorWorkbook(persona.getTipoOcupacion()), file);
                break;
            }
        }
    }
    
    private void toWriteStudent(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook,java.io.File parent) throws Exception{
        org.apache.poi.hssf.usermodel.HSSFSheet sheet = workbook.getSheetAt(0);
        org.apache.poi.ss.usermodel.Cell cell = sheet.getRow(4).getCell(3);
        cell.setCellValue(persona.getNombreCompleto());
        cell = sheet.getRow(6).getCell(3);
        cell.setCellValue(persona.getEdad());
        cell = sheet.getRow(8).getCell(3);
        cell.setCellValue(persona.getStringDeOcupacion(persona.getTipoOcupacion()));
        cell = sheet.getRow(10).getCell(3);
        cell.setCellValue(persona.getFechaRegistro().toString());
        cell = sheet.getRow(12).getCell(3);
        cell.setCellValue(persona.getOcupacion().getInstitucion());
        cell = sheet.getRow(14).getCell(3);
        cell.setCellValue(persona.getOcupacion().getGradoCursado());
        cell = sheet.getRow(3).getCell(9);
        cell.setCellValue(persona.getPrueba().getRespuestas());
        java.io.FileOutputStream outFile =new java.io.FileOutputStream(new java.io.File(parent, persona.getNombreCompleto()+".xls"));
        workbook.write(outFile);
        outFile.close();
    }
    
    private void toWriteEmployee(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook,java.io.File parent) throws Exception{
        org.apache.poi.hssf.usermodel.HSSFSheet sheet = workbook.getSheetAt(0);
        org.apache.poi.hssf.usermodel.HSSFCellStyle style = sheet.getRow(3).getCell(3).getCellStyle().getParentStyle();
        
        org.apache.poi.ss.usermodel.Cell cell = sheet.getRow(4).getCell(3);
        cell.setCellValue(persona.getNombreCompleto());
        cell = sheet.getRow(6).getCell(3);
        cell.setCellValue(persona.getEdad());
        cell = sheet.getRow(8).getCell(3);
        cell.setCellValue(persona.getStringDeOcupacion(persona.getTipoOcupacion()));
        cell = sheet.getRow(10).getCell(3);
        cell.setCellValue(persona.getFechaRegistro().toString());
        cell = sheet.getRow(12).getCell(3);
        cell.setCellValue(persona.getOcupacion().getInstitucion());
        cell = sheet.getRow(14).getCell(3);
        cell.setCellValue(persona.getOcupacion().getCargo());
        cell = sheet.getRow(16).getCell(3);
        cell.setCellValue(persona.getOcupacion().getNivelEscolaridad());
        checkNullProperty(persona.getOcupacion().getPrograma(), sheet.getRow(18).getCell(1), sheet.getRow(18).getCell(3), style, workbook);
        checkNullProperty(persona.getOcupacion().isCulminadoEstudio(), sheet.getRow(20).getCell(1), sheet.getRow(20).getCell(3), style, workbook);
        checkNullProperty(persona.getOcupacion().getUltimoGradoCursado(), sheet.getRow(20).getCell(4), sheet.getRow(20).getCell(6), style, workbook);
        cell = sheet.getRow(3).getCell(9);
        cell.setCellValue(persona.getPrueba().getRespuestas());
        java.io.FileOutputStream outFile =new java.io.FileOutputStream(new java.io.File(parent, persona.getNombreCompleto()+".xls"));
        workbook.write(outFile);
        outFile.close();        
    }
    
    private void toWriteOther(org.apache.poi.hssf.usermodel.HSSFWorkbook workbook,java.io.File parent) throws Exception{
        org.apache.poi.hssf.usermodel.HSSFSheet sheet = workbook.getSheetAt(0);
        org.apache.poi.hssf.usermodel.HSSFCellStyle style = sheet.getRow(5).getCell(3).getCellStyle().getParentStyle();
        
        org.apache.poi.ss.usermodel.Cell cell = sheet.getRow(4).getCell(3);
        cell.setCellValue(persona.getNombreCompleto());
        cell = sheet.getRow(6).getCell(3);
        cell.setCellValue(persona.getEdad());
        cell = sheet.getRow(8).getCell(3);
        cell.setCellValue(persona.getStringDeOcupacion(persona.getTipoOcupacion()));
        cell = sheet.getRow(10).getCell(3);
        cell.setCellValue(persona.getFechaRegistro().toString());
        cell = sheet.getRow(12).getCell(3);
        cell.setCellValue(persona.getOcupacion().getCargo());
        cell = sheet.getRow(14).getCell(3);
        cell.setCellValue(persona.getOcupacion().getNivelEscolaridad());
        checkNullProperty(persona.getOcupacion().getPrograma(), sheet.getRow(16).getCell(1), sheet.getRow(16).getCell(3), style, workbook);
        checkNullProperty(persona.getOcupacion().isCulminadoEstudio(), sheet.getRow(18).getCell(1), sheet.getRow(18).getCell(3), style, workbook);
        checkNullProperty(persona.getOcupacion().getUltimoGradoCursado(), sheet.getRow(18).getCell(4), sheet.getRow(18).getCell(6), style, workbook);
        cell = sheet.getRow(3).getCell(9);
        cell.setCellValue(persona.getPrueba().getRespuestas());
        java.io.FileOutputStream outFile =new java.io.FileOutputStream(new java.io.File(parent, persona.getNombreCompleto()+".xls"));
        workbook.write(outFile);
        outFile.close();  
    }
    
    private java.util.Date createDateOfRegister(java.sql.Date date){
        String[] datas = date.toString().split("-");
        java.util.GregorianCalendar calendar = new GregorianCalendar(
                Integer.parseInt(datas[0]), Integer.parseInt(datas[1]), Integer.parseInt(datas[2])
        );
        return calendar.getTime();
    }
    
    private void checkNullProperty(Boolean value, org.apache.poi.ss.usermodel.Cell cellLabel,org.apache.poi.ss.usermodel.Cell cellValue, org.apache.poi.hssf.usermodel.HSSFCellStyle style, org.apache.poi.hssf.usermodel.HSSFWorkbook workbook){
        if(value == null){
            cellLabel.setCellValue("");
            cellValue.setCellStyle(style);
        }else{
            cellValue.setCellValue(value ? "Si" : "No");
        }
    }
    
    private void checkNullProperty(String value, org.apache.poi.ss.usermodel.Cell cellLabel,org.apache.poi.ss.usermodel.Cell cellValue, org.apache.poi.hssf.usermodel.HSSFCellStyle style, org.apache.poi.hssf.usermodel.HSSFWorkbook workbook){
        if(value == null){
            cellLabel.setCellValue("");
            cellValue.setCellStyle(style);
        }else{
            cellValue.setCellValue(value);
        }
    }
    
    private void checkNullProperty(Integer value, org.apache.poi.ss.usermodel.Cell cellLabel,org.apache.poi.ss.usermodel.Cell cellValue, org.apache.poi.hssf.usermodel.HSSFCellStyle style, org.apache.poi.hssf.usermodel.HSSFWorkbook workbook){
        if(value == null){
            cellLabel.setCellValue("");
            cellValue.setCellStyle(style);
        }else{
            cellValue.setCellValue(value);
        }
    }
}
