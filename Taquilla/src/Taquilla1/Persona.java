package Taquilla1;
import java.util.Date;
import java.util.ArrayList;

public class Persona {
	
	private String Nombre, Correo, Telefono, Cedula;
	private Date FechaCump;
	private ArrayList<Abono> Abono = new ArrayList<Abono>();
	
	public Persona(String nombre, String correo, String cedula, String telefono, Date fechaCump) {
		this.Nombre = nombre;
		this.Correo = correo;
		this.Cedula = cedula;
		this.Telefono = telefono;
		this.FechaCump = fechaCump;
	}
	
	public void AgregarAbono(Estadio estadio, Puesto  puesto, Tribuna tribuna) {
		Abono abono = new Abono(puesto, estadio, tribuna);
		Abono.add(abono);
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getCedula() {
		return Cedula;
	}

	public Date getFechaCump() {
		return FechaCump;
	}
	
	
}
