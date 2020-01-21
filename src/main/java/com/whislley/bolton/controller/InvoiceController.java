package com.whislley.bolton.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.whislley.bolton.model.entity.Invoice;
import com.whislley.bolton.service.InvoiceService;

@RestController
@RequestMapping(value="/api/v1/nfe")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@GetMapping("/integrate-invoices")
	public ResponseEntity<Void> integrateInvoices(RestTemplate restTemplate){
		String endPoint = "https://sandbox-api.arquivei.com.br/v1/nfe/received";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("x-api-id", "f96ae22f7c5d74fa4d78e764563d52811570588e");
		headers.add("x-api-key", "cc79ee9464257c9e1901703e04ac9f86b0f387c2");
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		try {
			this.invoiceService.integrationApi(endPoint, HttpMethod.GET, entity, restTemplate);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping()
	public ResponseEntity<Iterable<Invoice>> findAllInvoices() {
		Iterable<Invoice> result = this.invoiceService.findAllInvoices();
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/accesskey/{accessKey}")
	public ResponseEntity<Invoice> findOneByAccessKey(
			@PathVariable (name = "accessKey") String accessKey ) {
		Optional<Invoice> result = this.invoiceService.findOneByAccessKey(accessKey);
		if (!result.isEmpty()) {
			return ResponseEntity.ok(result.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Invoice> registerInvoice(
			@RequestBody Invoice notaFiscal) {
		Invoice result = this.invoiceService.registerInvoice(notaFiscal);
		if (result != null) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return ResponseEntity.badRequest().build();
	}
}