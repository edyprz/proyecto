import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Visitante implements Persona, Serializable {
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;

	@Override
	public String toString() {
		return nombre+" "+apellidoPaterno+" "+apellidoMaterno+" "+correo;
	}

	public void registro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe el nombre:");
		this.nombre = scan.nextLine();
		System.out.println("Escribe el apellido paterno:");
		this.apellidoPaterno = scan.nextLine();
		System.out.println("Escribe el apellid materno:");
		this.apellidoMaterno = scan.nextLine();
		System.out.println("Escribe el correo:");
		this.correo = scan.nextLine();
	}

	public Visitante() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public static Visitante getVisitante(List<Visitante> lista, String clave) {
    	Visitante ret = null;
    	Iterator<Visitante> iter = lista.iterator();
    	while(iter.hasNext()) {
    		Visitante elemento = iter.next();
    		if(elemento.getNombre().equalsIgnoreCase(clave))
    			ret = elemento;
    	}
    	return ret;
    }

}
