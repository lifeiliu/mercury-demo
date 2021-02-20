package com.mercury.reportingservice.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mercury.core.bean.OrdersReport;

@Service
public class PDFService {
	
	public ByteArrayInputStream getOrdersReportInPDF(OrdersReport ordersReport) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, out);
			document.open();
			document.add(new Paragraph("Name: " + ordersReport.getUsername()));
			document.add(new Paragraph("Total Order: " + ordersReport.getTotal()));
			document.add(new Paragraph("Total Order Amount: $" + ordersReport.getTotalAmount()));
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return new ByteArrayInputStream(out.toByteArray());
	}

}
