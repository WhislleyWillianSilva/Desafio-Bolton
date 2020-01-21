package com.whislley.bolton.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto {

	private InvoiceStatusDto status;
	private List<InvoiceDataDto> data;
	private InvoicePageDto page;
	private Integer count;
	private String signature;
}
