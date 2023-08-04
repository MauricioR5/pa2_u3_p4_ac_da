package com.example.demo.funcional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class IPersonaPredicateImpl  implements IPersonaPredicate<String>{
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(IPersonaPredicateImpl.class);


	@Override
	public boolean evaluar(String arg) {
	LOG.info("Ejemplo" + arg);
	return true;
	}

}
