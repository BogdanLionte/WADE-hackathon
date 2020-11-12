package hack2;/*
 * Dependencies: Apache POI Library from http://poi.apache.org/
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Munawwar
 */
public class ExcelReading {

    public static void echoAsCSV(Sheet sheet) {
        Row row = null;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            if(row != null) {
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    System.out.print("\"" + row.getCell(j) + "\";");
                }
            }
            System.out.println();
        }
    }

    private static List<University> readUniversities(Workbook wb) {
        Sheet sheet = wb.getSheetAt(0);
        List<University> result = new ArrayList<>();
        for(int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row != null) {
                University uni = new University();
                uni.setRmuID((int)row.getCell(0).getNumericCellValue());
                uni.setName(row.getCell(1).getStringCellValue());
                uni.setCode(row.getCell(2).getStringCellValue());
                uni.setCounty(row.getCell(3).getStringCellValue());
                uni.setCountyId((int)row.getCell(4).getNumericCellValue());
                uni.setCity(row.getCell(5).getStringCellValue());
                uni.setCityId((int)row.getCell(6).getNumericCellValue());
                uni.setYear((int)row.getCell(7).getNumericCellValue());
                uni.setWebAddress(row.getCell(8).getStringCellValue());
                result.add(uni);
            }
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStream inp = null;
        try {
            inp = new FileInputStream("src/main/java/hack2/data.xlsx");
            Workbook wb = WorkbookFactory.create(inp);

            readUniversities(wb);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelReading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}