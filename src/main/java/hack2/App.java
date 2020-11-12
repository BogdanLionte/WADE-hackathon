package hack2;


/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        RDFModel rdfModel = new RDFModel();
        rdfModel.createModel();
        rdfModel.writeModel();
    }

}
