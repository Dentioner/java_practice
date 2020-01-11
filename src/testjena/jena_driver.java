package testjena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class jena_driver
{
    public static void main(String args[])
    {
        Model model = ModelFactory.createDefaultModel();
        model.read("D:\\coding\\java_practice\\src\\testjena\\xlore.baidu.infobox.ttl");
        //model.write(System.out, "N-TRIPLE");
        model.write(System.out, "RDF/XML-ABBREV");
    }
}
