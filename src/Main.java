
public class Main {
	
	public static void main(String[] args) {
		long time = System.nanoTime();
		Archivo a = new Archivo();
		
		Tablero t = a.generarTablero("in\\caso_pdf.in");
		
		a.escribirSalida(t.buscarConflictos(), "out\\caso_pdf.out");
		
		System.out.println((System.nanoTime()-time)*Math.pow(10,-6));
	}
}
