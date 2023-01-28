package org.TFGInformatica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class TraficoProducer {

    public static void main(String[] args) {

        //1. Ejecutar el script pullRepo.sh que hará el git pull al repositorio remoto
        try {
            ProcessBuilder pb = new ProcessBuilder("/home/daniel/Escritorio/TFGInformatica/pullRepo.sh");
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("Script pullRepo.sh: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Leer el archivo realizando las transformaciones necesarias
        System.out.println("Comienza la lectura del archivo XML");
        XMLReader xmlReader = new XMLReader("/home/daniel/Escritorio/TFGInformatica/Trafico/TraficoProducer/data/ficheroTrafico.xml");
        List<PuntoDeMedicion> listaPMs = xmlReader.readXML();

        System.out.println("La longitud de la lista es: " + listaPMs.size());

        //3. Crear el productor de Kafka y enviar a través del topic


    }
}