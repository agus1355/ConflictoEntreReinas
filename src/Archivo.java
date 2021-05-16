import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
	public Tablero generarTablero(String ruta)
	{
		FileReader fr = null;
		Scanner sc = null;
		ArrayList<Reina> reinas = new ArrayList<Reina>();
		int numRegistro,posX,posY;
		
		try {
			fr = new FileReader(ruta);
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		}
		
		sc = new Scanner(fr);
		sc.nextLine();
		numRegistro = 1; 
		while(sc.hasNext())
		{
			posX = sc.nextInt();
			posY = sc.nextInt();
			reinas.add(new Reina(numRegistro,posX,posY));
			numRegistro++;
		}
		
		sc.close();
		
		return new Tablero(reinas);
	}
	
	public void escribirSalida(ArrayList<Reina> reinas,String ruta)
	{
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ruta);
		} catch (IOException e) {
			System.err.println("Ruta no existente");
		}
		pw = new PrintWriter(fw);
		
		for (Reina reina : reinas) {
			pw.print(reina.getCantConflictos() + " ");
			for (Reina conflicto : reina.getConflictos()) {
				pw.print(conflicto.getNumId() + " ");
			}
			pw.println();
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.err.println("Error al cerrar archivo");
		}
		pw.close();
	}
}
