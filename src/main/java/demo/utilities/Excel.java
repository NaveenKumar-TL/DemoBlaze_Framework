package demo.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel
{
	    public static Object[][] getExcelData() throws Exception
	    {
	        FileInputStream file =
	         new FileInputStream("Test_Data\\OrderData.xlsx");

	        XSSFWorkbook wb = new XSSFWorkbook(file);

	        XSSFSheet sheet = wb.getSheet("Sheet1");

	        int rows = sheet.getLastRowNum();
	        int cols = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rows][cols];

	        for(int i=1;i<=rows;i++)
	        {
	            for(int j=0;j<cols;j++)
	            {
	                data[i-1][j] =
	                        sheet.getRow(i).getCell(j).toString();
	            }
	        }
	        
	        return data;
	    }
	}

