import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UEA implements Serializable {

	private String claveUea;
	private String nombreUea;
	private int creditos;
	
	public String getClaveUea() {
		return claveUea;
	}
	public void setClaveUea(String claveUea) {
		this.claveUea = claveUea;
	}
	public String getNombreUea() {
		return nombreUea;
	}
	public void setNombreUea(String nombreUea) {
		this.nombreUea = nombreUea;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public UEA(String nombreUea, int creditos) {
		super();
		this.nombreUea = nombreUea;
		this.creditos = creditos;
	}
	
	public UEA() {
		super();
	}
	
	public void registro() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe la clave de UEA:");
		this.claveUea = scan.nextLine();
		System.out.println("Escribe el nombre:");
		this.nombreUea = scan.nextLine();
		System.out.println("Escribe los creditos:");
		this.creditos = scan.nextInt();
	}
	
	public String toString() {
		return claveUea+" "+nombreUea+" "+creditos;
	}
	
	public static UEA getUEA(List<UEA> lista, String clave) {
    	UEA ret = null;
    	Iterator<UEA> iter = lista.iterator();
    	while(iter.hasNext()) {
    		UEA elemento = iter.next();
    		if(elemento.getClaveUea().equalsIgnoreCase(clave))
    			ret = elemento;
    	}
    	return ret;
    }
	
}
