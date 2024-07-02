package com.example.msreporte.utils;


import com.example.msreporte.entity.Reporte;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.ByteArrayOutputStream;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

import java.util.List;

public class PdfUtils {
    public static ByteArrayOutputStream generatePdfStream(List<Reporte> reportes) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        // Write column names
        // Map<String, Object> firstRow = queryResults.get(0);
        for (Reporte reporte :reportes) {
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph paragraph = new Paragraph(reporte.getTipo(), boldFont);
            document.add(paragraph);
        }
        document.add(new Paragraph("\n"));
        // Write data rows
        // for (Map<String, Object> row : queryResults) {
        //for (Object value : row.values()) {
        //    Paragraph paragraph2 = new Paragraph(value.toString());
        //    document.add(paragraph2);
        // }
        document.add(new Paragraph("\n"));
        // }
        document.close();
        return outputStream;
    }
}
