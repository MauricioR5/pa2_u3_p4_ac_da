package com.example.demo.funcional;

public class IPersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		String cedula = "17235558568";
		cedula = cedula + "zzzzz";
		return cedula;
	}

}
