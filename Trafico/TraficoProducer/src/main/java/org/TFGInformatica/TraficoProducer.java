package org.TFGInformatica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TraficoProducer {

    public static void main(String[] args) {

        //1. Hacer git pull al repositorio remoto que contiene el último archivo a procesar
        try {
            ProcessBuilder pb = new ProcessBuilder("/home/daniel/Escritorio/TFGInformatica/pullRepo.sh");
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        //2. Leer el archivo realizando las transformaciones necesarias

        //3. Crear el productor de Kafka y enviar a través del topic


    }
}