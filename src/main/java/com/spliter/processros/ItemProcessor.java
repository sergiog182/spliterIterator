package com.spliter.processros;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.spliter.classes.Item;

public class ItemProcessor implements Processor{
	final static Logger log = Logger.getLogger(ItemProcessor.class);
	
	@Override
	public void process(Exchange ex) {
		Item item = ex.getIn().getBody(Item.class);
		ex.getIn().setHeader("fileName", item.getItemName().replace(" ", "_") + ".xml");
		log.info("Nuevo nombre del archivo: " + ex.getIn().getHeader("fileName", String.class));
	}
}
