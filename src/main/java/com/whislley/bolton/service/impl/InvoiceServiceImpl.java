package com.whislley.bolton.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whislley.bolton.model.entity.Invoice;
import com.whislley.bolton.repository.InvoiceRepository;
import com.whislley.bolton.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

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
		return this.invoiceRepository.save(invoice);
	}
}