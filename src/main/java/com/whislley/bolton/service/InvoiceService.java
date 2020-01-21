package com.whislley.bolton.service;

import java.util.Optional;

import com.whislley.bolton.model.entity.Invoice;

public interface InvoiceService {

	Iterable<Invoice> findAllInvoices();

	Optional<Invoice> findOneByAccessKey(String accessKey);

	Invoice registerInvoice(Invoice notaFiscal);
}