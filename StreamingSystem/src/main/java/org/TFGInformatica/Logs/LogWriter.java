package org.TFGInformatica.Logs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {

    private String pathFile = "";

    public LogWriter (String pathFile) {
        this.pathFile = pathFile;
    }

    public void writeLog(String log) {
        try {
            LocalDateTime fecha = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEE dd MMM yyyy HH:mm:ss");
            String fechaFormateada = fecha.format(formato);

            Writer writer = new BufferedWriter(new FileWriter(pathFile, true));
            writer.write(fechaFormateada + " --> " + log + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
