package principal;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Controlador {
	ListaPersonas listaPersonas;
	
	public Controlador() {
		this.listaPersonas = new ListaPersonas();
	}

	public void añadirUnaPersona() {
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
		listaPersonas.añadirPersonas(new Persona(nombre, edad, sexo, peso, altura));
	}
	
	public void mostrarListaDePersonas() {
		int contador = 0;
		for (Persona persona : listaPersonas.listarPersonas()) {
			contador++;
			System.out.println(contador + ". " + persona.getNombre());
		}
		System.out.println("-------------------------------");
	}
	
	public void modificarNombreDeUnaPersona() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nuevo nombre");
		String nuevoNombre = entrada.nextLine();
		listarYSeleccionarPersona().setNombre(nuevoNombre);
	}
	
	public void calcularIMC() {
		int imc = listarYSeleccionarPersona().calcularIMC();
		
		if(imc == -1) System.out.println("Infra peso");
		else if(imc == 0) System.out.println("Peso normal");
		else System.out.println("Sobrepeso");
		
	}
	
	public void verSiUnaPersonaEsMayorDeEdad() {
		if (listarYSeleccionarPersona().esMayorDeEdad()) System.out.println("Es mayor de edad");
		else System.out.println("Es menor de edad");
	}
	
	public void añadirPersonasDeUnFichero() {
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
					contador++;
					String [] listaDatos = linea.split(",");
					listaPersonas.añadirPersonas(new Persona(listaDatos[0], Integer.parseInt(listaDatos[1]), listaDatos[2].charAt(0), Double.parseDouble(listaDatos[3]), Double.parseDouble(listaDatos[4])));;
					linea = "";
					
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	
	public void generarDNI() {
		
		Persona personaSeleccionada = listarYSeleccionarPersona();
		
		personaSeleccionada.setDni(Persona.generaDNI());
		
		System.out.println("DNI generado: " + Persona.generaDNI());
	}
	
	public Persona listarYSeleccionarPersona() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Selecciona el id de la persona:");
		int contador = 0;
		for (Persona persona : listaPersonas.listarPersonas()) {
			contador++;
			System.out.println(contador + ". " + persona.getNombre());
		}
		int idPersona = entrada.nextInt();
		
		return listaPersonas.mostrarPersonaPorId(idPersona -1);
	}
}

