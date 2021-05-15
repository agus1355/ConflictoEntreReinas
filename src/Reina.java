import java.util.ArrayList;

public class Reina {
	private int numId;
	private int cantConflictos;
	private ArrayList<Reina> conflictos;
	
	public Reina(int id) {
		this.cantConflictos = 0;
		this.conflictos = new ArrayList<Reina>();
		this.numId = id;
	}
	
//	public void agregarConflicto(final Reina r1)
//	{
//		this.conflictos = this.conflictos + r1.numId + " ";
//		this.cantConflictos++;
//	}

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
}
