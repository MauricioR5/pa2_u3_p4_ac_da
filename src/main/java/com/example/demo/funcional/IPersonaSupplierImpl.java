package com.example.demo.funcional;

public class IPersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		String cedula = "1751556653";
		cedula = cedula + "zzzzz";
		return cedula;
	}

}
