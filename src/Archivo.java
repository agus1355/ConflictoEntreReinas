import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
	public ArrayList<String> leer(String ruta)
	{
		FileReader fr = null;
		Scanner sc = null;
		ArrayList<String> datos = new ArrayList<String>();
		try {
			fr = new FileReader(ruta);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		
		sc = new Scanner(fr);
		
		while(sc.hasNext())
		{
			datos.add(sc.nextLine());
		}
		
		sc.close();
		
		return datos;
	}
}
