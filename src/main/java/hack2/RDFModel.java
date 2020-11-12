package hack2;

import com.hp.hpl.jena.rdf.model.*;

public class RDFModel {

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
