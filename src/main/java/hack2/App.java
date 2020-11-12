package hack2;


/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        RDFModel rdfModel = new RDFModel();
        rdfModel.createModel();
        rdfModel.writeModel();
    }

}
