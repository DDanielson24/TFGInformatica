package org.TFGInformatica.Contaminacion;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.TFGInformatica.ContaminacionEstacionDeMedicion;

public class ContaminacionXMLReader {

    private String original_file;
    private Map<Integer, ContaminacionEstacionDeMedicion> estacionesYaCreadas;

    public ContaminacionXMLReader (String pathXML) {
        this.original_file = pathXML;
        this.estacionesYaCreadas = new HashMap<>();
    }

    public List<ContaminacionEstacionDeMedicion> readXML () {
        List<ContaminacionEstacionDeMedicion> listaDevolver = new LinkedList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(this.original_file));
            doc.getDocumentElement().normalize();

            //Ahora recorremos el documento creando puntos de medición y añadiéndolos a la lista
            NodeList list = doc.getElementsByTagName("Dato_Horario");
            Node node;

            for (int i = 0; i < list.getLength(); i++) {
                node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs = node.getChildNodes();
                    Node child;
                    ContaminacionEstacionDeMedicion em = null;
                    Integer magnitudMedida = 0;
                    Float valorMagnitudMedia = 0.0f;
                    boolean error = false;

                    //Para crear la fecha de actualización
                    String año = "";
                    String mes = "";
                    String dia = "";
                    String hora = "";

                    for (int j = 0; j < childs.getLength(); j++) {
                        child = childs.item(j);

                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            try {

                                //Como las estaciones aparecen repetidas en el XML con diferentes magnitudes, tenemos que comprobar si la
                                // estación había sido creada ya con anterioridad e introducida en la lista
                                if (child.getNodeName().equals("estacion")) {
                                    Integer idelem = Integer.parseInt(childs.item(j).getTextContent());
                                    if (this.estacionesYaCreadas.containsKey(idelem)) {
                                        em = this.estacionesYaCreadas.get(idelem);
                                    } else {
                                        em = new ContaminacionEstacionDeMedicion();
                                        em.setIdelem(idelem);
                                    }
                                }

                                //Rellenamos el resto de campos de la estación
                                if (child.getNodeName().equals("magnitud")) {
                                    magnitudMedida = Integer.parseInt(childs.item(j).getTextContent());
                                }
                                if (child.getNodeName().equals("ano")) {
                                    año = childs.item(j).getTextContent();
                                }
                                if (child.getNodeName().equals("mes")) {
                                    mes = childs.item(j).getTextContent();
                                }
                                if (child.getNodeName().equals("dia")) {
                                    dia = childs.item(j).getTextContent();
                                }
                                if (child.getNodeName().startsWith("H")) {
                                    if (childs.item(j+2).getTextContent().equals("V")) {
                                        valorMagnitudMedia = Float.parseFloat(childs.item(j).getTextContent());
                                    }
                                }
                                if (child.getNodeName().startsWith("V")) {
                                    if (childs.item(j).getTextContent().equals("V")) {
                                        hora = childs.item(j).getNodeName().substring(1);
                                    }
                                }
                            } catch (RuntimeException e) {
                                error = true;
                                break;
                            }
                        }
                    }

                    //Comprobamos si no ha surgido un error en la creación de la EM. Si no, añadimos a la lista
                    if (!error) {
                        String fecha_actualizacion = año + "/" + mes + "/" + dia + " " + hora + ":00:00";
                        em.setFechaActualizacion(fecha_actualizacion);

                        if (magnitudMedida == 7) {
                            em.setNo(valorMagnitudMedia);
                        }
                        else if (magnitudMedida == 8) {
                            em.setNo2(valorMagnitudMedia);
                        }
                        else if (magnitudMedida == 9) {
                            em.setPm25(valorMagnitudMedia);
                        }
                        else if (magnitudMedida == 10) {
                            em.setPm10(valorMagnitudMedia);
                        }
                        else if (magnitudMedida == 12) {
                            em.setNox(valorMagnitudMedia);
                        }
                        else if (magnitudMedida == 14) {
                            em.setO3(valorMagnitudMedia);
                        }

                        if (!this.estacionesYaCreadas.containsKey(em.getIdelem())) {
                            this.estacionesYaCreadas.put(em.getIdelem(), em);
                            System.out.println("EstacionDeMedicion: " + em.getIdelem() + " creado exitosamente");
                        }
                    }
                    else {
                        System.out.println("Ha surgido un error al crear la EstacionDeMedicion");
                    }
                }
            }

            //Recorremos el conjunto de estaciones del HashMap para añadirlas a la lista y devolverlas
            Iterator<ContaminacionEstacionDeMedicion> iterator = this.estacionesYaCreadas.values().iterator();
            while (iterator.hasNext()) {
                listaDevolver.add(iterator.next());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return listaDevolver;
    }
}