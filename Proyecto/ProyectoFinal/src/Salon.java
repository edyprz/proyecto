import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Salon implements Serializable {

	private String nombre;
	private String ubicacion;
	
	public Salon() {
		super();
	}

	public Salon(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void registro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe el nombre:");
		this.nombre = scan.nextLine();
		System.out.println("Escribe la ubicacion:");
		this.ubicacion = scan.nextLine();
	}
	
	public String toString() {
		return nombre+" "+ubicacion;
	}
	
	public static Salon getSalon(List<Salon> lista, String clave) {
    	Salon ret = null;
    	Iterator<Salon> iter = lista.iterator();
    	while(iter.hasNext()) {
    		Salon elemento = iter.next();
    		if(elemento.getNombre().equalsIgnoreCase(clave))
    			ret = elemento;
    	}
    	return ret;
    }
	
}
