package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\OpenCart_LoginData.xlsx";
		ExcelUtility xlutility=new ExcelUtility(path);
		
		int totalrows=xlutility.getRowCount("sheet1");
		int totalcols=xlutility.getCellCount("sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols; j++)
			{
				logindata[i-1][j]=xlutility.getCellData("sheet1", i, j);
			}
				
		}
		return logindata;
	}

}
