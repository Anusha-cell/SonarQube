package com.galaxe.sonarQube.exceltransformer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDetailsTransformer {
	/*
	 * this method takes Field array and list of Object array for the class for
	 * which it will generate excel sheet
	 */
	private ExcelDetailsTransformer()
	{}
	
	@SuppressWarnings("resource")
	public static ByteArrayInputStream generateExcel(Field[] headers, List<Object[]> projectData)
			throws IOException {

		Cell cell = null;
		XSSFWorkbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		XSSFSheet sheet = workbook.createSheet("project");
		ArrayList<Object[]> data = new ArrayList<>();
		printArray(headers, 0, data);

		// Creating headers
		CellStyle headerCellStyle = workbook.createCellStyle();

		headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		headerCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		int rownum = 0;
		int cellnum = 0;
		Row row = sheet.createRow(rownum);

		for (Object[] gitInfos : data) {

			for (Object obj : gitInfos) {
				cell = row.createCell(cellnum++);
				cell.setCellValue((String) obj);
				cell.setCellStyle(headerCellStyle);
			}
		}

		// creating the row and cells with object data
		rownum = 1;
		for (Object[] gitInfos : projectData) {
			row = sheet.createRow(rownum++);
			cellnum = 0;
			for (Object obj : gitInfos) {
				cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}

		// Making size of column auto resize to fit with data
		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}

		workbook.write(outputStream);
		return new ByteArrayInputStream(outputStream.toByteArray());

	}

	private static void printArray(Field[] arr, int x, ArrayList<Object[]> data) {

		if (x >= arr.length) {
			// Return, if x is greater or equal to size of Array.
			return;
		}

		// Else print element and recursively call for next element
		data.add(new String[] { arr[x].getName() });
		printArray(arr, ++x, data);
	}

}