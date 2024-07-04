/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.modelo;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.properties.AreaBreakType;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ottoj
 */
public class GeradorPDF implements IGeradorPDF{
    private final PdfFont fonte;
    private final PdfFont negrito;

    public GeradorPDF() throws IOException {
        this.fonte = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        this.negrito = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
    }

    @Override
    public void gerarPDF(List<Sensor> listaSensor) {
        try {
            PdfWriter writer = new PdfWriter("novoRelatorio.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            LineSeparator ls = new LineSeparator(new SolidLine(1f)).setWidth(UnitValue.createPercentValue(100));
            Paragraph pulaLinha = new Paragraph(" ").setFontSize(11);

            document.add(new Paragraph("Sensores de Qualidade de Água").setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(22))
                    .add(ls)
                    .add(pulaLinha);

            listaSensor.stream().filter(sensor -> sensor.tipo == ETipo.QUALIDADE_AGUA)
                    .forEach(sensor -> document.add(new Paragraph(sensor.toString()).setFont(fonte).setFontSize(11))
                            .add(new Paragraph(" ")));

            document.add(new Paragraph(new ProcessadorMedia().processarDados(listaSensor, ETipo.QUALIDADE_AGUA)).setFont(fonte).setFontSize(11))
                    .add(pulaLinha)
                    .add(ls)
                    .add(new Paragraph("Análise de anomalias nos sensores de água").setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(22))
                    .add(ls)
                    .add(new Paragraph(new ProcessadorAnomalias().processarDados(listaSensor, ETipo.QUALIDADE_AGUA)).setFont(fonte).setFontSize(11))
                    .add(new AreaBreak(AreaBreakType.NEXT_PAGE))
                    .add(ls)
                    .add(new Paragraph("Sensores de Qualidade de Ar").setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(22))
                    .add(ls)
                    .add(pulaLinha);

            listaSensor.stream().filter(sensor -> sensor.tipo == ETipo.QUALIDADE_AR)
                    .forEach(sensor -> document.add(new Paragraph(sensor.toString()).setFont(fonte).setFontSize(11))
                            .add(new Paragraph(" ")));

            document.add(new Paragraph(new ProcessadorMedia().processarDados(listaSensor, ETipo.QUALIDADE_AR)).setFont(fonte).setFontSize(11))
                    .add(pulaLinha)
                    .add(ls)
                    .add(new Paragraph("Análise de anomalias nos sensores de ar").setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(22))
                    .add(ls)
                    .add(new Paragraph(new ProcessadorAnomalias().processarDados(listaSensor, ETipo.QUALIDADE_AR)).setFont(fonte).setFontSize(11));

            document.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
