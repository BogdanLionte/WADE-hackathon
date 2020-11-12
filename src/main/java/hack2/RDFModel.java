package hack2;

import com.hp.hpl.jena.rdf.model.*;
import org.apache.jena.query.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static hack2.ExcelReading.readFaculties;
import static hack2.ExcelReading.readUniversities;

public class RDFModel {

    List<University> universityList = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();
    List<StudyProgramme> studyProgrammes = new ArrayList<>();
    List<Programme> programmes = new ArrayList<>();
    List<StudyDomain> studyDomains = new ArrayList<>();
    List<FundamentalDomain> fundamentalDomains = new ArrayList<>();
    List<ScienceBranch> scienceBranches = new ArrayList<>();

    public RDFModel() {
        InputStream inp = null;
        try {
            inp = new FileInputStream("src/main/java/hack2/data.xlsx");
            Workbook wb = WorkbookFactory.create(inp);

            universityList = readUniversities(wb);
            faculties = readFaculties(wb);
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

    private Model model;

    public void createModel() {
        model = ModelFactory.createDefaultModel();
        String ns = "http://www.example.org/";
        String facultyNS = "http://www.example.org/Faculties/";
        String universityNS = "http://www.example.org/Universities/";
        String cityNS = "http://www.example.org/Cities/";
        String universityTypeNS = "http://www.example.org/UniversityType/";
        String studyDomainNS = "http://www.example.org/StudyDomain/";
        String specializationNS = "http://www.example.org/Specialization/";

        for (Faculty faculty : faculties) {
            addStatement(facultyNS+faculty.getName(), ns+"belongsTo", universityNS+getUniversityById(faculty.getUniversityId()).getName());
            addStatement(facultyNS+faculty.getName(), ns+"isInCity", cityNS+getUniversityById(faculty.getUniversityId()).getCity());
        }

        for (University university : universityList) {
            addStatement(facultyNS+university.getName(), ns+"type", universityTypeNS+university.getType());
        }

        for (StudyDomain studyDomain : studyDomains) {
            addStatement(studyDomainNS+studyDomain.getName(), "hasSpecialization", specializationNS+getScienceBranchById(studyDomain.getScienceBranchId()).getName());
        }

//        StringBuilder queryStr = new StringBuilder();
//        queryStr.append("SELECT ?university ");
//        queryStr.append("WHERE ");
//        queryStr.append("{ ");
//        queryStr.append("<http://www.example.org/Universities/> ?p ?o ");
//        queryStr.append("} ");
//
//        Query query = QueryFactory.create(queryStr.toString());
//        QueryExecution qe = QueryExecutionFactory.create(query);
//        ResultSet results = qe.execSelect();
//        ResultSetFormatter.out(System.out, results, query);
//        qe.close();

    }

    public void addStatement(String s, String p, String o) {
        Resource subject = model.createResource(s);
        Property predicate = model.createProperty(p);
        RDFNode object = model.createResource(o);
        Statement stmt = model.createStatement(subject, predicate, object);
        model.add(stmt);
    }

    public void writeModel(){
        model.write(System.out, "RDF/XML");
    }

    University getUniversityById(Integer id) {
        for(University university : universityList) {
            if (id == university.getRmuID()) {
                return university;
            }
        }

        return null;
    }

    Faculty getFacultyById(Integer id) {
        for(Faculty faculty : faculties) {
            if (id == faculty.getRmuID()) {
                return faculty;
            }
        }

        return null;
    }

    StudyProgramme getStudyProgrammeById(Integer id) {
        for(StudyProgramme studyProgramme : studyProgrammes) {
            if (id == studyProgramme.getRmuID()) {
                return studyProgramme;
            }
        }

        return null;
    }


    Programme getProgrammeById(Integer id) {
        for(Programme programme : programmes) {
            if (id == programme.getRmuId()) {
                return programme;
            }
        }

        return null;
    }

    StudyDomain getStudyDomainById(Integer id) {
        for(StudyDomain studyDomain : studyDomains) {
            if (id.equals(studyDomain.getId())) {
                return studyDomain;
            }
        }

        return null;
    }

    ScienceBranch getScienceBranchById(Integer id) {
        for(ScienceBranch scienceBranch : scienceBranches) {
            if (id.equals(scienceBranch.getId())) {
                return scienceBranch;
            }
        }

        return null;
    }

    FundamentalDomain getFundamentalDomainById(Integer id) {
        for(FundamentalDomain fundamentalDomain : fundamentalDomains) {
            if (id.equals(fundamentalDomain.getId())) {
                return fundamentalDomain;
            }
        }

        return null;
    }

}
