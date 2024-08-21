package com.vodafone.SOAP.API.Sample_SOAP_API;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InvoiceListService {

	private static List<InvoiceList> invoices = new ArrayList<>();
	
	static{
		InvoiceList invoice1 = new InvoiceList(4532, 1000, "Akanksha", "pending Invoice for May'24");
		invoices.add(invoice1);
		
		InvoiceList invoice2 = new InvoiceList(1357, 3000, "Deep", "pending Invoice for Jun'24");
		invoices.add(invoice2);
		
		InvoiceList invoice3 = new InvoiceList(1297, 3500, "A", "pending Invoice for Nov'23");
		invoices.add(invoice3);
		
		InvoiceList invoice4 = new InvoiceList(1890, 2000, "D", "pending Invoice for Dec'24");
		invoices.add(invoice4);
	}
	
	public InvoiceList findByAccountID(int accountID) {
		for(InvoiceList invoice:invoices) {
			if(invoice.getAccountID()==accountID)
				return invoice;
		}
		return null;
	}
	
	List<InvoiceList> findAll(){
		return invoices;
	}
	
}
