package com.example.demo.funcional;

public class IPersonaPredicateImpl  implements IPersonaPredicate<Integer>{

	@Override
	public boolean evaluar(Integer arg) {
		Integer valor = 15;

		if (arg.compareTo(valor) > 25) {
			return true;
		} else {
			return false;
		}
	}

}
