import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ayudante extends Alumno implements Academico, Serializable{
	
	private String numEconomico;
	
	@Override
	public void registroEmpleado() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe el numero economico:");
		this.numEconomico = scan.nextLine();
	}
	
	@Override
	public String toString() {
		super.toString();
		return getNombre()+" "+getApellidoPaterno()+" "+getApellidoMaterno()+" "+getCorreo()+" "
				+getMatricula()+" "+getCarrera()+" "+numEconomico;
	}

	public Ayudante() {
		super();
	}

	public String getNumEconomico() {
		return numEconomico;
	}

	public void setNumEconomico(String numEconomico) {
		this.numEconomico = numEconomico;
	}
	
	public static Ayudante getAyudante(List<Ayudante> lista, String clave, String decision) {
    	Ayudante ret = null;
    	Iterator<Ayudante> iter = lista.iterator();
    	while(iter.hasNext()) {
    		Ayudante elemento = iter.next();
    		if (decision.equalsIgnoreCase("numero economico")) {
    			if(elemento.getNumEconomico().equalsIgnoreCase(clave))
    				ret = elemento;
    		} else if(decision.equalsIgnoreCase("matricula")) {
    			if(elemento.getMatricula().equalsIgnoreCase(clave))
        			ret = elemento;
    		}
    	}
    	return ret;
    }
	
}
