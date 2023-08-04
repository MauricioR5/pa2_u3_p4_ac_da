package com.example.demo.funcional;

public class IPersonaUnaryOperatorImpl implements IPersonaUnaryOperator<Double> {

	@Override
	public Double aplicar(Double arg) {

		Double resultado = arg * 2.0; 
		resultado = Math.sqrt(resultado); 
		return resultado;
	}

}
