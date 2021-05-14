import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			System.err.println("Archivo no encontrado");
		}
		
		sc = new Scanner(fr);
		
		while(sc.hasNext())
		{
			datos.add(sc.nextLine());
		}
		
		sc.close();
		
		return datos;
	}
	
	public void escribir(ArrayList<String> salida,String ruta)
	{
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta);
		} catch (IOException e) {
			System.err.println("Ruta no existente");
		}
		pw = new PrintWriter(fw);
		
		for (String string : salida) {
			pw.println(string);
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.err.println("Error al cerrar archivo");
		}
		pw.close();
	}
}
