package Taquilla1;
import java.util.ArrayList;

public class Tribuna {
	
	private String Nombre;
	private int Precio, Capacidad;
	private ArrayList<Puesto> puestos, puestosAbonos = new ArrayList<Puesto>();
	
	public Tribuna(String nombre, int precio, int capacidad) {
		this.Nombre = nombre;
		this.Precio = precio;
		this.Capacidad = capacidad;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getNombre() {
		return Nombre;
	}
	
	public void AgregarPuesto(Puesto puesto) {
		puestos.add(puesto);
	}

	public int getCapacidad() {
		return Capacidad;
	}
	
	public ArrayList<Puesto> getPuesto() {
		return puestos;
	}
	
	public void AgregarPuestoAbono(Puesto puestoAbono) {
		puestosAbonos.add(puestoAbono);
		for(int i = 0; i < puestos.size(); i++) {
			if(puestos.get(i).getLetra().equalsIgnoreCase(puestoAbono.getLetra()) && puestos.get(i).getNumero() == puestoAbono.getNumero()){
				puestos.remove(i);
			}
		}
	}
}
