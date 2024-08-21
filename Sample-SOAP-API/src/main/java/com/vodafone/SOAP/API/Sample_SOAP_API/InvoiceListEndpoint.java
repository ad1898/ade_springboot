package com.vodafone.SOAP.API.Sample_SOAP_API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vodafone.getinvoicelist.GetAllInvoiceListRequest;
import com.vodafone.getinvoicelist.GetAllInvoiceListResponse;
import com.vodafone.getinvoicelist.GetInvoiceListRequest;
import com.vodafone.getinvoicelist.GetInvoiceListResponse;
import com.vodafone.getinvoicelist.Invoice;

@Endpoint
public class InvoiceListEndpoint {
	
	@Autowired
	InvoiceListService service;
	
	
	
	@PayloadRoot(namespace="http://vodafone.com/getInvoiceList", 
			localPart="GetInvoiceListRequest")
	@ResponsePayload
	public GetInvoiceListResponse processInvoiceListRequest
	(@RequestPayload GetInvoiceListRequest request) {		
		InvoiceList invoiceList = service.findByAccountID(request.getAccountID());
		
		return mapInvoiceList(invoiceList);
	}

	private GetInvoiceListResponse mapInvoiceList(InvoiceList invoiceList) {
		GetInvoiceListResponse response = new GetInvoiceListResponse();
		
		response.setInvoice(mapInvoice(invoiceList));
		return response;
	}
	
	private GetAllInvoiceListResponse mapAllInvoiceList(List<InvoiceList> invoiceLists) {
		GetAllInvoiceListResponse response = new GetAllInvoiceListResponse();
		for(InvoiceList invoice:invoiceLists) {
			Invoice mapInvoice = mapInvoice(invoice);
			response.getInvoice().add(mapInvoice);
		}
		
		return response;
	}

	private Invoice mapInvoice(InvoiceList invoiceList) {
		Invoice invoice = new Invoice();
		invoice.setAccountID(invoiceList.getAccountID());
		invoice.setAmount(invoiceList.getAmount());
		invoice.setDescription(invoiceList.getDescription());
		//invoice.setDueDate("2024-09-07");
		invoice.setName(invoiceList.getName());
		return invoice;
	}

	@PayloadRoot(namespace="http://vodafone.com/getInvoiceList", 
			localPart="GetAllInvoiceListRequest")
	@ResponsePayload
	public GetAllInvoiceListResponse processAllInvoiceListRequest
	(@RequestPayload GetAllInvoiceListRequest request) {		
		List<InvoiceList> invoiceLists = service.findAll();
		
		return mapAllInvoiceList(invoiceLists);
	}
}
