package org.TFGInformatica;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class GasolinaProducer {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/");

            HttpURLConnection restConnection = (HttpURLConnection) url.openConnection();
            restConnection.setRequestMethod("GET");
            restConnection.connect();

            int responseCode = restConnection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HTTPResponseCode: " + responseCode);
            }
            else {



            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
