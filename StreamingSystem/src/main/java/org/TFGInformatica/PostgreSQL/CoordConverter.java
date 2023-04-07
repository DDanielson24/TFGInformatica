package org.TFGInformatica.PostgreSQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CoordConverter {

    public CoordConverter () { }

    public float[] convertUTMToLatLong (String xOffset, String yOffset) {
        float latlonConverted[] = new float[2];

        try {
            ProcessBuilder pb = new ProcessBuilder("python3", "/home/daniel/Escritorio/TFGInformatica/StreamingSystem/UTM-to-Longtitude-Latitude-System-GitRepo/utm_to_longlat.py", xOffset, yOffset, "30");
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("coordConverter = " + line);
                if (line.startsWith("lat: ")) {
                    latlonConverted[0] = Float.parseFloat(line.substring(5, line.length()));
                }
                else if (line.startsWith("lon: ")) {
                    latlonConverted[1] = Float.parseFloat(line.substring(5, line.length()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return latlonConverted;
    }

}
