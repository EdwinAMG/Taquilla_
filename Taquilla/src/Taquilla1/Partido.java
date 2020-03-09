package Taquilla1;
import java.util.Date;

public class Partido {
	
	private Equipo equipo1, equipo2;
	private Estadio Estadio;
	private Date Fecha;
	private int Tarifa;
	private String Copa;
	
	public Partido(Estadio estadio, Date fecha, int tarifa, String copa, Equipo equipo1, Equipo equipo2) {
		this.Estadio = estadio;
		this.Fecha = fecha;
		this.Tarifa = tarifa;
		this.Copa = copa;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2; 
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getTarifa() {
		return Tarifa;
	}

	public void setTarifa(int tarifa) {
		Tarifa = tarifa;
	}

	public String getCopa() {
		return Copa;
	}

	public void setCopa(String copa) {
		Copa = copa;
	}

	public Estadio getEstadio() {
		return Estadio;
	}
	
	

}
