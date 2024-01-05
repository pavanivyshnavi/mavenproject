package testNG;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Excel {
	
	@DataProvider(name="usercredentials")
	public Object Exceldata() throws Throwable  {
	File f=new File("./testdata/Book1.xlsx");
	FileInputStream fis=new FileInputStream(f);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheetAt(0);
	int rows=sheet.getPhysicalNumberOfRows();
	int cells=sheet.getRow(0).getLastCellNum();
	Object[][] info=new Object[rows-1][cells];
	for(int i=0;i<rows-1;i++) {
		for(int j=0;j<cells;j++) {
			DataFormatter df=new DataFormatter();
			
			info[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
		}
	}
	
	return info;

}
}