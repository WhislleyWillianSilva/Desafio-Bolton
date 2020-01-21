package com.whislley.bolton.service.impl;

import java.io.StringReader;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.whislley.bolton.service.Base64ToNFeService;

@Service
public class Base64ToNFeServiceImpl implements Base64ToNFeService {
	
	@Override
	public double amountInvoice(String base64) throws Exception {

		if (StringUtils.isEmpty(base64)) {
			throw new Exception("xml base64 not found" + base64);
		}
		String xml = new String(Base64.getDecoder().decode(base64));
		Document doc = parseStringToXml(xml);
		double valorNFe = Double.parseDouble(
				doc.getDocumentElement().getElementsByTagName("vNF").item(0).getChildNodes().item(0).getNodeValue());
		return valorNFe;
	}
	
	private static Document parseStringToXml(String xml) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));
			return doc;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
