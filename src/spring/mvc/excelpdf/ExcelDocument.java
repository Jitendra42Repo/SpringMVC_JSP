package spring.mvc.excelpdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.DBLogs;

public class ExcelDocument extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HSSFSheet excelSheet = workbook.createSheet("System Log Report");
		
		response.setHeader("Content-Disposition", "attachment; filename=excelDocument.xls");
		
		HSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		
		HSSFCellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(HSSFColor.BLUE.index);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(font);
		
		setExcelHeader(headerStyle, excelSheet );
		
		DBLogs dbLogs = (DBLogs) model.get("dbLogs");
		int row = 1;
		
		for(DBLog dbLog: dbLogs.getDbLogs()) {
			HSSFRow excelRow = excelSheet.createRow(row++);
			excelRow.createCell(0).setCellValue(dbLog.getIDLOG());
			excelRow.createCell(1).setCellValue(dbLog.getLOGSTRING());
		}
		
	}
	
	public void setExcelHeader(HSSFCellStyle headerStyle, HSSFSheet excelSheet) {
		
		HSSFRow rowHeader = excelSheet.createRow(0);
		rowHeader.createCell(0).setCellValue("IDLOG");
		rowHeader.getCell(0).setCellStyle(headerStyle);
		rowHeader.createCell(1).setCellValue("LOGSTRING");
		rowHeader.getCell(1).setCellStyle(headerStyle);
		
	}

}
