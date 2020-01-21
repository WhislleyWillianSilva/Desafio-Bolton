package com.whislley.bolton.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto {

	private InvoiceStatusDto status;
	private List<InvoiceDataDto> data;
	private InvoicePageDto page;
	private Integer count;
	private String signature;
	
	public InvoiceDto() {
		
	}
	
	public InvoiceStatusDto getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatusDto status) {
		this.status = status;
	}

	public List<InvoiceDataDto> getData() {
		return data;
	}

	public void setData(List<InvoiceDataDto> data) {
		this.data = data;
	}

	public InvoicePageDto getPage() {
		return page;
	}

	public void setPage(InvoicePageDto page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
