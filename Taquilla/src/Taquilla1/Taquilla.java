package Taquilla1;
import java.util.ArrayList;
import java.util.Date;

public class Taquilla {
	
	private ArrayList<Estadio> estadios = new ArrayList<Estadio>();
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private ArrayList<Partido> partidos = new ArrayList<Partido>();
	private ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void CrearCuenta(String nombre, String correo, String cedula, String telefono, Date fechaCump) {
		boolean existe = false;
		
		Persona persona = new Persona(nombre,correo,cedula,telefono,fechaCump);
		
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getCedula().equals(persona.getCedula())) {
				existe = true;
				break;
			}
		}
		
		if(existe == false) {
			personas.add(persona);
		}
		else {
			//ERROR DE QUE YA EXISTE LA CUENTA
		}
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void CrearEstadio(String nombre, String direccion, int capacidad) {
		boolean existe = false;
		
		Estadio estadio = new Estadio(nombre, direccion, capacidad);
		
		for(int i = 0; i < estadios.size(); i++) {
			if(estadios.get(i).getNombre().equalsIgnoreCase(estadio.getNombre())) {
				existe = true;
				break;
			}
		}
		if(existe == false) {
			estadios.add(estadio);
		}
		else {
			//ERROR DE ESTADIO YA EXISTE
		}
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void CrearTribuna(String nombreEst, String nombreTri, int precio, int capacidad) {
		boolean existeEst = false;
		boolean excedeTam = true;
		boolean tribunaExiste = false;
		int suma = 0;
		
		for( int i = 0; i < estadios.size(); i++) {
			if(estadios.get(i).getNombre().equalsIgnoreCase(nombreEst)) {
				for(int j = 0; j < estadios.get(i).getTribuna().size();j++) {
					suma = suma + estadios.get(i).getTribuna().get(j).getCapacidad();
				}
				
				if(suma + capacidad < estadios.get(i).getCapacidad()) {
					Tribuna tribuna = new Tribuna(nombreTri,precio, capacidad);
					for(int j = 0; j < estadios.get(i).getTribuna().size();j++) {
						if(estadios.get(i).getTribuna().get(j).getNombre().equalsIgnoreCase(tribuna.getNombre())){
							tribunaExiste = true;
							break;
						}
					}
					if(tribunaExiste == false) {
						estadios.get(i).AgregarTribuna(tribuna);
					}
					excedeTam = false;
				}
				existeEst = true;
				break;
			}
		}
		if(existeEst == false) {
			//ERROR DE QUE NO EXISTE ESTADIO
		}
		if(excedeTam == true && existeEst == true) {
			//ERROR DE QUE EXCEDE LA CAPACIDAD DEL ESTADIO
		}
		if(tribunaExiste == true) {
			//ERROR DE QUE YA EXISTE LA TRIBUNA
		}
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void CrearPuesto(String nombreEst, String nombreTri, int numero, String letra) {
		boolean existeEst = false;
		boolean existeTri = false;
		boolean hayespacio = false;
		boolean existePuesto = false;
		
		for(int i = 0; i < estadios.size(); i++) {
			if(estadios.get(i).getNombre().equalsIgnoreCase(nombreEst)) {
				for(int j = 0; j < estadios.get(i).getTribuna().size(); j++) {
					if(estadios.get(i).getTribuna().get(j).getNombre().equalsIgnoreCase(nombreTri)) {
						if(estadios.get(i).getTribuna().get(j).getPuesto().size() < estadios.get(i).getTribuna().get(j).getCapacidad()) {
							Puesto puesto = new Puesto(numero, letra);
							for(int k= 0; k < estadios.get(i).getTribuna().get(j).getPuesto().size();k++) {
								if(estadios.get(i).getTribuna().get(j).getPuesto().get(k).getLetra().equalsIgnoreCase(puesto.getLetra()) && 
										estadios.get(i).getTribuna().get(j).getPuesto().get(k).getNumero() == puesto.getNumero()) {
									existePuesto = true;
									break;
								}
							}
							if(existePuesto == false) {
								estadios.get(i).getTribuna().get(j).AgregarPuesto(puesto);
							}
							hayespacio = true;
						}
						existeTri = true;
						break;
					}
				}
				existeEst = true;
				break;
			}
		}
		if(existeEst == false) {
			//ERROR NO EXISTE ESTADIO
		}
		if(existeTri == false) {
			//ERROR NO EXISTE TRIBUNA
		}
		if(hayespacio == false) {
			//ERROR NO HAY MAS ESPACIO EN LA TRIBUNA PARA CREAR MAS PUESTOS
		}
		if(existePuesto == true) {
			//ERROR YA EXISTE EL PUESTO
		}
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void CrearEquipo(String nombre, String liga) {
		boolean existeEq = false;
		
		Equipo equipo = new Equipo(nombre,liga);
		for(int i = 0; i < equipos.size();i++) {
			if(equipos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				existeEq = true;
				break;
			}
		}
		if(existeEq == false) {
			equipos.add(equipo);
		}
		if(existeEq == true) {
			//ERROR DE QUE EL EQUIPO YA EXISTE
		}
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void Crearpartidos(String nombreEst, String nombreEq1, String nombreEq2, Date fechaPart, int tarifa, String copa) {
		boolean existeEst = false;
		boolean existeEq1 = false;
		boolean existeEq2 = false;
		boolean existePart = false;
		Equipo equipo1 = null; 
		Equipo equipo2 = null;
		Estadio estadio = null;
		
		for( int i = 0 ; i < estadios.size(); i++) {
			if(estadios.get(i).getNombre().equalsIgnoreCase(nombreEst)) {
				existeEst = true;
				estadio = estadios.get(i);
				break;
			}
		}
		
		for(int i = 0; i < equipos.size();i ++) {
			if(equipos.get(i).getNombre().equalsIgnoreCase(nombreEq1)) {
				existeEq1 = true;
				equipo1 = equipos.get(i);
				break;
			}
		}
			
		for(int i = 0; i < equipos.size();i ++) {
			if(equipos.get(i).getNombre().equalsIgnoreCase(nombreEq2)) {
				existeEq2 = true;
				equipo2 = equipos.get(i);
				break;
			}
		}
		if(existeEq1 == true && existeEq2 == true && existeEst == true) {
			Partido partido = new Partido(estadio,fechaPart, tarifa, copa, equipo1, equipo2);
			for (int i = 0; i < partidos.size(); i++) {
				if(partidos.get(i).getFecha().equals(fechaPart) && partidos.get(i).getEstadio().getNombre().equalsIgnoreCase(estadio.getNombre())) {
					existePart = true;
					break;
				}
			}
			if(existePart == false) {
				partidos.add(partido);
				equipo1.AgregarPartido(partido);
				equipo2.AgregarPartido(partido);
				estadio.AgregarPartido(partido);
			}
		}	
		if(existeEst == false) {
			//ERROR DE NO EXISTE ESTADIO
		}
		if(existeEq1 == false || existeEq2 == false) {
			//ERROR NO EXISTE ALGUNO DE LOS DOS EQUIPOS
		}
		if(existePart == true) {
			//ERROR YA EXISTE EL PARTIDO
		}
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void CrearAbono(String cedula, String nombreTri, String nombreEst, String letra,int numero) {
		boolean existeEst = false;
		boolean existeTri = false;
		boolean existePer = false;
		boolean existePuesto = false;
		
		Persona persona = null;
		Estadio estadio = null;
		Tribuna tribuna = null;
		Puesto puesto = null;
		
		for(int i = 0; i < estadios.size();i++) {
			if(estadios.get(i).getNombre().equalsIgnoreCase(nombreEst)) {
				estadio = estadios.get(i);
				existeEst = true;
				break;
			}
		}
		
		if(existeEst == true) {
			for(int i = 0; i < estadio.getTribuna().size();i++) {
				if(estadio.getTribuna().get(i).getNombre().equalsIgnoreCase(nombreTri)) {
					tribuna = estadio.getTribuna().get(i);
					existeTri = true;
					break;
				}
			}
		}
		
		if(existeTri = true) {
			for(int i = 0; i < tribuna.getPuesto().size();i++) {
				if(tribuna.getPuesto().get(i).getLetra().equalsIgnoreCase(letra) && tribuna.getPuesto().get(i).getNumero() == numero) {
					puesto = tribuna.getPuesto().get(i);
					existePuesto = true;
					break;
				}
			}
		}
		
		
		for(int i = 0; i < personas.size();i++) {
			if(personas.get(i).getCedula().equalsIgnoreCase(cedula)) {
				persona = personas.get(i);
				existePer = true;
				break;
			}
		}
		
		if(existePuesto == true && existePer == true) {
			persona.AgregarAbono(estadio, puesto, tribuna);
			tribuna.AgregarPuestoAbono(puesto);
		}
		
		if(existeEst == false) {
			//ERROR NO EXISTE EL ESTADIO
		}
		if(existeTri == false) {
			//ERROR NO EXISTE LA TRIBUNA
		}
		if(existePuesto == false) {
			//ERROR NO EXISTE EL PUESTO
		}
		if(existePer == false) {
			//ERROR NO EXISTE LA PERSONA
		}
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	

}
