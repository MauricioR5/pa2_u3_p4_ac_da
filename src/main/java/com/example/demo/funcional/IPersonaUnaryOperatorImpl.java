package com.example.demo.funcional;

public class IPersonaUnaryOperatorImpl implements IPersonaUnaryOperator<Double>{

	@Override
	public Double aplicar(Double arg) {
		Double resultado = arg + 8.43;
		resultado = arg + resultado/2.4;
		return resultado;
	}
	
}
