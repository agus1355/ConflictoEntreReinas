import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Tablero {
	private ArrayList<Reina> reinas = new ArrayList<Reina>();
	private ArrayList<ArrayList<LinkedList<Reina>>> array = new ArrayList<ArrayList<LinkedList<Reina>>>(4);
	
	public Tablero(ArrayList<String> datos) {
		array.add(new ArrayList<LinkedList<Reina>>());
		array.add(new ArrayList<LinkedList<Reina>>());
		array.add(new ArrayList<LinkedList<Reina>>());
		array.add(new ArrayList<LinkedList<Reina>>());
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
		
		//System.out.println("filas  " + this.array.get(0));
		//System.out.println("col  " + this.array.get(1));
		//System.out.println("diag1  " + this.array.get(2));
		//System.out.println("diag2  " + this.array.get(3));
	}

	public ArrayList<String> buscarConflictos()
	{
		for (Iterator<ArrayList<LinkedList<Reina>>> iterator = array.iterator(); iterator.hasNext();) {
			ArrayList<LinkedList<Reina>> arrayList = (ArrayList<LinkedList<Reina>>) iterator.next();
			for (Iterator<LinkedList<Reina>> iterator1 = arrayList.iterator(); iterator1.hasNext();) {
				LinkedList<Reina> reinas = iterator1.next();
				for (int i = 0; i < reinas.size(); i++) {
					if(i-1 >= 0)
					{					
						reinas.get(i).agregarConflicto(reinas.get(i-1));
					}
					if(i+1 < reinas.size())
					{
						reinas.get(i).agregarConflicto(reinas.get(i+1));
					}
				}
			}
			
		}
		System.out.println();
		System.out.println();
		ArrayList<String> salida = new ArrayList<String>();
		String dato;
		for (Reina reina : this.reinas) {
			ArrayList<Reina> conflictos = reina.getConflictos();
			conflictos.sort(new ReinaComparatorId());
			dato = "";
			for (Reina conflicto : conflictos) {
				dato = dato + conflicto.getNumId() + " ";
			}
			salida.add(reina.getCantConflictos() + " " + dato);
		}
		
		return salida;
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
				this.array.get(0).add(lista);
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
				this.array.get(1).add(lista);
		}
	}
	
    private void generarConflictosDiagonales(Reina[][] m)
    {	
    	int i = m.length-2,
    		j = 0,
    		fila = 1,
    		cantE = 2,
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

    	this.array.get(2).add(lista);
    }
    
    private void generarConflictosDiagonalesInvertidas(Reina[][] m)
    {	
    	int i = m.length-2,
    		j = m.length-1,
    		fila = 1,
    		cantE = 2,
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

    	this.array.get(3).add(lista);
    }
}


