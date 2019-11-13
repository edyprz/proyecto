import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Horario implements Serializable {

	private String clave;
	private String dias;
	private String iniHora;
	private String finHora;
	private Salon salon;
	private UEA uea;
	private Profesor prof;

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getIniHora() {
		return iniHora;
	}

	public void setIniHora(String iniHora) {
		this.iniHora = iniHora;
	}

	public String getFinHora() {
		return finHora;
	}

	public void setFinHora(String finHora) {
		this.finHora = finHora;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public UEA getUea() {
		return uea;
	}

	public void setUea(UEA uea) {
		this.uea = uea;
	}

	public Profesor getProf() {
		return prof;
	}

	public void setProf(Profesor prof) {
		this.prof = prof;
	}
	
	public void registro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe la clave del horario:");
		this.clave = scan.nextLine();
		System.out.println("Escribe los dias:");
		this.dias = scan.nextLine();
		System.out.println("Escribe la hora de inicio:");
		this.iniHora = scan.nextLine();
		System.out.println("Escribe la hora final:");
		this.finHora = scan.nextLine();
		System.out.println("Escribe el nombre del profesor:");
		String nombre = scan.nextLine();
		System.out.println("Escribe el apellido paterno del profesor:");
		String apellidoPaterno = scan.nextLine();
		System.out.println("Escribe el salon:");
		String salon = scan.nextLine();
		System.out.println("Escribe el nombre de la UEA:");
		String nombreUea = scan.nextLine();
		System.out.println("Escribe los creditos de la UEA:");
		int creditos = scan.nextInt();
		this.prof = new Profesor(nombre, apellidoPaterno);
		this.salon = new Salon(salon);
		this.uea = new UEA(nombreUea, creditos);
	}
	
	public String toString() {
		return clave + " " + dias + " " + iniHora + " " + finHora + " " + 
				prof.getNombre() + " " + prof.getApellidoPaterno() + " " + 
				salon.getNombre() + " " + uea.getNombreUea() + " " + uea.getCreditos();
	}
	
	public static Horario getHorario(List<Horario> lista, String clave) {
    	Horario ret = null;
    	Iterator<Horario> iter = lista.iterator();
    	while(iter.hasNext()) {
    		Horario elemento = iter.next();
    		if(elemento.getClave().equalsIgnoreCase(clave))
    			ret = elemento;
    	}
    	return ret;
    }
	
}
