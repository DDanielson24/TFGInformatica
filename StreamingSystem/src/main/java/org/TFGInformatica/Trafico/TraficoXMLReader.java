package org.TFGInformatica.Trafico;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.TFGInformatica.TraficoPuntoDeMedicion;

public class TraficoXMLReader {

    private String original_file;
    private Set<String> deleteTagsSet;
    private PuntosCSVReader puntosCSVReader;

    public TraficoXMLReader (String pathXML, String pathCSV) {
        this.original_file = pathXML;
        this.puntosCSVReader = new PuntosCSVReader(pathCSV);
        this.deleteTagsSet = new HashSet<>();
        this.deleteTagsSet.add("accesoAsociado");
        this.deleteTagsSet.add("ocupacion");
        this.deleteTagsSet.add("intensidadSat");
        this.deleteTagsSet.add("subarea");
    }

    public List<TraficoPuntoDeMedicion> readXML () {
        List<TraficoPuntoDeMedicion> listaDevolver = new LinkedList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(this.original_file));
            doc.getDocumentElement().normalize();

            //Recogemos la fecha de actualización del documento para los PM
            String fecha_actualizacion = doc.getElementsByTagName("fecha_hora").item(0).getTextContent();
            fecha_actualizacion = fecha_actualizacion.substring(0, 17) + "00";

            //Ahora recorremos el documento creando puntos de medición y añadiéndolos a la lista
            NodeList list = doc.getElementsByTagName("pm");
            Node node;

            for (int i = 0; i < list.getLength(); i++) {
                node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs = node.getChildNodes();
                    Node child;
                    TraficoPuntoDeMedicion pm = new TraficoPuntoDeMedicion();
                    boolean error = false;

                    for (int j = 0; j < childs.getLength(); j++) {
                        child = childs.item(j);

                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            if (this.esNodoPM(child.getNodeName())) {
                                try {
                                    if (child.getNodeName().equals("idelem")) {
                                        pm.setIdelem(Integer.parseInt(childs.item(j).getTextContent()));
                                    }
                                    else if (child.getNodeName().equals("descripcion")) {
                                        pm.setDescripcion(childs.item(j).getTextContent());
                                    }
                                    else if(child.getNodeName().equals("intensidad")) {
                                        pm.setIntensidad(Integer.parseInt(childs.item(j).getTextContent()));
                                    }
                                    else if (child.getNodeName().equals("carga")) {
                                        if (Integer.parseInt(childs.item(j).getTextContent()) < 0 || Integer.parseInt(childs.item(j).getTextContent()) > 100) {
                                            throw new RuntimeException("El PuntoDeMedicion presenta un error");
                                        }
                                        pm.setCarga(Integer.parseInt(childs.item(j).getTextContent()));
                                    }
                                    else if (child.getNodeName().equals("nivelServicio")) {
                                        if (Integer.parseInt(childs.item(j).getTextContent()) < 0 || Integer.parseInt(childs.item(j).getTextContent()) > 4) {
                                            throw new RuntimeException("El PuntoDeMedicion presenta un error");
                                        }
                                        pm.setNivelServicio(Integer.parseInt(childs.item(j).getTextContent()));
                                    }
                                    else if (child.getNodeName().equals("error")) {
                                        if (!childs.item(j).getTextContent().equals("N")) {
                                            throw new RuntimeException("El PuntoDeMedicion presenta un error");
                                        }
                                    }

                                    //Para todos aquellos puntos de medición que no tienen descripción en el XML
                                    if (pm.getDescripcion() == null) {
                                        pm.setDescripcion("");
                                    }
                                } catch (RuntimeException e) {
                                    error = true;
                                    break;
                                }
                            }
                        }
                    }

                    //Comprobamos si no ha surgido un error en la creación del PM. Si no, añadimos a la lista
                    if (!error) {
                        pm.setFechaActualizacion(fecha_actualizacion);

                        //Añadimos el distrito en el caso de haberlo encontrado en el fichero. Se devuelve un 0 por defecto en caso de no encontrarlo
                        Integer distrito = this.puntosCSVReader.buscarDistrito(pm.getIdelem());
                        if (!distrito.equals(0)) {
                            pm.setDistrito(distrito);
                        }

                        System.out.println("PuntoDeMedicion: " + pm.getIdelem() + " creado exitosamente");
                        listaDevolver.add(pm);
                    }
                    else {
                        System.out.println("Ha surgido un error al crear el PuntoDeMedicion");
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
