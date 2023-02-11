package org.TFGInformatica.Gasolina;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.TFGInformatica.EstacionDeServicio;

public class XLSReader {

    private String original_file;

    public XLSReader(String path) {
        this.original_file = path;
    }

    public List<EstacionDeServicio> readXLS() {
        List<EstacionDeServicio> listaDevolver = new LinkedList<>();

        try {
            File xlsFile = new File(this.original_file);
            FileInputStream xlsFileIS = new FileInputStream(xlsFile);

            HSSFWorkbook workbook = new HSSFWorkbook(xlsFileIS);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int filasMadrid = 0;

            Iterator<Row> it = sheet.iterator();
            while (it.hasNext()) {
                Row row = it.next();

                if (row.getCell(0).toString().equals("MADRID")) {
                    filasMadrid++;
                    System.out.println("FilaMadrid: " + filasMadrid);
                    EstacionDeServicio es = new EstacionDeServicio();
                    Float precioGasolina95 = 0f;
                    Float precioGasolina98 = 0f;

                    es.setMunicipio(row.getCell(1).toString());
                    es.setMargen(row.getCell(5).toString());
                    es.setCodigoPostal(Integer.parseInt(row.getCell(3).toString()));
                    es.setDireccion(row.getCell(4).toString());
                    es.setLongitud(this.floatConverter(row.getCell(6).toString()));
                    es.setLatitud(this.floatConverter(row.getCell(7).toString()));

                    int denMedPrecioGasolina95 = 0;
                    if (!row.getCell(9).toString().equals("")) {
                        precioGasolina95 = precioGasolina95 + this.floatConverter(row.getCell(9).toString());
                        denMedPrecioGasolina95++;
                    }
                    if (!row.getCell(10).toString().equals("")) {
                        precioGasolina95 = precioGasolina95 + this.floatConverter(row.getCell(10).toString());
                        denMedPrecioGasolina95++;
                    }
                    if (!row.getCell(11).toString().equals("")) {
                        precioGasolina95 = precioGasolina95 + this.floatConverter(row.getCell(11).toString());
                        denMedPrecioGasolina95++;
                    }
                    if (denMedPrecioGasolina95 != 0) {
                        es.setPrecioGasolina95(precioGasolina95 / denMedPrecioGasolina95);
                    }

                    int denMedPrecioGasolina98 = 0;
                    if (!row.getCell(12).toString().equals("")) {
                        precioGasolina98 = precioGasolina98 + this.floatConverter(row.getCell(12).toString());
                        denMedPrecioGasolina98++;
                    }
                    if (!row.getCell(13).toString().equals("")) {
                        precioGasolina98 = precioGasolina98 + this.floatConverter(row.getCell(13).toString());
                        denMedPrecioGasolina98++;
                    }
                    if (denMedPrecioGasolina98 != 0) {
                        es.setPrecioGasolina98(precioGasolina98 / denMedPrecioGasolina98);
                    }

                    if (!row.getCell(14).toString().equals("")) {
                        es.setPrecioGasoleoA(this.floatConverter(row.getCell(14).toString()));
                    }
                    if (!row.getCell(15).toString().equals("")) {
                        es.setPrecioGasoleoPremium(this.floatConverter(row.getCell(15).toString()));
                    }
                    es.setRotulo(row.getCell(26).toString());

                    System.out.println("EstacionDeServicio: " + es.getMunicipio()+ " - " + es.getDireccion() + " creado exitosamente");
                    listaDevolver.add(es);
                }
            }

            workbook.close();
            xlsFileIS.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDevolver;
    }

    private Float floatConverter (String text) {
        String parteEntera = text.substring(0, text.indexOf(','));
        String parteDecimal = text.substring(text.indexOf(',') + 1, text.length());
        String floatConvertido = parteEntera + "." + parteDecimal;
        return Float.parseFloat(floatConvertido);
    }
}
