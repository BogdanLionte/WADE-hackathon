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

public class ExcelReading {

    public static List<University> readUniversities(Workbook wb) {
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

    public static List<StudyProgramme> readStudyProgrammes(Workbook wb) {
        Sheet sheet = wb.getSheetAt(2);
        List<StudyProgramme> result = new ArrayList<>();
        //skip the first row as that is the column names
        for(int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row != null) {
                StudyProgramme studyProgramme = new StudyProgramme();
                studyProgramme.setRmuID(getNumericCellValue(row.getCell(0)));
                studyProgramme.setUniversity(getStringCellValue(row.getCell(1)));
                studyProgramme.setUniversityId(getNumericCellValue(row.getCell(2)));
                studyProgramme.setFaculty(getStringCellValue(row.getCell(3)));
                studyProgramme.setFacultyId(getNumericCellValue(row.getCell(4)));
                studyProgramme.setCountry(getStringCellValue(row.getCell(5)));
                studyProgramme.setCityId(getNumericCellValue(row.getCell(6)));
                studyProgramme.setCity(getStringCellValue(row.getCell(7)));
                studyProgramme.setCityId(getNumericCellValue(row.getCell(8)));
                studyProgramme.setDomain(getStringCellValue(row.getCell(9)));
                studyProgramme.setDomainId(getNumericCellValue(row.getCell(10)));
                studyProgramme.setSpecialty(getStringCellValue(row.getCell(11)));
                studyProgramme.setSpecialtyId(getNumericCellValue(row.getCell(12)));
                studyProgramme.setAccreditationType(getStringCellValue(row.getCell(13)));
                studyProgramme.setAccreditationTypeId(getNumericCellValue(row.getCell(14)));
                studyProgramme.setLearningForm(getStringCellValue(row.getCell(15)));
                studyProgramme.setLearningFormId(getNumericCellValue(row.getCell(16)));
                studyProgramme.setStudyCycle(getStringCellValue(row.getCell(17)));
                studyProgramme.setStudyCycleId(getNumericCellValue(row.getCell(18)));
                studyProgramme.setLanguage(getStringCellValue(row.getCell(19)));
                studyProgramme.setLanguageId(getNumericCellValue(row.getCell(20)));
                studyProgramme.setStudyDuration(getNumericCellValue(row.getCell(21)));
                studyProgramme.setYear(getNumericCellValue(row.getCell(22)));
                result.add(studyProgramme);
            }
        }
        return result;
    }

    private static int getNumericCellValue(Cell cell) {
        if(cell == null || cell.getCellType() != CellType.NUMERIC){
            return 0;
        }
        return (int)cell.getNumericCellValue();
    }

    private static String getStringCellValue(Cell cell) {
        if(cell == null || cell.getCellType() != CellType.STRING) {
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
            readStudyProgrammes(wb);
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
