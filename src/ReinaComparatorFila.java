import java.util.Comparator;

public class ReinaComparatorFila implements Comparator<Reina>{

	@Override
	public int compare(Reina o1, Reina o2) {
		return Integer.compare(o1.getPosicion().getY(),o2.getPosicion().getY());
	}

}
