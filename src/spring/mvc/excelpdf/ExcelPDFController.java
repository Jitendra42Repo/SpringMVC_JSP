package spring.mvc.excelpdf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.DBLogs;
import spring.mvc.jdbc.JDBCExample;

@Controller
public class ExcelPDFController {
	
	@Autowired
	private JDBCExample jdbcExample;
	
	@RequestMapping(value = "/excel")
	public ModelAndView downloadExcel() {
		System.out.println("ExcelPDFController's downloadExcel is invoked !");
		DBLogs dbLogs = new DBLogs();
		dbLogs.setDbLogs(this.jdbcExample.queryAllLogs());
		return new ModelAndView("excelDocument", "dbLogs", dbLogs); 
	}
	
	@RequestMapping("/pdf")
	public ModelAndView downloadPdf() {
		System.out.println("ExcelPDFController's downloadPdf is invoked !");
		DBLogs dbLogs = new DBLogs();
		dbLogs.setDbLogs(this.jdbcExample.queryAllLogs());
		return new ModelAndView("pdfDocument","dbLogs",dbLogs);
	}
	
	

}
