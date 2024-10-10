package arreglos;

import clases.Persona;

import java.util.ArrayList;

public class ArregloPersonas {
	
	//  Atributo privado
	private ArrayList <Persona> per;
	//  Constructor
    public ArregloPersonas() {
    	per = new ArrayList <Persona> ();
		adicionar(new Persona(1001, "Juan Prado Salazar", "07557853", 82.3, 1.75, 3));
		adicionar(new Persona(1002, "Pedro Romero Soto", "11002348", 79.5, 1.58, 1));
		adicionar(new Persona(1003, "Luis Pinto Garza", "62279345", 82.7, 1.83, 0));
		adicionar(new Persona(1004, "Daniel Rojas Saenz", "20977241", 47.2, 1.72, 2));
		adicionar(new Persona(1005, "Jorge Espinal Vega", "06377845", 64.9, 1.88, 1));
    }
	//  Operaciones públicas básicas
	public void adicionar(Persona x) {
		per.add(x);
	}
	public int tamaño() {
		return per.size();
	}
	public Persona obtener(int i) {
		return per.get(i);
	}
	public Persona buscar(int codigo) {
		Persona x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	public Persona buscar(String dni) {
		Persona x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(Persona x) {
		per.remove(x);
	}
	//  Operaciones públicas complementarias
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño()-1).getCodigo() + 1;		
	}
	
}