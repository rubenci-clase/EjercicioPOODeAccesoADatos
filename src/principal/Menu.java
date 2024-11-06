package principal;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//listaPersonas.add(new Persona("Paco", 18, 'M', 89, 1.87));
		//listaPersonas.add(new Persona("Pepe", 18, 'M', 89, 1.87));
		
		Scanner entrada = new Scanner(System.in);
		int numMenu = 0;
		
		while(numMenu != 8) {
			System.out.println("1. Añadir una nueva persona por teclado");
			System.out.println("2. Mostrar la lista de personas");
			System.out.println("3. Modificar el nombre de una persona");
			System.out.println("4. Calcular el IMC de una persona");
			System.out.println("5. Indicar si una persona es mayor de edad");
			System.out.println("6. Generar el DNI de una persona");
			System.out.println("7. Leer de un fichero un total de 10 personas");
			System.out.println("8. Salir");
			numMenu = entrada.nextInt();
			
			switch(numMenu) {
				case 1:
					añadirUnaPersona();
					break;
				case 2:
					mostrarListaDePersonas();
					break;
				case 3:
					modificarNombreDeUnaPersona();
					break;
				case 4:
					calcularIMC();
					break;
				case 5:
					verSiUnaPersonaEsMayorDeEdad();
					break;
				case 6:
					generarDNI();
					break;
				case 7:
					añadirPersonasDeUnFichero();
					break;
				}
		}
	}
	
	private static void añadirUnaPersona() {
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
		listaPersonas.add(new Persona(nombre, edad, sexo, peso, altura));
	}
	
	private static void mostrarListaDePersonas() {
		int contador = 0;
		for (Persona persona : listaPersonas) {
			contador++;
			System.out.println(contador + ". " + persona.getNombre());
		}
	}
	
	private static void modificarNombreDeUnaPersona() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nuevo nombre");
		listarYSeleccionarPersona().setNombre(entrada.nextLine());
	}
	
	private static void calcularIMC() {
		int imc = listarYSeleccionarPersona().calcularIMC();
		
		if(imc == -1) System.out.println("Infra peso");
		else if(imc == 0) System.out.println("Peso normal");
		else System.out.println("Sobrepeso");
		
	}
	
	private static void verSiUnaPersonaEsMayorDeEdad() {
		if (listarYSeleccionarPersona().esMayorDeEdad()) System.out.println("Es mayor de edad");
		else System.out.println("Es menor de edad");
	}
	
	private static void añadirPersonasDeUnFichero() {
		try {
			FileReader entradaF = new FileReader("listaPersonas.txt");
			
			int caracter = 0;
			String linea ="";
			int contador = 0;
			
			while(caracter != -1  || contador >= 10) {
				caracter = entradaF.read();
				
				if(caracter != '\n') {
					linea += (char)caracter;
				}
				else {
					System.out.println(linea);
					contador++;
					String [] listaDatos = linea.split(",");
					listaPersonas.add(new Persona(listaDatos[0], Integer.parseInt(listaDatos[1]), listaDatos[2].charAt(0), Double.parseDouble(listaDatos[3]), Double.parseDouble(listaDatos[4])));
					linea = "";
					
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	
	private static void generarDNI() {
		
		Persona personaSeleccionada = listarYSeleccionarPersona();
		
		personaSeleccionada.setDni(Persona.generaDNI());
		
		System.out.println("DNI generado: " + Persona.generaDNI());
	}
	
	private static Persona listarYSeleccionarPersona() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Selecciona el id de la persona:");
		int contador = 0;
		for (Persona persona : listaPersonas) {
			contador++;
			System.out.println(contador + ". " + persona.getNombre());
		}
		int idPersona = entrada.nextInt();
		
		return listaPersonas.get(idPersona -1);
	}

}
