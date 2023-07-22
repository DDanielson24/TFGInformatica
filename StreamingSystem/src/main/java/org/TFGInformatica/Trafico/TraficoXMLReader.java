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

    public TraficoXMLReader (String path) {
        this.original_file = path;
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
                                        pm.setCarga(Integer.parseInt(childs.item(j).getTextContent()));
                                    }
                                    else if (child.getNodeName().equals("nivelServicio")) {
                                        pm.setNivelServicio(Integer.parseInt(childs.item(j).getTextContent()));
                                    }
                                    else if (child.getNodeName().equals("error")) {
                                        if (!childs.item(j).getTextContent().equals("N")) {
                                            throw new RuntimeException("El PuntoDeMedicion presenta un error");
                                        }
                                    }
                                    else if (child.getNodeName().equals("st_x")) {
                                        String st_x = childs.item(j).getTextContent();
                                        String st_x_1 = st_x.substring(0, st_x.indexOf(','));
                                        String st_x_2 = st_x.substring(st_x.indexOf(',') + 1, st_x.length());
                                        String st_x_final = st_x_1 + "." + st_x_2;
                                        pm.setStX(Float.parseFloat(st_x_final));
                                    }
                                    else if (child.getNodeName().equals("st_y")) {
                                        String st_y = childs.item(j).getTextContent();
                                        String st_y_1 = st_y.substring(0, st_y.indexOf(','));
                                        String st_y_2 = st_y.substring(st_y.indexOf(',') + 1, st_y.length());
                                        String st_y_final = st_y_1 + "." + st_y_2;
                                        pm.setStY(Float.parseFloat(st_y_final));
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
