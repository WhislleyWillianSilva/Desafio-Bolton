package com.whislley.bolton.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.whislley.bolton.model.entity.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
	
	public Optional<Invoice> findOneByAccessKey(String accessKey);
}