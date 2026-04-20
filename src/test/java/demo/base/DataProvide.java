package demo.base;

import org.testng.annotations.DataProvider;

import demo.utilities.Excel;

public class DataProvide {
	@DataProvider(name="orderData")
	  public Object[][] getData() throws Exception
	  {
	      Object[][] excelData = Excel.getExcelData();
	
	      Fakar_Random_Data faker = new Fakar_Random_Data();
	
	 
	      for(int i=0;i<excelData.length;i++)
	      {
	          excelData[i][3] = faker.getCardNumber();
	          excelData[i][4] = faker.getMonth();
	          excelData[i][5] = faker.getYear();
	      }
	
	      return excelData;
	  }
}

