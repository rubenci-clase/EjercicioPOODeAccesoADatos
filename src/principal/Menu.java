package principal;

import java.util.Scanner;

public class Menu {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int numMenu = 0;
		
		Controlador controlador = new Controlador();
		
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
					controlador.añadirUnaPersona();
					break;
				case 2:
					controlador.mostrarListaDePersonas();
					break;
				case 3:
					controlador.modificarNombreDeUnaPersona();
					break;
				case 4:
					controlador.calcularIMC();
					break;
				case 5:
					controlador.verSiUnaPersonaEsMayorDeEdad();
					break;
				case 6:
					controlador.generarDNI();
					break;
				case 7:
					controlador.añadirPersonasDeUnFichero();
					break;
				}
			}
		}
}
