package principal;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {

	private ArrayList<Persona> listaPersonas;
	
	public ListaPersonas () {
		this.listaPersonas = new ArrayList<Persona>();
	}
	
	public void añadirPersonas(Persona persona) {
		listaPersonas.add(persona);
	}
	
	public List<Persona> listarPersonas() {
		return listaPersonas;
	}
	
	public Persona mostrarPersonaPorId(int id) {
		
		return listaPersonas.get(id);
		
	}
}
