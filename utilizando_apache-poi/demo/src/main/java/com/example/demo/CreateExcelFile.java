package com.example.demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelFile {

    public static void execute() {
        try(Workbook arquivoExcel = new XSSFWorkbook()){
            Sheet aba = arquivoExcel.createSheet("Produtos");
            Row linhaCabecalho = aba.createRow(0);
            String[] colunas = {"Name", "Description", "Price", "In Stock", "Quantity"};

            CellStyle estiloCabecalho = arquivoExcel.createCellStyle();
            Font fonte = arquivoExcel.createFont();
            fonte.setBold(true);
            estiloCabecalho.setFont(fonte);
            estiloCabecalho.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            estiloCabecalho.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            for (int i=0; i<colunas.length; i++){
                Cell celula = linhaCabecalho.createCell(i);
                celula.setCellValue(colunas[i]);
                celula.setCellStyle(estiloCabecalho);
            }

            Object[][] dadosDosProdutos = {
                    {"Smartphone", "6.1-inch display, 128GB storage, dual camera", 699.99, true, 50},
                    {"Wireless Headphones", "Over-ear, noise-cancelling, 30-hour battery", 199.99, true, 40},
                    {"Electric Kettle", "1.7L capacity, auto shut-off, stainless steel", 49.99, true, 15}
            };

            int numeroLinha = 1;

            for(Object[] produto : dadosDosProdutos){
                Row linha = aba.createRow(numeroLinha++);
                linha.createCell(0).setCellValue(produto[0].toString());
                linha.createCell(1).setCellValue(produto[1].toString());
                linha.createCell(2).setCellValue(produto[2].toString());
                linha.createCell(3).setCellValue(produto[3].toString());
                linha.createCell(4).setCellValue(produto[4].toString());
            }

            try(FileOutputStream arquivo = new FileOutputStream("produtos_excel.xlsx")) {
                arquivoExcel.write(arquivo);
                System.out.println("Arquivo criado com sucesso!");
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
