package com.whislley.bolton.service;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.whislley.bolton.model.entity.Invoice;

public interface InvoiceService {

	Iterable<Invoice> findAllInvoices();

	Optional<Invoice> findOneByAccessKey(String accessKey);

	Invoice registerInvoice(Invoice notaFiscal);
	
	void integrationApi(String endPoint, HttpMethod httpMethod, HttpEntity<String> entity,
			RestTemplate restTemplate) throws Exception;
}