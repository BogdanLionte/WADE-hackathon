package hack2;

import com.hp.hpl.jena.rdf.model.*;

import java.util.ArrayList;
import java.util.List;

public class RDFModel {

    List<University> universityList = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();
    List<StudyProgramme> studyProgrammes = new ArrayList<>();
    List<Programme> programmes = new ArrayList<>();
    List<StudyDomain> studyDomains = new ArrayList<>();
    List<FundamentalDomain> fundamentalDomains = new ArrayList<>();
    List<ScienceBranch> scienceBranches = new ArrayList<>();


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
            if (id == faculty.getRmuId()) {
                return faculty;
            }
        }

        return null;
    }

    StudyProgramme getStudyProgrammeById(Integer id) {
        for(StudyProgramme studyProgramme : studyProgrammes) {
            if (id == studyProgramme.getRmuId()) {
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

    private Model model;

    public void createModel() {
        model = ModelFactory.createDefaultModel();
        String ns = "http://www.example.org#";
        String nsRDFS = "http://www.w3.org/2000/01/rdf-schema#";

        addStatement(ns+"Faculty", nsRDFS+"belongsTo", ns+"University");


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

}
