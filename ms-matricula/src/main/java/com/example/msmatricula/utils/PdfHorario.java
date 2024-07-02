package com.example.msmatricula.utils;

import com.example.msmatricula.entity.Horario;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfHorario {
    public static ByteArrayOutputStream generatePdfStream(List<Horario> horarios) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Estilo de fuente
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

        // Agregar título al documento
        Paragraph title = new Paragraph("Horario de Clases", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);

        // Crear tabla para los horarios
        PdfPTable table = new PdfPTable(5); // Número de columnas
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Ancho de las columnas
        float[] columnWidths = {1f, 2f, 3f, 2f, 2f};
        table.setWidths(columnWidths);

        // Encabezados de la tabla
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("ID", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Curso", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Descripción", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Grado Designado", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("ID del Estudiante", boldFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        // Iterar sobre la lista de horarios
        for (Horario horario : horarios) {
            table.addCell(new PdfPCell(new Phrase(String.valueOf(horario.getId()), normalFont)));
            table.addCell(new PdfPCell(new Phrase(horario.getCurso(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(horario.getDescripcion(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(horario.getGradoDesigando(), normalFont)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(horario.getEstudianteId()), normalFont)));
        }

        // Agregar tabla al documento
        document.add(table);

        // Cerrar el documento
        document.close();

        return outputStream;
    }
}
