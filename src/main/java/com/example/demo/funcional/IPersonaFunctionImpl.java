package com.example.demo.funcional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class IPersonaFunctionImpl implements IPersonaFunction<String, Integer>{

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(IPersonaFunctionImpl.class);
	
	@Override
	public String aplicar(Integer arg) {
		
		if (arg > 0) {
	        LOG.info("B");
	        return "El número es positivo.";
	    } else if (arg < 0) {
	        LOG.info("C");
	        return "El número es negativo.";
	    } else {
	        LOG.info("D");
	        return "El número es cero.";
	    }
	}

}
