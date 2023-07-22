package org.TFGInformatica.Contaminacion;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;

public class EstacionesCSVReader {

    private String original_file;

    public EstacionesCSVReader(String path) {
        this.original_file = path;
    }

    public float[] getLatLongEstacion(Integer idelem) {
        float[] latLongEstacion = new float[2];
        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(this.original_file))
                                        .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
            String[] linea = null;
            while (((linea = csvReader.readNext()) != null)) {
                if (linea[1].equals(idelem.toString())) {
                    latLongEstacion[0] = Float.parseFloat(linea[24]);
                    latLongEstacion[1] = Float.parseFloat(linea[23]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLongEstacion;
    }

}
