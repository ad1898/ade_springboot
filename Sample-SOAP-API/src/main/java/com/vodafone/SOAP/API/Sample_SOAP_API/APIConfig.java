package com.vodafone.SOAP.API.Sample_SOAP_API;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable Spring WebServices
@EnableWs

//Spring Configuration
@Configuration

public class APIConfig {
	//MessageDispatcherServlet
		//ApplicationContext
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		
		// Map messageDispatcherServlet to URL "/ws/*"
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	//WSDL getInvoiceList.wsdl
	@Bean(name="getInvoiceList")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema invoiceListSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("ListPort");
		definition.setTargetNamespace("http://vodafone.com/getInvoiceList");
		definition.setLocationUri("/ws");
		definition.setSchema(invoiceListSchema);
		
		return definition;
	}
	
	@Bean
	public XsdSchema invoiceListSchema() {
		return new SimpleXsdSchema(new ClassPathResource("GetInvoiceList.xsd"));
	}
	
}
