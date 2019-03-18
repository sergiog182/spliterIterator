package com.spliter.builder;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

import com.spliter.processros.ItemProcessor;

public class MainRouteBuilder extends RouteBuilder{
	@Override
	public void configure() {
		DataFormat jaxb = new JaxbDataFormat("com.spliter.classes");
		
		from("file:files/incoming?noop=true")
		// Separar utilziado xpath
		//.split(xpath("/order/items/item"))
		
		// Separar utilizando iteratior
		// Al utilizar streaming, el xml no se carga completo en memoria
		// Ya que xpath carga todo el xml en memoria, no se debe utilizar con streaming
		.split().tokenizeXML("item").streaming()
		
		.unmarshal(jaxb)
		.process(new ItemProcessor())
		.marshal(jaxb)
		.toD("file:files/outgoing?fileExist=append&fileName=${headers.fileName}");
	}
}
