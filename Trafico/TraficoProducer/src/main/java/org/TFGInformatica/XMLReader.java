package org.TFGInformatica;

import org.xml.sax.SAXException;
import org.w3c.dom.*;
import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class XMLReader {

    private String original_file;
    private Set<String> deleteTagsSet;

    public XMLReader (String path) {
        this.original_file = path;
        this.deleteTagsSet = new HashSet<>();
        this.deleteTagsSet.add("accesoAsociado");
        this.deleteTagsSet.add("intensidad");
        this.deleteTagsSet.add("ocupacion");
        this.deleteTagsSet.add("intensidadSat");
        this.deleteTagsSet.add("subarea");
    }

    public List<PuntoDeMedicion> readXML () {
        List<PuntoDeMedicion> listaDevolver = new LinkedList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(this.original_file));
            doc.getDocumentElement().normalize();

            //Ahora recorremos el documento creando puntos de medición y añadiéndolos a la lista
            NodeList list = doc.getElementsByTagName("pm");
            Node node;

            for (int i = 0; i < list.getLength(); i++) {
                node = list.item(i);
                PuntoDeMedicion pm = new PuntoDeMedicion();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs = node.getChildNodes();
                    Node child;

                    for (int j = 0; j < childs.getLength(); j++) {
                        child = childs.item(j);

                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            if (this.esNodoPM(child.getNodeName())) {
                                try {
                                    if (child.getNodeName().equals("idelem")) {
                                        pm.setIdelem(childs.item(j).getTextContent());
                                    }
                                    else if (child.getNodeName().equals("descripcion")) {
                                        pm.setDescripcion(childs.item(j+1).getTextContent());

                                    }
                                    else if (child.getNodeName().equals("carga")) {
                                        pm.setCarga(childs.item(j).getTextContent());

                                    }
                                    else if (child.getNodeName().equals("nivelServicio")) {
                                        pm.setNivelServicio(childs.item(j).getTextContent());
                                    }
                                    else if (child.getNodeName().equals("error")) {
                                        pm.setError(childs.item(j).getTextContent());
                                    }
                                    else if (child.getNodeName().equals("st_x")) {
                                        pm.setSt_x(childs.item(j).getTextContent());
                                    }
                                    else if (child.getNodeName().equals("st_y")) {
                                        pm.setSt_y(childs.item(j).getTextContent());
                                    }
                                    else {
                                        System.out.println("Ha surgido un error al crear la clase PuntoDeMedicion");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("El PuntoDeMedicion no ha podido ser completado. Pasando al siguiente...");
                                }
                            }
                        }
                        System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " creado exitosamente");
                        listaDevolver.add(pm);
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return listaDevolver;

    }

    private boolean esNodoPM (String nodeName) {
        if (!this.deleteTagsSet.contains(nodeName)) {
            return true;
        }
        else {
            return false;
        }
    }
}
