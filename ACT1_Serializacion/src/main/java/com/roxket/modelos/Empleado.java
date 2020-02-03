
package com.roxket.modelos;
import java.io.Serializable;

//Implementamos la interfaz Serializable para transferencia en secuencia de bytes en la clase Empleado
public class Empleado implements Serializable{
	//Atributos de la clase
	private String nombre;
	private int edad;
	private Double salario;
	//Atributo común y no serializable (transient)
	private transient String clave;
	
	//Constructor con clave por defecto
	public Empleado(String nombre, int edad, Double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
		this.clave = "patata";
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Empleado{" + "nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + ", clave=" + clave + '}';
	}
}




