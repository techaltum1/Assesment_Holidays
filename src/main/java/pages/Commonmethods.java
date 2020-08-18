package pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.Baseclass;

public class Commonmethods extends Baseclass {
	
	public static void exceldata(String key, String Reportfile) throws IOException {
		File myfile = new File(Reportfile);
		if (!myfile.exists()) {
			myfile.createNewFile();
		}
		FileWriter writerr = new FileWriter(Reportfile, true);
		BufferedWriter out = new BufferedWriter(writerr);
		out.toString();
		out.write(key);
		out.newLine();
		out.close();
		
	}

	public static void setcelldata(String parameterkey, String object, int colNum, String Reportfilepath)
			throws IOException {
		File src = new File(Reportfilepath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String sheettabname;
		sheettabname = "My_FirstSheet";
		XSSFSheet sheet1 = wb.getSheet(sheettabname);

		int rowlenth = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		for (int i = 0; i < rowlenth + 1; i++) {
			Row row = sheet1.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {

				if (row.getCell(0).getStringCellValue().equals(parameterkey)) {
					sheet1.getRow(i).createCell(colNum).setCellValue(object.toString());
				}
			}
		}
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		fout.flush();
		fout.close();


}


}