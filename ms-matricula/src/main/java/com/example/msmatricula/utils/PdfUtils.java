package com.example.msmatricula.utils;

import com.example.msmatricula.entity.Matricula;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfUtils {
    public static ByteArrayOutputStream generatePdfStream(List<Matricula> matriculas) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Estilo de fuente
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

        // Agregar título al documento
        Paragraph title = new Paragraph("Lista de Matrículas", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Crear tabla para las matrículas
        PdfPTable table = new PdfPTable(4); // Número de columnas
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Ancho de las columnas
        float[] columnWidths = {1f, 2f, 1f, 1f};
        table.setWidths(columnWidths);

        // Encabezados de la tabla
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("ID", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Fecha de Matrícula", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Estado", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("ID del Estudiante", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        // Iterar sobre la lista de matrículas
        for (Matricula matricula : matriculas) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(matricula.getId()), normalFont)));
            table.addCell(new PdfPCell(new Phrase(matricula.getFechaMatricula().toString(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(matricula.getEstado(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(matricula.getEstudianteId()), normalFont)));
        }

        // Agregar tabla al documento
        document.add(table);

        // Cerrar el documento
        document.close();

        return outputStream;
    }
}
