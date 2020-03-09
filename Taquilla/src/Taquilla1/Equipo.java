package Taquilla1;
import java.util.ArrayList;

public class Equipo {
	
	private String Nombre, Liga;
	private ArrayList<Partido> partidos = new ArrayList<Partido>();

	public Equipo(String nombre, String liga) {
		this.Nombre = nombre;
		this.Liga = liga;
	}

	public String getLiga() {
		return Liga;
	}

	public void setLiga(String liga) {
		Liga = liga;
	}

	public String getNombre() {
		return Nombre;
	}
	
	public void AgregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public ArrayList<Partido> getPartido() {
		return partidos;
	}
	
}
