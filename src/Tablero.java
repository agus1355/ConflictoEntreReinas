import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Tablero {
	private ArrayList<Reina> reinas;
	private HashMap<Integer,OrderedList> filas;
	private HashMap<Integer,OrderedList> columnas;
	private HashMap<Integer,OrderedList> diag;
	private HashMap<Integer,OrderedList> diagInvertidas;
	private BuscadorDeConflictos buscador;

	public Tablero(ArrayList<Reina> reinas) {
		
		this.filas = new HashMap<Integer,OrderedList>();
		this.columnas = new HashMap<Integer,OrderedList>();
		this.diag = new HashMap<Integer,OrderedList>();
		this.diagInvertidas = new HashMap<Integer,OrderedList>();
		
		this.buscador = new BuscadorDeConflictos();
		
		this.reinas = reinas;
		
		this.rellenarMaps();
		
//		System.out.println(this.filas);
//		System.out.println(this.columnas);
//		System.out.println(this.diag);
//		System.out.println(this.diagInvertidas);
	}
	
	public final ArrayList<Reina> buscarConflictos() {
		this.buscador.generarConflictos(this.filas);
		this.buscador.generarConflictos(this.columnas);
		this.buscador.generarConflictos(this.diag);
		this.buscador.generarConflictos(this.diagInvertidas);
		
		this.ordenarConflictos();
		
		return this.reinas;
	}
	
	private void ordenarConflictos()
	{
		for (Reina reina : reinas) {
			reina.getConflictos().sort(new ReinaComparatorId());
		}
	}
	
	private void rellenarMaps()
	{
		for (Iterator<Reina> iterator = reinas.iterator(); iterator.hasNext();) {
			Reina reina = (Reina) iterator.next();
			this.insertarEnFila(reina);
			this.insertarEnColumna(reina);
			this.insertarEnDiagonal(reina);
			this.insertarEnDiagonalInvertida(reina);
		}
	}
	
	

	private void insertarEnDiagonal(Reina r) {
		int diagKey = r.getPosicion().getX() - r.getPosicion().getY();
		if(this.diag.containsKey(diagKey))
		{
			this.diag.get(diagKey).insertarEnOrden(r, new ReinaComparatorDiagonal());
		}
		else
		{	
			OrderedList nuevaLista = new OrderedList();
			nuevaLista.insertarEnOrden(r,new ReinaComparatorFila());
			this.diag.put(diagKey,nuevaLista);
		}			
	}

	private void insertarEnDiagonalInvertida(Reina r) {
		int diagKey = r.getPosicion().getX() + r.getPosicion().getY();
		if(this.diagInvertidas.containsKey(diagKey))
		{
			this.diagInvertidas.get(diagKey).insertarEnOrden(r, new ReinaComparatorDiagonal());
		}
		else
		{	
			OrderedList nuevaLista = new OrderedList();
			nuevaLista.insertarEnOrden(r,new ReinaComparatorFila());
			this.diagInvertidas.put(diagKey,nuevaLista);
			
		}	
		
	}

	private void insertarEnColumna(Reina r) {
		int columnaKey = r.getPosicion().getY();
		if(this.columnas.containsKey(columnaKey))
		{
			this.columnas.get(columnaKey).insertarEnOrden(r, new ReinaComparatorColumna());
		}
		else
		{	
			OrderedList nuevaLista = new OrderedList();
			nuevaLista.insertarEnOrden(r,new ReinaComparatorColumna());
			this.columnas.put(columnaKey,nuevaLista);	
		}
	
	}

	private void insertarEnFila(Reina r) {
		int filaKey = r.getPosicion().getX();
		if(this.filas.containsKey(filaKey))
		{
			this.filas.get(filaKey).insertarEnOrden(r, new ReinaComparatorFila());
		}
		else
		{	
			OrderedList nuevaLista = new OrderedList();
			nuevaLista.insertarEnOrden(r,new ReinaComparatorFila());
			this.filas.put(filaKey,nuevaLista);
			
		}
	}

}


