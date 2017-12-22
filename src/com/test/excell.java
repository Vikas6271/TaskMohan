package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excell {

	public static void main(String[] args) throws Throwable 
	{
		File F1 = new File("C:\\Users\\PrathimaKandela\\Desktop\\SeleniumDocs\\Excellwrite.xlsx");
		FileInputStream Fis = new FileInputStream(F1);
		XSSFWorkbook Wb = new XSSFWorkbook(Fis);
		XSSFSheet Ws = Wb.getSheet("Sheet1");
		Ws.createRow(0).createCell(0).setCellValue("Name");
		Ws.createRow(1).createCell(0).setCellValue("Vignesh");
		Ws.createRow(2).createCell(0).setCellValue("Basha");
		Ws.createRow(3).createCell(0).setCellValue("Vikas");
		Ws.getRow(0).createCell(1).setCellValue("Number");
		Ws.getRow(1).createCell(1).setCellValue("9010298618");
		Ws.getRow(2).createCell(1).setCellValue("8977279363");
		Ws.getRow(3).createCell(1).setCellValue("8885338877");
		System.out.println("completed");
		FileOutputStream Fos = new FileOutputStream(F1);
		Wb.write(Fos);
		Wb.close();
		Fos.close();
		}
	}
