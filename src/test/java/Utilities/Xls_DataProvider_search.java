package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xls_DataProvider_search {
	static Workbook book;
	static Sheet sheet;

	public static String exceldata_location = "D:\\Rll Project\\search\\Demowebshop_Search\\src\\test\\java\\testdata.xlsx";

	public static String[] getSearchData(String sheetName) throws IOException {
		try (FileInputStream file = new FileInputStream(exceldata_location)) {
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);

			int startRow = 1; // Start from the second row

			String[] searchData = new String[sheet.getLastRowNum() - startRow + 1];

			for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
				searchData[i - startRow] = sheet.getRow(i).getCell(0).toString();
			}
			return searchData;
		} finally {
			if (book != null) {
				book.close();
			}
		}
	}
}
