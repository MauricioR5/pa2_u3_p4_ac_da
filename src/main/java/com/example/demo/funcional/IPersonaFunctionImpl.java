package com.example.demo.funcional;

public class IPersonaFunctionImpl implements IPersonaFunction<Character, Integer>{

	@Override
	public Character aplicar(Integer arg) {
		int value = arg;
        char c  = (char) value;
		return c;
	}
}
