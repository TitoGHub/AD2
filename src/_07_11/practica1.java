package _07_11;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class practica1 {
    public static void main(String[] args) {
        datosPagina();
        try {
        File fl = new File("C:\\Users\\DAM2\\IdeaProjects\\AD\\src\\_07_11\\localidad_45161.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fl);


                    String autor = doc.getElementsByTagName("productor").item(0).getTextContent();
                    System.out.println("Autor: " + autor);

                    String nombre = doc.getElementsByTagName("nombre").item(0).getTextContent();
                    System.out.println("Pueblo: "  + nombre);

                    String provincia = doc.getElementsByTagName("provincia").item(0).getTextContent();
                    System.out.println("Provincia: " + provincia);

            NodeList nList = doc.getElementsByTagName("dia");
            for(int i = 0; i< nList.getLength(); i++) {
                String dia = nList.item(i).getAttributes().item(0).getTextContent();
                    if(dia.equalsIgnoreCase("2022-11-08")){
                        System.out.println("Fecha: " + dia);
                        String tMax = doc.getElementsByTagName("maxima").item(0).getTextContent();
                        System.out.println(tMax);
                        String tMin = doc.getElementsByTagName("minima").item(0).getTextContent();
                        System.out.println(tMin);
                    }

            }

        } catch (ParserConfigurationException e) {
            System.out.println("1");
            //throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("2");
            //throw new RuntimeException(e);
        } catch (SAXException e) {
            System.out.println("3");
            //throw new RuntimeException(e);
        }

    }


    public static void datosPagina(){
        try {
            // Constructor
            URL direccion = new URL("https://www.aemet.es/es/eltiempo/prediccion/municipios/sesena-id45161");
            // Divide las diferentes partes de una URL
            System.out.println("El protocolo utilizado es: " + direccion.getProtocol());
            System.out.println("El host es: " + direccion.getHost());
            System.out.println("El puerto es: " + direccion.getPort());
            System.out.println("El fichero es: " + direccion.getFile());
            System.out.println("--------------------------------------");
        } catch (MalformedURLException e) {
            System.out.println("Error en la construccion de la URL");
        }
    }

}
