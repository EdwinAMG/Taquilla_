package Taquilla1;

import java.util.ArrayList;

public class Estadio {

	private String Nombre, Direccion;
	private int capacidad;
	private ArrayList<Tribuna> tribunas = new ArrayList<Tribuna>();
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	
	public Estadio(String nombre, String direccion, int capacidad) {
		this.Nombre = nombre;
		this.Direccion = direccion;
		this.capacidad = capacidad;
	}
	
	public void AgregarTribuna(Tribuna tribuna) {
		tribunas.add(tribuna);
	}
	
	public ArrayList<Tribuna> getTribuna() {
		return tribunas;
	}

	public String getNombre() {
		return Nombre;
	}


	public String getDireccion() {
		return Direccion;
	}


	public int getCapacidad() {
		return capacidad;
	}
	
	public void AgregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public ArrayList<Partido> getPartido() {
		return partidos;
	}
	
}
