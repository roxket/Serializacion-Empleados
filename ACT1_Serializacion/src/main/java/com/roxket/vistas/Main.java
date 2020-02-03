package com.roxket.vistas;

import com.roxket.modelos.Empleado;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	//Iniciamos el main
	public static void main(String[] args) {
		//Iniciamos el arrayList
		ArrayList<Empleado> empleados = new ArrayList();

		//Iniciamos varios empleados
		Empleado empleado1 = new Empleado("Jose", 24, 1200.00);
		Empleado empleado2 = new Empleado("Maria", 34, 1500.28);
		
		System.out.println("Iniciamos empleados...");
		//Introducimos los empleados en el arrayList
		empleados.add(empleado1);
		empleados.add(empleado2);

		System.out.println("Empleados introducidos en el Arraylist...");
		//Iniciamos la creacion/lectura del archivo
		
		//Comprobamos si existe, caso contrario lo creamos
		File fichero = new File("listadoEmpleados.txt");
		try {
			if (!fichero.exists()) {
				//Creamos el fichero
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter(fichero));
				System.out.println("Fichero creado...");
			} else{
				System.out.println("Fichero existente...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Tras comprobar que el archivo existe y se crea correctamente, introducimos los datos del arrayList en el fichero
		try {
			if(fichero.exists()){
//				PrintWriter pw = new PrintWriter(new FileOutputStream("listadoEmpleados.txt"));
//				for (Empleado empleado : empleados){
//					pw.println(empleado.getNombre() + " " + empleado.getEdad() + " " + empleado.getSalario() + empleado.getClave());
//				}
//				pw.close();
				
				//Utilizamos métodos admitidos por serialización
				FileOutputStream fos = new FileOutputStream("listaEmpleados.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(empleados);
				oos.close();
				System.out.println("Volcado del Arraylist en el archivo...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Leelos los datos introducidos en el archivo
		try {
			//Leelos los datos introducidos en el archivo
			//Utilizamos métodos admitidos por serialización
			FileInputStream fis = new FileInputStream("listaEmpleados.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Empleado> empleadosLectura = (ArrayList<Empleado>) ois.readObject();
			System.out.println("-----------");
			//Imprimimos por pantalla los objectos recuperados
			for(Empleado empleado : empleadosLectura){
				System.out.println(empleado);
			}
			System.out.println("-----------");
			ois.close();
			System.out.println("Lectura del archivo finalizada...");
		} catch (Exception e) {
		}
	}
}
