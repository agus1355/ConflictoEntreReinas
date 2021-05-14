
public class Reina {
	private int numId;
	private int cantConflictos;
	private String conflictos;
	
	public Reina(int id) {
		this.cantConflictos = 0;
		this.conflictos = "";
		this.numId = id;
	}
	
	public void agregarConflicto(final Reina r1)
	{
		this.conflictos = this.conflictos + r1.numId + " ";
		this.cantConflictos++;
	}

	public int getCantConflictos() {
		return cantConflictos;
	}

	public String getConflictos() {
		return conflictos;
	}
	
	public int getNumId() {
		return numId;
	}
}
