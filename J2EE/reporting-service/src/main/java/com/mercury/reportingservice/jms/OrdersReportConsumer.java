package com.mercury.reportingservice.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.mercury.core.bean.OrdersReport;
import com.mercury.reportingservice.aws.s3.S3UploadService;
import com.mercury.reportingservice.pdf.PDFService;

@Component
public class OrdersReportConsumer {
	
	@Autowired
	S3UploadService s3UploadService;
	
	@Autowired
	PDFService pdfService;

	@JmsListener(destination = "ordersReportQueue", containerFactory = "ordersReportContainer")
	public void receive(Message msg) throws JMSException {
		ObjectMessage objectMessage = (ObjectMessage) msg;
		OrdersReport ordersReport = (OrdersReport) objectMessage.getObject();
		System.out.println(ordersReport);
		s3UploadService.upload(pdfService.getOrdersReportInPDF(ordersReport));
	}

}
