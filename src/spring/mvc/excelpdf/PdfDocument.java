package spring.mvc.excelpdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import spring.mvc.bean.DBLog;
import spring.mvc.bean.DBLogs;

public class PdfDocument extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PdfPTable table = new PdfPTable(2);
		PdfPCell header1 = new PdfPCell(new Phrase("IDLOG"));
		PdfPCell header2 = new PdfPCell(new Phrase("LOGSTRING"));
		header1.setHorizontalAlignment(Element.ALIGN_LEFT);
		header2.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(header1);
		table.addCell(header2);
		
		DBLogs dbLogs  = (DBLogs) model.get("dbLogs");
		
		for(DBLog dbLog : dbLogs.getDbLogs()) {
			table.addCell(String.valueOf(dbLog.getIDLOG()) );
			table.addCell(String.valueOf(dbLog.getLOGSTRING() ) ); 
			
		}
		document.add(table);
	}

}
