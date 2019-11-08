package test_dom4j;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.dom4j.DocumentHelper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class d4jdriver
{
    static String path = "D:/coding/java_practice/src\\test_dom4j\\test1.xml";


    public static void main(String[] args)
    {
        //readall();
        //query();
        //createxml();
        modify();
    }



    public static void readall()
    {
        try {
            File inputFile = new File(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );

            System.out.println("Root element :" + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Node> nodes = document.selectNodes("/class/student" );
            System.out.println("----------------------------");

            for (Node node : nodes) {
                System.out.println("\nCurrent Element :"
                        + node.getName());
                System.out.println("Student roll no : "
                        + node.valueOf("@rollno") );
                System.out.println("First Name : "
                        + node.selectSingleNode("firstname").getText());
                System.out.println("Last Name : "
                        + node.selectSingleNode("lastname").getText());
                System.out.println("First Name : "
                        + node.selectSingleNode("nickname").getText());
                System.out.println("Marks : "
                        + node.selectSingleNode("marks").getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void query()
    {
        try {
            File inputFile = new File(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );

            System.out.println("Root element :" + document.getRootElement().getName());

            Element classElement = document.getRootElement();

            List<Node> nodes = document.selectNodes("/class/student[@rollno = '493']" );
            System.out.println("----------------------------");

            for (Node node : nodes) {
                System.out.println("\nCurrent Element :"
                        + node.getName());
                System.out.println("Student roll no : "
                        + node.valueOf("@rollno") );
                System.out.println("First Name : "
                        + node.selectSingleNode("firstname").getText());
                System.out.println("Last Name : "
                        + node.selectSingleNode("lastname").getText());
                System.out.println("First Name : "
                        + node.selectSingleNode("nickname").getText());
                System.out.println("Marks : "
                        + node.selectSingleNode("marks").getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void createxml()
    {
        try {
            Document document = DocumentHelper.createDocument();
            /*Element root = document.addElement( "cars" );
            Element supercarElement = root.addElement("supercars")
                    .addAttribute("company", "Ferrai");

           supercarElement.addElement("carname")
                    .addAttribute("type", "Ferrari 101")
                    .addText("Ferrari 101");

            supercarElement.addElement("carname")
                    .addAttribute("type", "sports")
                    .addText("Ferrari 202");
*/
            // Pretty print the document to System.out
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter( System.out, format );
            writer.write( document );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modify()
    {
        try {
            File inputFile = new File(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read( inputFile );

            Element classElement = document.getRootElement();

            List<Node> nodes = document.selectNodes("/class/student[@rollno = '493']" );

            for (Node node : nodes) {
                Element element = (Element)node;
                Iterator<Element> iterator = element.elementIterator("marks");

                while(iterator.hasNext()) {
                    Element marksElement = (Element)iterator.next();
                    marksElement.setText(null);
                }
            }

            // Pretty print the document to System.out
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer;
            writer = new XMLWriter( System.out, format );
            writer.write( document );
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


