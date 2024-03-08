package genericRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	/**
	 * This method is used to read the data from Excel File
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int row, int cell) throws Throwable 
	{
		FileInputStream finp = new FileInputStream(IpathConstants.ExcelPath);
		// To open workbook in the read mode
		Workbook wb = WorkbookFactory.create(finp);
		// Get the control of the sheet, row, cell, copy
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}
	
	/**
	 * This method is used to get last row of Excel File
	 * @param sheetName
	 * @return rowCount
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable
	{
		FileInputStream finp = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(finp);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		
		return rowCount;
	}
	
	/**
	 * This method is used to write data into Excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int row, int cell, String value) throws Throwable
	{
		FileInputStream finp = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(finp);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		wb.write(fout);
		wb.close();
	}
	
	/**
	 * DataProvider
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */
	public Object[][] excelData(String sheet) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowcount = sh.getLastRowNum()+1;
		int cellcount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][cellcount];
		
		for(int i=0; i<rowcount; i++)
		{
			for(int j=0; j<cellcount; j++)
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;	
	}
}
