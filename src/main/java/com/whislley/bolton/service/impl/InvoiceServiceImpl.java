package com.whislley.bolton.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whislley.bolton.model.dto.InvoiceDataDto;
import com.whislley.bolton.model.dto.InvoiceDto;
import com.whislley.bolton.model.entity.Invoice;
import com.whislley.bolton.repository.InvoiceRepository;
import com.whislley.bolton.service.Base64ToNFeService;
import com.whislley.bolton.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private Base64ToNFeService base64ToNFe;

	@Override
	public Iterable<Invoice> findAllInvoices() {
		return this.invoiceRepository.findAll();
	}

	@Override
	public Optional<Invoice> findOneByAccessKey(String accessKey) {
		return invoiceRepository.findOneByAccessKey(accessKey);
	}

	@Override
	public Invoice registerInvoice(Invoice invoice) {
		Optional<Invoice> result = findOneByAccessKey(invoice.getAccessKey());
		if (result.isEmpty()) {
			return this.invoiceRepository.save(invoice);
		}
		return null;
	}
	
	@Override
	public void integrationApi(String endPoint, HttpMethod httpMethod, HttpEntity<String> entity,
			RestTemplate restTemplate) throws Exception {

		InvoiceDto invoices = restTemplate.exchange(endPoint, HttpMethod.GET, entity, InvoiceDto.class).getBody();
		if (invoices != null && invoices.getData().size() > 0) {
			for (InvoiceDataDto data : invoices.getData()) {
				Invoice invoice = new Invoice();
				invoice.setAccessKey(data.getAccessKey());
				invoice.setAmount(base64ToNFe.amountInvoice(data.getXml()));
				registerInvoice(invoice);
			}
			integrationApi(invoices.getPage().getNext(), httpMethod, entity, restTemplate);
		}
	}
}