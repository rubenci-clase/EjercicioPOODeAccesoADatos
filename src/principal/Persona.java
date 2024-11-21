package principal;

import java.util.Objects;
import java.util.Random;

public class Persona {

	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;
	
	public Persona(String nombre, int edad, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		dni = generaDNI();
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		dni = generaDNI();
	}

	public Persona(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		dni = generaDNI();
	}

	public int calcularIMC() {
		double imc = this.peso / altura * altura;
		
		if (imc < 20) return -1;
		else if (imc >= 20 && imc <=25) return 0;
		else return 1;	
	}
	
	public boolean esMayorDeEdad() {
		if(edad >= 18) return true;
		else return false;
	}
	
	public char comprobarSexo(char sexo) {
		if (this.sexo == sexo) return sexo;
		else return 'h';
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
	public static String generaDNI() {
		
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		Random random = new Random();
		
		int aleatorio = random.nextInt(10000000, 99999999);
		
		return aleatorio + "" + letras.charAt((int)aleatorio%23);
	}

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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, dni, edad, nombre, peso, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(dni, other.dni) && edad == other.edad && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso) && sexo == other.sexo;
	}
	
	

}
