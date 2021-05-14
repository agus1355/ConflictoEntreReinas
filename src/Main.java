import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	//ArrayList<ArraList<Reina>> matriz = new ArrayList<ArraList<Reina>>();
	
	public static void main(String[] args) {
		Reina[][] matriz = new Reina[2][2];
		
//		Reina r1 = new Reina(1);
//		Reina r2 = new Reina(2);
//		Reina r3 = new Reina(3);
//		Reina r4 = new Reina(4);
//		matriz[0][0] = r1;
//		matriz[0][1] = r2;
//		matriz[1][0] = r3;
//		matriz[1][1] = r4;
		
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz.length; j++) {
//				System.out.print(matriz[i][j].numId + " " );
//				matriz[i][j].numId = 2;
//			}
//			System.out.println();
//		}
//		System.out.println(r1.numId);
//		System.out.println(r2.numId);
//		System.out.println(r3.numId);
//		System.out.println(r4.numId);
		
//		matriz[0][0] = new Reina(1);
//		matriz[0][1] = new Reina(2);
//		matriz[1][0]= new Reina(3);
//		matriz[1][1]= new Reina(4);
//		Reina r1 = matriz[0][0];
//		Reina r2 = matriz[0][1];
//		Reina r3 = matriz[1][0];
//		Reina r4 = matriz[1][1];
//		
//		r1.numId = 2;
//		r2.numId = 2;
//		r3.numId = 2;
//		r4.numId = 2;
//		
//		for (int i = 0; i < matriz.length; i++) {
//		for (int j = 0; j < matriz.length; j++) {
//			System.out.print(matriz[i][j].numId + " " );
//		}
//		System.out.println();
		
		Archivo a = new Archivo();
		
		Tablero t = new Tablero(a.leer("in\\caso_normal.in"));
		
		a.escribir(t.buscarConflictos(),"out\\caso_normal.out");
	}
}
