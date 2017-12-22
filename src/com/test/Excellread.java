package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.Attributes.Name;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excellread 
{
	public static void main(String[] args) throws Throwable
	{
		File F1=new File("C:\\Users\\PrathimaKandela\\Desktop\\SeleniumDocs\\Excellwrite.xlsx");
		FileInputStream Fis = new FileInputStream(F1);
		XSSFWorkbook Wb = new XSSFWorkbook(Fis);
		XSSFSheet Ws = Wb.getSheet("Sheet1");
		int rowcount = Ws.getLastRowNum();
		int cellcount = Ws.getRow(0).getLastCellNum();
		System.out.println(rowcount);
		System.out.println(cellcount);
		for (int i = 1; i <= rowcount; i++)
		{
			System.out.println( Ws.getRow(i).getCell(0).getStringCellValue());
			System.out.println(Ws.getRow(i).getCell(1).getStringCellValue());
		}
		
		FileOutputStream Fos = new FileOutputStream(F1);
		Wb.write(Fos);
		Wb.close();
		Fos.close();
	}
}


         
