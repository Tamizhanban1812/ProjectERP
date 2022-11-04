package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datadriven {

	@DataProvider (name = "logindata")
	public String[][] getloginpagedata() throws IOException {
		File src = new File(".\\Login_Data.xlsx");
		FileInputStream fs = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet s = wb.getSheetAt(0);
		int Rowcount = s.getLastRowNum();
		int Columncount = s.getRow(0).getLastCellNum();
		String[][] data = new String [3][2];
		
		for (int r = 1; r<=Rowcount; r++) {
			XSSFRow Activerow = s.getRow(r);
			for (int c = 0; c<Columncount; c++) {
				XSSFCell cell = Activerow.getCell(c);
				DataFormatter df = new DataFormatter();
				String CellValue = df.formatCellValue(cell);
				data[r-1][c] = CellValue;
				
			}
			
		}
		wb.close();
		return data;
	}

}
