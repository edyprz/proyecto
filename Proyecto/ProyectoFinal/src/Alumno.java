import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Alumno implements Persona, Serializable {

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String carrera;
	private String matricula;
	private List<Horario> horario;

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public Alumno() {
		super();
	}

	@Override
	public String toString() {
		return nombre+" "+apellidoPaterno+" "+apellidoMaterno+" "+correo+" "+carrera+" "+matricula+"\n"+horario;
	}

	public void registro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe el nombre:");
		this.nombre = scan.nextLine();
		System.out.println("Escribe el apellido paterno:");
		this.apellidoPaterno = scan.nextLine();
		System.out.println("Escribe el apellido materno:");
		this.apellidoMaterno = scan.nextLine();
		System.out.println("Escribe el correo:");
		this.correo = scan.nextLine();
		System.out.println("Escribe la carrera:");
		this.carrera = scan.nextLine();
		System.out.println("Escribe la matricula:");
		this.matricula = scan.nextLine();
		this.horario = new ArrayList<Horario>();
	}
	
	public static Alumno getAlumno(List<Alumno> lista, String clave) {
    	Alumno ret = null;
    	Iterator<Alumno> iter = lista.iterator();
    	while(iter.hasNext()) {
    		Alumno elemento = iter.next();
    		if(elemento.getMatricula().equalsIgnoreCase(clave))
    			ret = elemento;
    	}
    	return ret;
    }
	
}
