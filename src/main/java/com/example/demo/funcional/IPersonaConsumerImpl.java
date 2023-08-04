package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IPersonaConsumerImpl implements IPersonaConsumer<String>{

	private static final Logger LOG = LoggerFactory.getLogger(IPersonaConsumerImpl.class);

	@Override
	public void accept(String arg) {
		
		LOG.info(arg);
		
	}

}
