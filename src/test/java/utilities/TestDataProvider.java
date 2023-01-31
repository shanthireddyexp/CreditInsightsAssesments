package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class TestDataProvider {
	
	public static FileInputStream fileInput;
	public static HSSFWorkbook workBook;
	public static HSSFSheet sheet;
	public static HSSFRow row;
	public static HSSFCell cell;
	public static File file;
	

		public static String getData(String excelfilePath, int sheetnumber, int row, int column){
			File file = new File("./TestData/"+excelfilePath);
			String data = null;
			try {
			fileInput = new FileInputStream(file);
			workBook = new HSSFWorkbook(fileInput);
			sheet = workBook.getSheetAt(sheetnumber);
			data = sheet.getRow(row).getCell(column).getStringCellValue();
		
			} catch (Exception e) {
				System.out.println("Exception is " + e.getMessage());
			}
		
			return data;
		}
		
        
}
