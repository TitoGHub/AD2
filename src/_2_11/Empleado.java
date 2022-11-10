package _2_11;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Empleado {
    private String codigo;
    private String nombre;
    private Double salario;
    private int edad;

    public Empleado(String codigo, String nombre, Double salario, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }




    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(codigo, empleado.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public static void escribirFichero(File fl, ArrayList<Empleado> empleados) {
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element empl = doc.createElement("empleados");
            doc.appendChild(empl);
        for (int i = 0; i < empleados.size(); i++) {

            Element empleado = doc.createElement("empleado");
            empl.appendChild(empleado);

            Attr codEmpl = doc.createAttribute("id");
            codEmpl.setValue(empleados.get(i).getCodigo());
            empleado.setAttributeNode(codEmpl);

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(empleados.get(i).getNombre()));
            empleado.appendChild(nombre);

            Element salario = doc.createElement("salario");
            salario.appendChild(doc.createTextNode(String.valueOf(empleados.get(i).getSalario())));
            empleado.appendChild(salario);

            Element edad = doc.createElement("edad");
            edad.appendChild(doc.createTextNode(String.valueOf(empleados.get(i).getEdad())));
            empleado.appendChild(edad);



        }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fl);

            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }

    public static void salarioMedio(File fl) {
        try {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fl);

            NodeList nList = doc.getElementsByTagName("empleado");
            System.out.println("Número de empleados: " + nList.getLength());

            double media = 0.0;
            double salario = 0.0;
            for(int i = 0; i< nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    salario = Double.parseDouble(eElement.getElementsByTagName("salario").item(0).getTextContent()) + salario;

                }
                }
            media = salario / nList.getLength();
            System.out.println("El salario total es de: " + salario);
            System.out.println("La media de los salarios entre los " + nList.getLength() + " empleados es de " + media);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }


}
