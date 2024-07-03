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
    private PdfFont fonte;
    private PdfFont negrito;
    private final int tamanhoTitulo=22;
    private final int tamanhoTexto=11;

    public GeradorPDF() throws IOException {
        this.fonte = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        this.negrito = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
    }
    
  
    @Override
    public void gerarPDF(List<Sensor> listaSensor) {
        try {
            Paragraph pulaLinha= new Paragraph(" ").setFontSize(tamanhoTexto);
            ProcessadorSensores processador = new ProcessadorSensores();
            ProcessadorAnomalias procAnom= new ProcessadorAnomalias();
            PdfWriter writer = new PdfWriter("novoRelatorio.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            
            SolidLine linhaSolida = new SolidLine(1f); 
            LineSeparator ls = new LineSeparator(linhaSolida);
            ls.setWidth(UnitValue.createPercentValue(100));
            
            document.add(ls);
            
            Paragraph titulo= new Paragraph("Sensores de Qualidade de Água");
            titulo.setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(tamanhoTitulo);
            document.add(titulo);
            document.add(ls);
            document.add(pulaLinha);
            
            for(Sensor sensor: listaSensor){
                if(sensor.tipo==ETipo.QUALIDADE_AGUA){
                    document.add(new Paragraph(sensor.toString()).setFont(fonte).setFontSize(tamanhoTexto));
                    document.add(new Paragraph(" "));
                }
            }
            document.add(new Paragraph(processador.processarDados(listaSensor, ETipo.QUALIDADE_AGUA)).setFont(fonte).setFontSize(tamanhoTexto));
            
            document.add(pulaLinha);
            document.add(ls);
            titulo= new Paragraph("Análise de anomalias nos sensores de água");
            titulo.setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(tamanhoTitulo);
            document.add(titulo);
            document.add(ls);
            
            document.add(new Paragraph(procAnom.processarDados(listaSensor, ETipo.QUALIDADE_AGUA)).setFont(fonte).setFontSize(tamanhoTexto));
            
            document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
            
            document.add(ls);
            titulo=new Paragraph("Sensores de Qualidade de Ar");
            titulo.setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(tamanhoTitulo);
            document.add(titulo);
            
            document.add(ls);
            document.add(pulaLinha);
            
            for(Sensor sensor: listaSensor){
                if(sensor.tipo==ETipo.QUALIDADE_AR){
                    document.add(new Paragraph(sensor.toString()).setFont(fonte).setFontSize(tamanhoTexto));
                    document.add(new Paragraph(" "));
                }
            }
            
            document.add(new Paragraph(processador.processarDados(listaSensor, ETipo.QUALIDADE_AR)).setFont(fonte).setFontSize(tamanhoTexto));
            
            document.add(pulaLinha);
            
            document.add(ls);
            titulo= new Paragraph("Análise de anomalias nos sensores de ar");
            titulo.setTextAlignment(TextAlignment.CENTER).setFont(negrito).setFontSize(tamanhoTitulo);
            document.add(titulo);
            document.add(ls);
            
            document.add(new Paragraph(procAnom.processarDados(listaSensor, ETipo.QUALIDADE_AR)).setFont(fonte).setFontSize(tamanhoTexto));
            
            document.close();
        } catch (FileNotFoundException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
    
}
