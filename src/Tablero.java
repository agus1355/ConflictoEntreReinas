import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Tablero {
	private ArrayList<Reina> reinas = new ArrayList<Reina>();
	private HashMap<Integer,LinkedList<Reina>> filas = new HashMap<Integer,LinkedList<Reina>>();
	private HashMap<Integer,LinkedList<Reina>> columnas = new HashMap<Integer,LinkedList<Reina>>();
	private HashMap<Integer,LinkedList<Reina>> diag1 = new HashMap<Integer,LinkedList<Reina>>();
	private HashMap<Integer,LinkedList<Reina>> diag2 = new HashMap<Integer,LinkedList<Reina>>();
	
	public Tablero(ArrayList<String> datos) {
		int x,y,tam;
		Reina reina = null;
		Scanner sc = new Scanner(datos.get(0));
		tam = sc.nextInt();
		Reina[][] matriz = new Reina[tam][tam];
		
		for (int i = 1; i < datos.size(); i++) {
			sc = new Scanner(datos.get(i));
			x = sc.nextInt()-1;
			y = sc.nextInt()-1;
			reina = new Reina(i);
			this.reinas.add(reina);
			matriz[x][y] = reina;
		}
		
		this.generarConflictosFilas(matriz);
		this.generarConflictosColumnas(matriz);
		this.generarConflictosDiagonales(matriz);
		this.generarConflictosDiagonalesInvertidas(matriz);
		
//		System.out.println("filas  " + this.filas);
//		System.out.println("col  " + this.columnas);
//		System.out.println("diag1  " + this.diag1);
//		System.out.println("diag2  " + this.diag2);
	}

	private void generarConflictosFilas(Reina[][] matriz) {
		LinkedList<Reina>lista = null;
		for (int i = 0; i < matriz.length; i++) {
			lista = new LinkedList<Reina>();
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] != null)
					lista.add(matriz[i][j]);
			}
			if(!lista.isEmpty())
				this.filas.put(i, lista);
		}
		
	}

	private void generarConflictosColumnas(Reina[][] matriz) {
		LinkedList<Reina>lista = null;
		for (int i = 0; i < matriz.length; i++) {
			lista = new LinkedList<Reina>();
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[j][i] != null)
					lista.add(matriz[j][i]);
			}
			if(!lista.isEmpty())
				this.columnas.put(i, lista);
		}
	}
	
    private void generarConflictosDiagonales(Reina[][] m)
    {	
    	int i = m.length-2,
    		j = 0,
    		fila = 1,
    		cantE = 2,
    		diagonales = m.length*2-3,
    		diagonalActual = 0;
    	
    	while(j < m.length-1)
    	{
    		this.obtenerDiagonal(m,i,j,cantE,diagonalActual);
    		if(i != 0)
    		{
    			i--;
    		}
    		else
    		{
    			j++;
    		}
    		fila++;
    		if(fila>=m.length)
    		{
    			cantE--;
    		}
    		else
    		{
    			cantE++;
    		}
    	}
    }

    private void obtenerDiagonal(Reina[][] m,int filaIni,int colIni,int cantE,int diag)
    {
    	LinkedList<Reina>lista = new LinkedList<Reina>();
    	for(int i = 0; i < cantE && filaIni < m.length && colIni < m.length; i++,filaIni++,colIni++)
    	{
    		if(m[filaIni][colIni] != null)
    		{
    			lista.add(m[filaIni][colIni]);
    		}
    	}

    	this.diag1.put(diag, lista);
    }
    
    private void generarConflictosDiagonalesInvertidas(Reina[][] m)
    {	
    	int i = m.length-2,
    		j = m.length-1,
    		fila = 1,
    		cantE = 2,
    		diagonales = m.length*2-3,
    		diagonalActual = 0;
    	
    	while(j > 0)
    	{
    		this.obtenerDiagonalInvertida(m,i,j,cantE,diagonalActual);
    		if(i != 0)
    		{
    			i--;
    		}
    		else
    		{
    			j--;
    		}
    		fila++;
    		if(fila>=m.length)
    		{
    			cantE--;
    		}
    		else
    		{
    			cantE++;
    		}
    	}
    }

    private void obtenerDiagonalInvertida(Reina[][] m,int filaIni,int colIni,int cantE,int diag)
    {
    	LinkedList<Reina>lista = new LinkedList<Reina>();
    	for(int i = 0; i < cantE && filaIni < m.length && colIni < m.length; i++,filaIni++,colIni--)
    	{
    		if(m[filaIni][colIni] != null)
    		{
    			lista.add(m[filaIni][colIni]);    			
    		}
    	}

    	this.diag2.put(diag, lista);
    }
}


