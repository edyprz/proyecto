import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Serializacion<E> {
	
	public void serializaLista(String arch, List<E> list) {
		try {
			FileOutputStream fs = new FileOutputStream(arch);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(list);
			
			os.close();
			//fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<E> deserializaLista(String arch) {
		List<E> res = null;
			try {
				FileInputStream fs = new FileInputStream(arch);
				ObjectInputStream is = new ObjectInputStream(fs);
				res =(List<E>) is.readObject();
				is.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return res;
	}
	
}
