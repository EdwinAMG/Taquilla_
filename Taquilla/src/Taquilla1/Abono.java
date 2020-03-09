package Taquilla1;
import java.util.ArrayList;

public class Abono {
	private Puesto puesto;
	private Estadio estadio;
	private Tribuna tribuna;
	private ArrayList<Partido> PartidosVistos = new ArrayList<Partido>();
	
	public Abono(Puesto puesto, Estadio estadio, Tribuna tribuna) {
		this.puesto = puesto;
		this.estadio = estadio;
		this.tribuna = tribuna;
	}

	public ArrayList<Partido> getPartidosVistos() {
		return PartidosVistos;
	}

	public void AgregarPartidosVistos(Partido partidosVistos) {
		PartidosVistos.add(partidosVistos);
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public Tribuna getTribuna() {
		return tribuna;
	}

}
