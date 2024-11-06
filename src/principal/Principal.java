package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el nombre");
		String nombre = entrada.nextLine();
		
		System.out.println("Introduce la edad");
		int edad = entrada.nextInt();
		
		System.out.println("Introduce el sexo");
		char sexo = entrada.next().charAt(0);
		
		System.out.println("Introduce el peso");
		double peso = entrada.nextDouble();
	
		System.out.println("Introduce la altura");
		double altura = entrada.nextDouble();
		
		Persona p1 = new Persona(nombre);
		
		Persona p2 = new Persona(nombre, edad,sexo);
		
		Persona p3 = new Persona(nombre, edad, sexo, peso, altura);
	
		System.out.println(p1.esMayorDeEdad());
		System.out.println(p1.calcularIMC());
		System.out.println(p1.toString());
		
		System.out.println(p2.esMayorDeEdad());
		System.out.println(p2.calcularIMC());
		System.out.println(p2.toString());
		
		System.out.println(p3.esMayorDeEdad());
		System.out.println(p3.calcularIMC());
		System.out.println(p3.toString());
	}

}
