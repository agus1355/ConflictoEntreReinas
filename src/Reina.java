import java.util.ArrayList;

public class Reina {
	private int numId;
	private int cantConflictos;
	private ArrayList<Reina> conflictos;
	private Posicion posicion;
	
	public Reina(int id,int x,int y) {
		this.cantConflictos = 0;
		this.conflictos = new ArrayList<Reina>();
		this.numId = id;
		this.posicion = new Posicion(x,y);
	}

	public void agregarConflicto(final Reina r1)
	{
		this.conflictos.add(r1);
		this.cantConflictos++;
	}
	
	public int getCantConflictos() {
		return cantConflictos;
	}

	public final ArrayList<Reina> getConflictos() {
		return conflictos;
	}
	
	public int getNumId() {
		return numId;
	}

	public final Posicion getPosicion() {
		return this.posicion;
	}
	
	@Override
	public String toString() {
		return "reina " + this.numId;
	}
}
