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

import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Munawwar
 */
public class ExcelReading {

    private static List<University> readUniversities(Workbook wb) {
        Sheet sheet = wb.getSheetAt(0);
        List<University> result = new ArrayList<>();
        //skip the first row as that is the column names
        for(int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row != null) {
                University uni = new University();
                uni.setRmuID(getNumericCellValue(row.getCell(0)));
                uni.setName(getStringCellValue(row.getCell(1)));
                uni.setCode(getStringCellValue(row.getCell(2)));
                uni.setCounty(getStringCellValue(row.getCell(3)));
                uni.setCountyId(getNumericCellValue(row.getCell(4)));
                uni.setCity(getStringCellValue(row.getCell(5)));
                uni.setCityId(getNumericCellValue(row.getCell(6)));
                uni.setYear(getNumericCellValue(row.getCell(7)));
                uni.setWebAddress(getStringCellValue(row.getCell(8)));
                result.add(uni);
            }
        }
        return result;
    }

    public static List<Faculty> readFaculties(Workbook wb) {
        Sheet sheet = wb.getSheetAt(1);
        List<Faculty> result = new ArrayList<>();
        //skip the first row as that is the column names
        for(int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row != null) {
                Faculty faculty = new Faculty();
                faculty.setRmuID(getNumericCellValue(row.getCell(0)));
                faculty.setName(getStringCellValue(row.getCell(1)));
                faculty.setUniversity(getStringCellValue(row.getCell(2)));
                faculty.setUniversityId(getNumericCellValue(row.getCell(3)));
                faculty.setIsDoctoralSchool(getNumericCellValue(row.getCell(4)));
                faculty.setYear(getNumericCellValue(row.getCell(5)));
                result.add(faculty);
            }
        }
        return result;
    }

    private static int getNumericCellValue(Cell cell) {
        if(cell == null){
            return 0;
        }
        return (int)cell.getNumericCellValue();
    }

    private static String getStringCellValue(Cell cell) {
        if(cell == null) {
            return "";
        }
        return cell.getStringCellValue();
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
            readFaculties(wb);
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