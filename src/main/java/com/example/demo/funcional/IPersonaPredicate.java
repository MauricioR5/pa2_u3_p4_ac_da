package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaPredicate <T>{

	public boolean evaluar(T arg); //porque recibe un valor, lo evalua y luego dice si o no
}
