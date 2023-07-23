package org.TFGInformatica.Trafico;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;

public class PuntosCSVReader {

    private String original_file;

    public PuntosCSVReader(String path) {
        this.original_file = path;
    }

    public Integer buscarDistrito(Integer idelem) {
        Integer distrito = 0;
        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(this.original_file))
                                        .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
            String[] linea = null;
            while (((linea = csvReader.readNext())) != null) {
                if (linea[2].equals(idelem.toString()) && !linea[1].equals("")) {
                    distrito = Integer.parseInt(linea[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distrito;
    }

}
